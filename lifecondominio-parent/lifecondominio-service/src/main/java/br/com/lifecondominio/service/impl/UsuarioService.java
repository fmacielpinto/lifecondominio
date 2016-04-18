package br.com.lifecondominio.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.lifecondominio.dao.BaseDAO;
import br.com.lifecondominio.model.Usuario;
import br.com.lifecondominio.service.IUsuarioService;
import br.com.lifecondominio.service.exception.BusinessException;
import br.com.lifecondominio.service.exception.CodigoMensagem;

@Stateless
public class UsuarioService extends BaseDAO<Usuario> implements IUsuarioService {

	public UsuarioService() {
		super(Usuario.class);
	}

	public Usuario recuperaUsuario(String login) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("login", login);
		return super.findOneResult(Usuario.FIND_POR_USUARIO, parameters);

	}

	@Override
	public Usuario login(String login, String password) throws BusinessException {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("login", login);
		Usuario u = super.findOneResult(Usuario.FIND_POR_USUARIO, parameters);

		if (u == null) {
			throw new BusinessException(CodigoMensagem.ERRO_LOGIN);
		}
		
		if (!StringMD5.md5(password).equalsIgnoreCase(u.getPassword())) {
			throw new BusinessException(CodigoMensagem.ERRO_PASSWORD);
		}

		return u;
	}

	@Override
	public void salvar(Usuario t) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	
	public Usuario procurar(String login) {
		return null;
	}

	@Override
	public Usuario procurar(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

}
