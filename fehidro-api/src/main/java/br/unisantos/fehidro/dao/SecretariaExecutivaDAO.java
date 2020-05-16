package br.unisantos.fehidro.dao;

import java.util.List;

import br.unisantos.fehidro.model.SecretariaExecutiva;

public class SecretariaExecutivaDAO extends DAOFactory<SecretariaExecutiva> {

	public SecretariaExecutivaDAO() {
		super(SecretariaExecutiva.class);
	}
	
	
	public void cadastrar(SecretariaExecutiva secretariaExecutiva) {
		adicionar(secretariaExecutiva);
	}
	
	public void atualizar(SecretariaExecutiva secretariaExecutiva) {
		atualizar(secretariaExecutiva);
	}

	public SecretariaExecutiva obter(long id) {
		return consultar(id);
	}

	public List<SecretariaExecutiva> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<SecretariaExecutiva> listar(SecretariaExecutiva filtro) {
		// TODO Auto-generated method stub
		return null;
	}
}
