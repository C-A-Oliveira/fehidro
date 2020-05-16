package br.unisantos.fehidro.dao;

import java.util.List;

import br.unisantos.fehidro.model.CTPG;
import br.unisantos.fehidro.model.Usuario;

public class CTPGDAO extends DAOFactory<CTPG> {

	public CTPGDAO() {
		super(CTPG.class);
	}
	
	
	public void cadastrar(CTPG ctpg) {
		adicionar(ctpg);
	}
	
	public void atualizar(CTPG ctpg) {
		atualizar(ctpg);
	}

	public CTPG obter(long id) {
		return consultar(id);
	}

	public List<CTPG> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Usuario> listar(CTPG ctpg) {
		// TODO Auto-generated method stub
		return null;
	}	
}
