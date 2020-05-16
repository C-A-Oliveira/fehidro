package br.unisantos.fehidro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "tb_criterio_avaliacao")
@Entity
@NamedQueries({
	@NamedQuery(name = "CriterioAvaliacao.listarTodos",
			    query = "select c from CriterioAvaliacao c"),
	
	@NamedQuery(name = "CriterioAvaliacao.consultarPorId",
    			query = "select c from CriterioAvaliacao c where c.id=?1"),
})
public class CriterioAvaliacao extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	@Column(name = "nm_titulo")
	private String titulo;
	
	@Column(name = "nr_pontuacao")
	private int pontuacao;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pontuacao_id")
	private List<Pontuacao> pontuacoes = new ArrayList<Pontuacao>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "subcriterio_id")
	private List<SubcriterioAvaliacao> subCriterio = new ArrayList<SubcriterioAvaliacao>();

}
