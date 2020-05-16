package br.unisantos.fehidro.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.unisantos.fehidro.model.AbstractEntity;

@Table(name = "tb_ctpg")
@Entity
public class CTPG extends AbstractEntity {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "dt_inicio_mandato")
	private Date DataInicioMandato;
	
	@Column(name = "bt_titular")
	private boolean Titular;
	
	@OneToOne(cascade = CascadeType.ALL)
	@Column(name="usuario_id")
	private Usuario usuario;
	

}
