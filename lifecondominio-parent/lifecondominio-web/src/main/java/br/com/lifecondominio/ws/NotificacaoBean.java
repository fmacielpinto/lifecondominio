package br.com.lifecondominio.ws;

import br.com.lifecondominio.model.Ocorrencia;
import br.com.lifecondominio.service.IOcorrenciaService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NotificacaoBean
  implements Serializable
{
  private static final long serialVersionUID = 6079947587885260277L;
  private int quantidade;
  @EJB
  private IOcorrenciaService ocorrenciaService;
  private List<Ocorrencia> ocorrenciasNaoLida;
  
  public int getQuantidade()
  {
    return this.quantidade;
  }
  
  public void notificacao()
  {
    this.quantidade += 1;
  }
  
  @PostConstruct
  public void init()
  {
    this.quantidade = 2;
  }
}
