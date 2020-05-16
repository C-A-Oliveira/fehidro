package br.unisantos.fehidro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "tb_deliberacao")
@Entity
public class Deliberacao extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="aa_deliberacao")
	private int ano;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "etapa_id")
	private List<Etapa> etapas = new ArrayList<Etapa>();
	
}
