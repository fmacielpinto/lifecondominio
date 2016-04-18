package br.com.lifecondominio.service;

import java.util.List;

import javax.ejb.Local;

import br.com.lifecondominio.model.Condominio;

@Local
public interface ICondominioService extends IService<Condominio> {

	List<Condominio> listarCondominios();

	List<Condominio> listarCondominioPorSindico(String login);

	List<Condominio> listarCondominiosPorAdministradora(int idAdministradora);

	Condominio procurar(int idCondominio);

	List<Condominio> listarTodos();

	void atualizar(Condominio condominio);



}
