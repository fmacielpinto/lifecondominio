package br.com.lifecondominio.service;

import java.util.List;

import br.com.lifecondominio.model.BaseModel;
import br.com.lifecondominio.service.exception.BusinessException;

public interface IService <T extends BaseModel>{
	
	public void salvar(T t) throws BusinessException;
	
	List<T> listarTodos();

	T procurar(int parseInt);

}
