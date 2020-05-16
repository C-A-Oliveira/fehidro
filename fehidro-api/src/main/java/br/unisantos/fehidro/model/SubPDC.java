package br.unisantos.fehidro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "tb_subpdc")
@Entity
public class SubPDC extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="cd_subpdc")
	private int codigo;
	
	@Column(name="nm_titulo")
	private String titulo;

}
