package br.com.lifecondominio.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class JSFMessageUtil
{
  public void sendInfoMessageToUser(String message)
  {
    FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_INFO, message);
    addMessageToJsfContext(facesMessage);
  }
  
  public void sendErrorMessageToUser(String message)
  {
    FacesMessage facesMessage = createMessage(FacesMessage.SEVERITY_WARN, message);
    addMessageToJsfContext(facesMessage);
  }
  
  private FacesMessage createMessage(FacesMessage.Severity severity, String mensagemErro)
  {
    return new FacesMessage(severity, mensagemErro, mensagemErro);
  }
  
  private void addMessageToJsfContext(FacesMessage facesMessage)
  {
    FacesContext.getCurrentInstance().addMessage(null, facesMessage);
  }
}