package br.com.lifecondominio.service;

import java.util.ArrayList;

import javax.ejb.Local;

import br.com.lifecondominio.model.Ocorrencia;

@Local
public interface IOcorrenciaService extends IService<Ocorrencia> {

	ArrayList<Ocorrencia> procurarPorOcorrencia(String login);

	void atualizaOcorrenciaLida(Ocorrencia ocorrencia);

	ArrayList<Ocorrencia> procurarPorOcorrenciaNaoLida(String login);



}
