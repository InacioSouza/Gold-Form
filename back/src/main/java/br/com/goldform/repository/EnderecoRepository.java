package br.com.goldform.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.goldform.repository.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {

	@Query("""
			SELECT EXISTS (
				SELECT 1
				FROM Endereco end
				WHERE end.cep = :cep
				AND end.numero = :numero
			)
			""")
	boolean enderecoCadastrado(String cep, Integer numero);

	@Query("""
			SELECT  end
			FROM Endereco end
			WHERE end.cep = :cep
			AND end.numero = :numero
			""")
	Endereco enderecoPorCepENumero(String cep, Integer numero);

}
