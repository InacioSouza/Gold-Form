package br.com.goldform.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.goldform.repository.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

	boolean existsByEmail(String email);

}
