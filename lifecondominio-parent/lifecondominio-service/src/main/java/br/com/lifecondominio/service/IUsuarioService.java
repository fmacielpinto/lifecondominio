package br.com.lifecondominio.service;

import java.util.List;

import javax.ejb.Local;

import br.com.lifecondominio.model.Usuario;
import br.com.lifecondominio.service.exception.BusinessException;

@Local
public interface IUsuarioService extends IService<Usuario> {

	public Usuario recuperaUsuario(String login) throws BusinessException;
	
	public Usuario login(String login, String password) throws BusinessException;

	public void atualizar(Usuario usuario);

	public Usuario procurar(String login);

	public List<Usuario> listarTodos();

}
