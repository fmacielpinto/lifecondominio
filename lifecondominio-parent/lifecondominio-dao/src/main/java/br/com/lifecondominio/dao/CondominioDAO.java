package br.com.lifecondominio.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.lifecondominio.model.Condominio;

@Stateless
public class CondominioDAO extends BaseDAO<Condominio> {

	
	public CondominioDAO() {
		super(Condominio.class);
		
	}

	public void delete(Condominio condominio) {
		super.delete(condominio.getId(), Condominio.class);
	}

	public List<Condominio> recuperaPorAdministradora(int idAdministradora) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("idAdministradora", idAdministradora);
		return super.findListResult(Condominio.FIND_POR_ADMINISTRADORA, parameters);
	}

	public List<Condominio> recuperaPorSindico(String login) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("login", login);
		return super.findListResult(Condominio.FIND_POR_SINDICO, parameters);
	}

	
}
