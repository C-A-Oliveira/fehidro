package br.unisantos.fehidro.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "tb_pdc")
@Entity
public class PDC extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name="cd_pdc")
	private int codigo;
	
	@Column(name="nm_titulo")
	private String titulo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "subpdc_id")
	private List<SubPDC> cronogramas = new ArrayList<SubPDC>();

}
