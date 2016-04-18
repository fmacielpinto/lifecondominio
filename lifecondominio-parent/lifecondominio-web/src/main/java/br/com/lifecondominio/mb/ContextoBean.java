package br.com.lifecondominio.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="contextoBean")
@SessionScoped
public class ContextoBean
{
  private String contexto = "http://lifecondominio.com.br/lifecondominio-static/lifecondominio";
  
  public String getContexto()
  {
    return this.contexto;
  }
  
  public void setContexto(String contexto)
  {
    this.contexto = contexto;
  }
}
