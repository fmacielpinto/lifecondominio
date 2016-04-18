package br.com.lifecondominio.mb;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import br.com.lifecondominio.model.Condominio;
import br.com.lifecondominio.model.Usuario;
import br.com.lifecondominio.service.ICondominioService;
import br.com.lifecondominio.service.IUsuarioService;
import br.com.lifecondominio.util.Util;

@ManagedBean(name="conBean")
@ViewScoped
public class CondominioBean
  extends BaseBean<Condominio>
{
  private static final long serialVersionUID = 4037079301771497762L;
  @EJB
  private ICondominioService condominioService;
  @EJB
  private IUsuarioService usuarioService;
  private Condominio condominio;
  private List<Condominio> condominios;
  private Condominio condominioSelecionado;
  private HtmlDataTable dataTable;
  
  @PostConstruct
  public void init()
  {
    if (this.condominios == null) {
      this.condominios = getService().listarTodos();
    }
    this.condominio = ((Condominio)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("condominio"));
  }
  
  private static Map<String, Object> estados = new LinkedHashMap<String, Object>();
  
  static
  {
    estados.put("Acre", "AC");
    estados.put("Alagoas", "AL");
    estados.put("Amazonas", "AM");
    estados.put("Amapá", "AP");
    estados.put("Bahia", "BA");
    estados.put("Ceará", "CE");
    estados.put("Distrito Federal", "DF");
    estados.put("Espírito Santo", "ES");
    estados.put("Goiás", "GO");
    estados.put("Maranhão", "MA");
    estados.put("Mato Grosso", "MG");
    estados.put("Mato Grosso do Sul", "MS");
    estados.put("Minas Gerais", "MG");
    estados.put("Pará", "PA");
    estados.put("Paraíba", "PB");
    estados.put("Paraná", "PR");
    estados.put("Pernambuco", "PE");
    estados.put("Piauí", "PI");
    estados.put("Rio de Janeiro", "RJ");
    estados.put("Rio Grande do Norte", "RN");
    estados.put("Rondônia", "RO");
    estados.put("Rio Grande do Sul", "RS");
    estados.put("Roraima", "RO");
    estados.put("Santa Catarina", "SC");
    estados.put("Sergipe", "SE");
    estados.put("São Paulo", "SP");
    estados.put("Tocantins", "TO");
  }
  
  public Map<String, Object> getEstados()
  {
    return estados;
  }
  
  public Condominio getCondominio()
  {
    if (this.condominio == null) {
      this.condominio = new Condominio();
    }
    return this.condominio;
  }
  
  public void setCondominio(Condominio condominio)
  {
    this.condominio = condominio;
  }
  
  public Condominio getCondominioSelecionado()
  {
    return this.condominioSelecionado;
  }
  
  public void setCondominioSelecionado(Condominio condominio)
  {
    this.condominioSelecionado = condominio;
  }
  
  public void salvar()
  {
    try
    {
      if (this.condominio.getId() == 0)
      {
        LoginBean ulb = (LoginBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
        
        ArrayList<Usuario> u = new ArrayList<Usuario>();
        
        u.add(getServiceUsuario().procurar(ulb.getUsuario().getLogin()));
        
        this.condominio.setUsuarios(u);
        
        getService().salvar(this.condominio);
      }
      else
      {
        getService().atualizar(this.condominio);
      }
      Util.addSuccessMessage("sucesso.cadastro", new Object[] { "Condomínio" });
    }
    catch (Exception e)
    {
      Util.addErrorMessage("erro.generico", new Object[] { e.getMessage() });
    }
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("condominio");
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
    this.condominioSelecionado = ((Condominio)this.dataTable.getRowData());
    if (getCondominioSelecionado() != null) {
      this.condominio = this.condominioSelecionado;
    }
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("condominio", this.condominio);
    return "condominio.xhtml";
  }
  
  public List<Condominio> getCondominios()
  {
    return this.condominios;
  }
  
  public ICondominioService getService()
  {
    return this.condominioService;
  }
  
  public IUsuarioService getServiceUsuario()
  {
    return this.usuarioService;
  }
}
