package br.com.lifecondominio.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.lifecondominio.model.Usuario;
import br.com.lifecondominio.service.IUsuarioService;
import br.com.lifecondominio.service.exception.BusinessException;
import br.com.lifecondominio.util.Util;

@ManagedBean
@SessionScoped
public class LoginBean
  extends BaseBean<Usuario>
{
  private static final long serialVersionUID = -1244987237080412398L;
  private Usuario usuario;
  private boolean isLoggedIn;
  @EJB
  private IUsuarioService usuarioService;
  
  public Usuario getUsuario()
  {
    if (this.usuario == null) {
      this.usuario = new Usuario();
    }
    return this.usuario;
  }
  
  public void setUsuario(Usuario usuario)
  {
    this.usuario = usuario;
  }
  
  public String doLogin()
  {
    try
    {
      if (this.usuario != null)
      {
        String login = this.usuario.getLogin();
        
        String password = this.usuario.getPassword();
        if ((login != null) && (password != null))
        {
          this.usuario = getService().login(login, password);
          this.isLoggedIn = true;
          return "/sistema/index.jsf";
        }
      }
    }
    catch (BusinessException e)
    {
      Util.addErrorMessage(e.getMessageKey(), new Object[0]);
    }
    catch (Exception e)
    {
      Util.addErrorMessage("erro.generico", new Object[] { e.getMessage() });
    }
    return "login.jsf";
  }
  
  public void doLogout()
  {
    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    tela("login.jsf");
  }
  
  public void setLoggedIn(boolean isLoggedIn)
  {
    this.isLoggedIn = isLoggedIn;
  }
  
  public boolean isLoggedIn()
  {
    return this.isLoggedIn;
  }
  
  public IUsuarioService getService()
  {
    return this.usuarioService;
  }
}
