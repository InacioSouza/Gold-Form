package br.com.goldform.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.goldform.repository.entity.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public interface EnderecoRepository extends CrudRepository<Endereco, Integer> {

	boolean enderecoCadastrado(String cep, Integer numero);

	Endereco findByCepAndNumero();

}
