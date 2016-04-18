package br.com.lifecondominio.service.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.lifecondominio.dao.BaseDAO;
import br.com.lifecondominio.model.Condominio;
import br.com.lifecondominio.service.ICondominioService;
import br.com.lifecondominio.service.exception.BusinessException;

@Stateless
public class CondominioService extends BaseDAO<Condominio> implements ICondominioService {

	public CondominioService() {
		super(Condominio.class);
	}

	

	@Override
	public List<Condominio> listarCondominios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Condominio> listarCondominioPorSindico(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Condominio> listarCondominiosPorAdministradora(int idAdministradora) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Condominio procurar(int idCondominio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Condominio> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Condominio condominio) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void salvar(Condominio t) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	
}
