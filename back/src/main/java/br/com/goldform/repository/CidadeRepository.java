package br.com.goldform.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.goldform.repository.entity.Cidade;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, Integer> {

	boolean existsByNome(String nome);

	Cidade findByNome(String nome);

}
