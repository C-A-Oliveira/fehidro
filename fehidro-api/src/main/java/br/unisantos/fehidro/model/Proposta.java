package br.unisantos.fehidro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "tb_proposta")
@Entity
public class Proposta extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="nm_titulo")
	private String titulo;
	
	@Column(name="dt_proposta")
	private Date data;
	
	@Column(name="vl_proposta")
	private float valor;

}
