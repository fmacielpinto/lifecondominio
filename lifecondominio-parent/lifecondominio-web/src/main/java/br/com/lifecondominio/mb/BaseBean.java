package br.com.lifecondominio.mb;

import br.com.lifecondominio.model.BaseModel;
import br.com.lifecondominio.service.IService;
import br.com.lifecondominio.service.exception.BusinessException;
import br.com.lifecondominio.util.Util;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public abstract class BaseBean<T extends BaseModel>
  implements Serializable
{
  private static final long serialVersionUID = 6659075466905458497L;
  protected static final String TELA_INICIAL_SISTEMA = "/sistema/index.jsf";
  protected static final String LOGIN = "login.jsf";
  private T entityBean;
  
  public void setEntityBean(T entityBean)
  {
    this.entityBean = entityBean;
  }
  
  public void salvar()
  {
    try
    {
      getService().salvar(this.entityBean);
      Util.addSuccessMessage("sucesso.cadastro", new Object[] { "XXX" });
    }
    catch (BusinessException e)
    {
      Util.addErrorMessage(e.getMessageKey(), new Object[0]);
    }
    catch (Exception e)
    {
      Util.addErrorMessage("erro.generico", new Object[] { e.getMessage() });
    }
  }
  
  public abstract IService<T> getService();
  
  protected void tela(String pagina)
  {
    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
    try
    {
      externalContext.redirect(externalContext.getRequestContextPath() + "/" + pagina);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
