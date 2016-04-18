package br.com.lifecondominio.service.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.lifecondominio.dao.BaseDAO;
import br.com.lifecondominio.model.Administradora;
import br.com.lifecondominio.service.IAdministradoraService;
import br.com.lifecondominio.service.exception.BusinessException;

@Stateless
public class AdministradoraService extends BaseDAO<Administradora> implements IAdministradoraService {

	public AdministradoraService() {
		super(Administradora.class);
	}

	@Override
	public void salvar(Administradora t) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Administradora> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administradora procurar(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
