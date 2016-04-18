package br.com.lifecondominio.dao;

import javax.ejb.Stateless;

import br.com.lifecondominio.model.Usuario;

@Stateless
public class UsuarioDAO extends BaseDAO<Usuario> {


	public UsuarioDAO(Class<Usuario> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

	public void delete(Usuario usuario) {
	
	}

	public void save(Usuario c) {
		// TODO Auto-generated method stub
		
	}

	

}