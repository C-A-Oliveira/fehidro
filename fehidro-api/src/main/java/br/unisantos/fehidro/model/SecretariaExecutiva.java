package br.unisantos.fehidro.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "tb_secretaria_executiva")
@Entity
public class SecretariaExecutiva extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="ds_matricula")
	private String Matricula;
	
	@OneToOne(cascade = CascadeType.ALL)
	@Column(name="usuario_id")
	private Usuario usuario;

}
