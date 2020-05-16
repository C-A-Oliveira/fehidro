package br.unisantos.fehidro.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "tb_cronograma")
@Entity
public class Cronograma extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name="dt_inicio")
	private Date DataInicio;
	
	@Column(name="dt_fim")
	private Date DataFim;
}
