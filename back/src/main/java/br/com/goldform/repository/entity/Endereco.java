package br.com.goldform.repository.entity;

import br.com.goldform.controller.form.EnderecoFORM;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String cep;

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

	private String bairro;
	private String rua;
	private Integer numero;
	private String complemento;

	public Endereco(EnderecoFORM enderecoForm) {
		this.cep = enderecoForm.cep();
		this.cidade = new Cidade(enderecoForm.cidade());
		this.bairro = enderecoForm.bairro();
		this.rua = enderecoForm.rua();
		this.numero = enderecoForm.numero();
		this.complemento = enderecoForm.complemento();
	}

}
