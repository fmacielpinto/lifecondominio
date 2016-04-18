package br.com.lifecondominio.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.lifecondominio.model.Ocorrencia;

public class OcorrenciaDAO extends BaseDAO<Ocorrencia> {

	public OcorrenciaDAO() {
		super(Ocorrencia.class);
	}

	public void delete(Ocorrencia ocorrencia) {
		super.delete(ocorrencia.getId(), Ocorrencia.class);
	}

	public List<Ocorrencia> recuperaPorOcorrenciaNaoLida(String login) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("login", login);
		return super.findListResult(Ocorrencia.FIND_POR_LOGIN_NAO_LIDO, parameters);
	}

	public List<Ocorrencia> recuperaPorOcorrencia(String login) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("login", login);
		return super.findListResult(Ocorrencia.FIND_POR_LOGIN, parameters);
	}

	public void beginTransaction() {
		// TODO Auto-generated method stub
		
	}

}