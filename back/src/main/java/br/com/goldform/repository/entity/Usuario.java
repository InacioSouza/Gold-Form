package br.com.goldform.repository.entity;

import br.com.goldform.controller.form.UsuarioFORM;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private Integer idade;
	private String email;
	private String senha;

	@OneToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	public Usuario(UsuarioFORM usuarioForm) {
		this.nome = usuarioForm.nome();
		this.idade = usuarioForm.idade();
		this.email = usuarioForm.email();
		this.senha = usuarioForm.senha();
		this.endereco = new Endereco(usuarioForm.endereco());
	}
}
