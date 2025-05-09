package br.com.goldform.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.goldform.repository.entity.Usuario;

@Service
public class TokenService {

	@Value("${api.security.token.secret}")
	private String secret;

	public String generateToken(Usuario usuario) {

		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);

			String token = JWT.create()
					.withIssuer("gold-form")
					.withSubject(usuario.getEmail())
					.withExpiresAt(genExpirationDate())
					.sign(algorithm);

			return token;

		} catch (JWTCreationException exception) {
			throw new RuntimeException("Erro ao gerar token de acesso", exception);
		}
	}

	private Instant genExpirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);

			return JWT.require(algorithm)
					.withIssuer("gold-form")
					.build()
					.verify(token)
					.getSubject();

		} catch (JWTVerificationException exception) {
			return "";
		}
	}
}
