package br.com.lifecondominio.service.impl;

import java.util.List;

import javax.ejb.Stateless;

import br.com.lifecondominio.dao.BaseDAO;
import br.com.lifecondominio.model.Perfil;
import br.com.lifecondominio.service.IPerfilService;
import br.com.lifecondominio.service.exception.BusinessException;

@Stateless
public class PerfilService extends BaseDAO<Perfil> implements IPerfilService {

	public PerfilService() {
		super(Perfil.class);
	}

	@Override
	public void salvar(Perfil t) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Perfil> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perfil procurar(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}


}
