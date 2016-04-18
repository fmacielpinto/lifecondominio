package br.com.lifecondominio.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import br.com.lifecondominio.dao.BaseDAO;
import br.com.lifecondominio.model.Ocorrencia;
import br.com.lifecondominio.service.IOcorrenciaService;
import br.com.lifecondominio.service.exception.BusinessException;

@Stateless
public class OcorrenciaService extends BaseDAO<Ocorrencia> implements IOcorrenciaService {

	public OcorrenciaService() {
		super(Ocorrencia.class);
	}

	@Override
	public void salvar(Ocorrencia t) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Ocorrencia> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ocorrencia procurar(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ocorrencia> procurarPorOcorrencia(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void atualizaOcorrenciaLida(Ocorrencia ocorrencia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Ocorrencia> procurarPorOcorrenciaNaoLida(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
