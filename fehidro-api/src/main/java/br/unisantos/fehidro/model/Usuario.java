package br.unisantos.fehidro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name = "tb_usuario")
@Entity
@NamedQueries({
	@NamedQuery(name = "Usuario.listarTodos",
				query = "select u from Usuario u order by u.nome"),
	@NamedQuery(name = "Usuario.consultarPorId",
				query = "select u from Usuario u where u.id=?1"),
})
public class Usuario extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private long id;
	
	@Column(name = "nm_usuario")
	private String nome;
	
	@Column(name = "nr_cpf")
	private String CPF;
	
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	
	@Column(name = "ds_email")
	private String email;
	
	@Column(name = "ds_login")
	private String login;

	@Column(name = "ds_senha")
	private String senha;

/**	
	@Column(name = "id_instituicao")
	private String instituicao;
*/
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cpf) {
		CPF = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + getId() + "]";
	}
}
