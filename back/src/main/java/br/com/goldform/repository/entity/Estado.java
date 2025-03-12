package br.com.goldform.repository.entity;

import br.com.goldform.controller.form.EstadoFORM;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private String uf;

	public Estado(EstadoFORM estadoForm) {
		this.nome = estadoForm.nome();
		this.uf = estadoForm.uf();
	}
}
