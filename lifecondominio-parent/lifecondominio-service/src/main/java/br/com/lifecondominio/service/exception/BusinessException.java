package br.com.lifecondominio.service.exception;

public class BusinessException extends Exception {

	private static final long serialVersionUID = -7595683913956272478L;
	private String messageKey;

	public BusinessException(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getMessageKey() {
		return messageKey;
	}

}
