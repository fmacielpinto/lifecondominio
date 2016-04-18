package br.com.lifecondominio.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/condominioWS")
public class CondominioWS
{
  @GET
  public String get()
  {
    return "Return Teste";
  }
  
  @GET
  @Path("/getCondominio")
  @Produces({"application/json"})
  public String getCondominio()
  {
    return null;
  }
}
