package br.com.lifecondominio.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util
{
  private static final String MENSAGEM_TELA = "mensagem";
  
  public static void addWarnMessage(String messageKey, Object... args)
  {
    addMessage(messageKey, FacesMessage.SEVERITY_WARN, args);
  }
  
  public static void addSuccessMessage(String messageKey, Object... args)
  {
    addMessage(messageKey, FacesMessage.SEVERITY_INFO, args);
  }
  
  public static void addErrorMessage(String messageKey, Object... args)
  {
    addMessage(messageKey, FacesMessage.SEVERITY_ERROR, args);
  }
  
  private static void addMessage(String messageKey, FacesMessage.Severity severity, Object... args)
  {
    String message = getMessage(messageKey, args);
    FacesContext.getCurrentInstance().addMessage("mensagem", new FacesMessage(severity, message, message));
  }
  
  private static String getMessage(String messageKey, Object... args)
  {
    ResourceBundle bundle = ResourceBundle.getBundle("messages");
    String message = bundle.getString(messageKey);
    if (message != null) {
      message = MessageFormat.format(message, args);
    }
    return message;
  }
  
  public static String removerMascara(String mascara)
  {
    String str = mascara.replaceAll("\\D", "");
    return str;
  }
}
