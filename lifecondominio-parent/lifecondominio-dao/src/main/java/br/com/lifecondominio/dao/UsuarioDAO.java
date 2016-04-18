package br.com.lifecondominio.dao;

import javax.ejb.Stateless;

import br.com.lifecondominio.model.Usuario;

@Stateless
public class UsuarioDAO extends BaseDAO<Usuario> {


	public UsuarioDAO(Class<Usuario> entityClass) {
		super(entityClass);
	}

	public void delete(Usuario usuario) {
	}

	public void save(Usuario c) {
	}
}
