package br.com.lifecondominio.mb;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;

import br.com.lifecondominio.model.Ocorrencia;
import br.com.lifecondominio.service.IOcorrenciaService;

@ManagedBean
@ViewScoped
public class OcorrenciaBean
  extends BaseBean<Ocorrencia>
{
  private static final long serialVersionUID = -109381424214469472L;
  @EJB
  private IOcorrenciaService ocorrenciaService;
  private List<Ocorrencia> ocorrenciasNaoLida;
  private List<Ocorrencia> ocorrencias;
  private Ocorrencia ocorrencia;
  private Ocorrencia ocorrenciaSelecionada;
  private HtmlDataTable dataTable;
  
  public OcorrenciaBean()
  {
    this.ocorrencia = ((Ocorrencia)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("ocorrencia"));
  }
  
  public List<Ocorrencia> getOcorrenciasNaoLida()
  {
    return this.ocorrenciasNaoLida;
  }
  
  public void setOcorrenciasNaoLida(List<Ocorrencia> ocorrenciasNaoLida)
  {
    this.ocorrenciasNaoLida = ocorrenciasNaoLida;
  }
  
  public List<Ocorrencia> getOcorrencias()
  {
    LoginBean ulb = (LoginBean)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginBean");
    if (this.ocorrencias == null) {
      this.ocorrencias = getService().procurarPorOcorrencia(ulb.getUsuario().getLogin());
    }
    return this.ocorrencias;
  }
  
  public void setOcorrencias(List<Ocorrencia> ocorrencias)
  {
    this.ocorrencias = ocorrencias;
  }
  
  public HtmlDataTable getDataTable()
  {
    return this.dataTable;
  }
  
  public String visualizar()
    throws Exception
  {
    this.ocorrencia = ((Ocorrencia)this.dataTable.getRowData());
    
    getService().atualizaOcorrenciaLida(this.ocorrencia);
    
    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("ocorrencia", this.ocorrencia);
    return "ocorrencia.xhtml";
  }
  
  public void setDataTable(HtmlDataTable dataTable)
  {
    this.dataTable = dataTable;
  }
  
  public Ocorrencia getOcorrencia()
  {
    if (this.ocorrencia == null) {
      this.ocorrencia = new Ocorrencia();
    }
    return this.ocorrencia;
  }
  
  public void setOcorrencia(Ocorrencia ocorrencia)
  {
    this.ocorrencia = ocorrencia;
  }
  
  public Ocorrencia getOcorrenciaSelecionada()
  {
    return this.ocorrenciaSelecionada;
  }
  
  public void setOcorrenciaSelecionada(Ocorrencia ocorrenciaSelecionada)
  {
    this.ocorrenciaSelecionada = ocorrenciaSelecionada;
  }
  
  public IOcorrenciaService getService()
  {
    return this.ocorrenciaService;
  }
}
