package br.com.lifecondominio.mb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import br.com.lifecondominio.model.Administradora;
import br.com.lifecondominio.model.Condominio;
import br.com.lifecondominio.model.Perfil;
import br.com.lifecondominio.model.Usuario;
import br.com.lifecondominio.service.IAdministradoraService;
import br.com.lifecondominio.service.ICondominioService;
import br.com.lifecondominio.service.IPerfilService;
import br.com.lifecondominio.service.IUsuarioService;
import br.com.lifecondominio.util.Util;

@ManagedBean
@ViewScoped
public class UsuarioBean
  extends BaseBean<Usuario>
{
  private static final long serialVersionUID = -785647563128585706L;
  private Usuario usuario = new Usuario();
  @EJB
  private IUsuarioService usuarioService;
  @EJB
  private ICondominioService condominioService;
  @EJB
  private IAdministradoraService administradoraService;
  @EJB
  private IPerfilService perfilService;
  private List<Administradora> administradoras;
  private List<Condominio> condominios;
  private List<Perfil> perfils;
  private List<Usuario> usuarios;
  private LoginBean ulb;
  private String papel;
  private HtmlDataTable dataTable;
  private Usuario usuarioSelecionado;
  private String idCondominio;
  private String idPerfil;
  private String idAdministradora;
  
  public UsuarioBean()
  {
    listar();
    this.usuario = ((Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
  }
  
  private List<Condominio> carregarCondominios()
  {
    this.condominios = new ArrayList<Condominio>();
    
    this.condominios = getServiceCondominio().listarCondominios();
    
    return this.condominios;
  }
  
  private List<Condominio> carregarCondominioPorSindico(String login)
  {
    this.condominios = new ArrayList<Condominio>();
    
    this.condominios = getServiceCondominio().listarCondominioPorSindico(login);
    
    return this.condominios;
  }
  
  private List<Condominio> carregarCondominiosPorAdmintradora(int idAdministradora)
  {
    return getServiceCondominio().listarCondominiosPorAdministradora(idAdministradora);
  }
  
  public List<Condominio> getCondominios()
  {
    this.ulb = ((LoginBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean"));
    String perfil = ((Perfil)this.ulb.getUsuario().getPerfils().get(0)).getDescricao();
    if (perfil.equalsIgnoreCase("super")) {
      if (this.condominios == null)
      {
        System.out.print("carrega todos os condominios do sistema");
        this.condominios = carregarCondominios();
        System.out.print("carregou todos os condominios do sistema");
      }
    }
    if (perfil.equalsIgnoreCase("admin")) {
      if (this.condominios == null)
      {
        System.out.print("carregar os condominios da administradora");
        this.condominios = carregarCondominiosPorAdmintradora(this.ulb.getUsuario().getAdministradora().getId());
        System.out.print("carregou os condominios da administradora");
      }
    }
    if (perfil.equalsIgnoreCase("sindico")) {
      if (this.condominios == null)
      {
        System.out.print("carrega o condominio do sindico");
        this.condominios = carregarCondominioPorSindico(this.ulb.getUsuario().getLogin());
        System.out.print("carregou o condominio do sindico");
      }
    }
    return this.condominios;
  }
  
  public void setCondominios(List<Condominio> condominios)
  {
    this.condominios = condominios;
  }
  
  public List<Administradora> getAdministradoras()
  {
    this.administradoras = new ArrayList<Administradora>();
    
    this.administradoras = getServiceAdministradora().listarTodos();
    
    return this.administradoras;
  }
  
  public void setAdministradoras(List<Administradora> administradoras)
  {
    this.administradoras = administradoras;
  }
  
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
  
  public String getIdCondominio()
  {
    return this.idCondominio;
  }
  
  public void setIdCondominio(String idCondominio)
  {
    this.idCondominio = idCondominio;
  }
  
  public String getIdAdministradora()
  {
    return this.idAdministradora;
  }
  
  public void setIdAdministradora(String idAdministradora)
  {
    this.idAdministradora = idAdministradora;
  }
  
  public String getIdPerfil()
  {
    return this.idPerfil;
  }
  
  public void setIdPerfil(String idPerfil)
  {
    this.idPerfil = idPerfil;
  }
  
  public String getPapel()
  {
    return this.papel;
  }
  
  public void setPapel(String papel)
  {
    this.papel = papel;
  }
  
  public HtmlDataTable getDataTable()
  {
    return this.dataTable;
  }
  
  public void setDataTable(HtmlDataTable dataTable)
  {
    this.dataTable = dataTable;
  }
  
  public String editar()
    throws Exception
  {
    this.usuarioSelecionado = ((Usuario)this.dataTable.getRowData());
    if (getUsuarioSelecionado() != null) {
      this.usuario = this.usuarioSelecionado;
    }
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario);
    return "usuario.xhtml";
  }
  
  public void incluir()
    throws Exception
  {
    this.usuario = new Usuario();
    tela("usuario.xhtml");
  }
  
  public void listar()
  {
    this.usuarios = new ArrayList<Usuario>();
    
    this.ulb = ((LoginBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogadoBean"));
    String perfil = ((Perfil)this.ulb.getUsuario().getPerfils().get(0)).getDescricao();
    if (perfil.equalsIgnoreCase("morador")) {
      this.usuarios.add(this.ulb.getUsuario());
    }
    if (perfil.equalsIgnoreCase("super")) {
      this.usuarios = getService().listarTodos();
    }
  }
  
  public void salvar()
  {
    ArrayList<Perfil> p = new ArrayList<Perfil>();
    ArrayList<Condominio> c = new ArrayList<Condominio>();
    try
    {
      Usuario obj = getService().recuperaUsuario(this.usuario.getLogin());
      String perfil = ((Perfil)this.ulb.getUsuario().getPerfils().get(0)).getDescricao();
      if (obj == null)
      {
        if (perfil.equalsIgnoreCase("sindico"))
        {
          int idCondominio = ((Condominio)this.ulb.getUsuario().getCondominios().get(0)).getId();
          
          p.add(getServicePerfil().procurar(2));
          c.add(getServiceCondominio().procurar(idCondominio));
          
          this.usuario.setPerfils(p);
          this.usuario.setCondominios(c);
        }
        else if (perfil.equalsIgnoreCase("morador"))
        {
          p.add(getServicePerfil().procurar(2));
          int idCondominio = ((Condominio)this.ulb.getUsuario().getCondominios().get(0)).getId();
          c.add(getServiceCondominio().procurar(idCondominio));
          this.usuario.setPerfils(p);
          this.usuario.setCondominios(c);
        }
        else if (perfil.equalsIgnoreCase("admin"))
        {
          p.add(getServicePerfil().procurar(Integer.parseInt(this.idPerfil)));
          c.add(getServiceCondominio().procurar(Integer.parseInt(this.idCondominio)));
          this.usuario.setPerfils(p);
          this.usuario.setCondominios(c);
        }
        else if (perfil.equalsIgnoreCase("super"))
        {
          p.add(getServicePerfil().procurar(Integer.parseInt(this.idPerfil)));
          this.usuario.setPerfils(p);
          if (!this.idCondominio.equals(""))
          {
            Condominio con = getServiceCondominio().procurar(Integer.parseInt(this.idCondominio));
            c.add(con);
            this.usuario.setCondominios(c);
          }
          if ((this.idAdministradora != null) || (!this.idAdministradora.equals("")))
          {
            Administradora ad = (Administradora)getServiceAdministradora().procurar(Integer.parseInt(this.idAdministradora));
            this.usuario.setAdministradora(ad);
          }
        }
        getService().salvar(this.usuario);
      }
      else
      {
        if (perfil.equalsIgnoreCase("sindico"))
        {
          int idCondominio = ((Condominio)this.ulb.getUsuario().getCondominios().get(0)).getId();
          
          p.add(getServicePerfil().procurar(2));
          c.add(getServiceCondominio().procurar(idCondominio));
          
          this.usuario.setPerfils(p);
          this.usuario.setCondominios(c);
        }
        else if (perfil.equalsIgnoreCase("morador"))
        {
          p.add(getServicePerfil().procurar(2));
          int idCondominio = ((Condominio)this.ulb.getUsuario().getCondominios().get(0)).getId();
          c.add(getServiceCondominio().procurar(idCondominio));
          this.usuario.setPerfils(p);
          this.usuario.setCondominios(c);
        }
        else if (perfil.equalsIgnoreCase("admin"))
        {
          p.add(getServicePerfil().procurar(Integer.parseInt(this.idPerfil)));
          c.add(getServiceCondominio().procurar(Integer.parseInt(this.idCondominio)));
          this.usuario.setPerfils(p);
          this.usuario.setCondominios(c);
        }
        getService().atualizar(this.usuario);
      }
      Util.addSuccessMessage("sucesso.cadastro", new Object[] { "Usuário" });
    }
    catch (Exception e)
    {
      Util.addErrorMessage("erro.generico", new Object[] { e.getMessage() });
    }
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
  }
  
  public Usuario getUsuarioSelecionado()
  {
    return this.usuarioSelecionado;
  }
  
  public void setUsuarioSelecionado(Usuario usuarioSelecionado)
  {
    this.usuarioSelecionado = usuarioSelecionado;
  }
  
  public List<Usuario> getUsuarios()
  {
    return this.usuarios;
  }
  
  public void setUsuarios(List<Usuario> usuarios)
  {
    this.usuarios = usuarios;
  }
  
  public List<Perfil> getPerfils()
  {
    this.perfils = new ArrayList<Perfil>();
    this.perfils = getServicePerfil().listarTodos();
    return this.perfils;
  }
  
  public void setPerfils(List<Perfil> perfils)
  {
    this.perfils = perfils;
  }
  
  public IUsuarioService getService()
  {
    return this.usuarioService;
  }
  
  public IAdministradoraService getServiceAdministradora()
  {
    return this.administradoraService;
  }
  
  public ICondominioService getServiceCondominio()
  {
    return this.condominioService;
  }
  
  public IPerfilService getServicePerfil()
  {
    return this.perfilService;
  }
}
