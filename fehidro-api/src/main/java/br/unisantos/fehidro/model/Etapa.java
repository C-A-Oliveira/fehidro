package br.unisantos.fehidro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "tb_etapa")
@Entity
public class Etapa extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="nr_etapa")
	private int numero;
	
	@Column(name="nm_titulo")
	private String titulo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cronograma_id")
	private List<Cronograma> cronogramas = new ArrayList<Cronograma>();
}
