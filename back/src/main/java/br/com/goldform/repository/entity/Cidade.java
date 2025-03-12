package br.com.goldform.repository.entity;

import br.com.goldform.controller.form.CidadeFORM;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	public Cidade(CidadeFORM cidadeForm) {
		this.nome = cidadeForm.nome();
		this.estado = new Estado(cidadeForm.estado());
	}
}
