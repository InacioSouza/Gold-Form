package br.com.goldform.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.goldform.repository.entity.Estado;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Integer> {

	boolean existsByNome(String nome);

	Estado findByNome(String nome);

}
