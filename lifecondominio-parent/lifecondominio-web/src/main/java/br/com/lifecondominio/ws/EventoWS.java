package br.com.lifecondominio.ws;

import br.com.lifecondominio.model.Eventos;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/eventoWS")
public class EventoWS
{
  @GET
  public String get()
  {
    return "teste";
  }
  
  @GET
  @Path("/getEventos")
  @Produces({"application/json"})
  public String getEventos()
  {
    List<Eventos> eventos = new ArrayList<Eventos>();
    
    String mesAtual = String.valueOf(Calendar.getInstance().get(2) + 1);
    if (mesAtual.length() < 2) {
      mesAtual = "0" + mesAtual;
    }
    String anoAtual = String.valueOf(Calendar.getInstance().get(1));
    

    eventos.add(new Eventos("Estudar Linux", anoAtual + "-" + mesAtual + "-02T12:00:00", anoAtual + "-" + mesAtual + "-02T13:30:00", null));
    eventos.add(new Eventos("Estudar Java", anoAtual + "-" + mesAtual + "-02T14:00:00", anoAtual + "-" + mesAtual + "-02T14:30:00", null));
    eventos.add(new Eventos("Estudar C#", anoAtual + "-" + mesAtual + "-02T15:00:00", anoAtual + "-" + mesAtual + "-02T15:30:00", null));
    eventos.add(new Eventos("Estudar SOA Suite", anoAtual + "-" + mesAtual + "-02T16:00:00", anoAtual + "-" + mesAtual + "-02T17:30:00", null));
    eventos.add(new Eventos("Estudar Jquery", anoAtual + "-" + mesAtual + "-02T19:00:00", anoAtual + "-" + mesAtual + "-02T20:30:00", null));
    eventos.add(new Eventos("Correr", anoAtual + "-" + mesAtual + "-03T13:00:00", anoAtual + "-" + mesAtual + "-03T13:30:00", null));
    eventos.add(new Eventos("Reunião", anoAtual + "-" + mesAtual + "-05T12:00:00", anoAtual + "-" + mesAtual + "-05T13:30:00", null));
    eventos.add(new Eventos("Dois dias de evento", anoAtual + "-" + mesAtual + "-07T12:00:00", anoAtual + "-" + mesAtual + "-08T12:00:00", null));
    
    eventos.add(new Eventos("Publicar Artigo", anoAtual + "-" + mesAtual + "-10T12:00:00", anoAtual + "-" + mesAtual + "-10T13:30:00", null));
    eventos.add(new Eventos("Reunião", anoAtual + "-" + mesAtual + "-10T15:00:00", anoAtual + "-" + mesAtual + "-10T18:30:00", null));
    
    eventos.add(new Eventos("Festa", anoAtual + "-" + mesAtual + "-13T12:00:00", anoAtual + "-" + mesAtual + "-13T13:30:00", null));
    eventos.add(new Eventos("Festa 2", anoAtual + "-" + mesAtual + "-13T15:00:00", anoAtual + "-" + mesAtual + "-13T18:30:00", null));
    eventos.add(new Eventos("Curso de Inglês", anoAtual + "-" + mesAtual + "-15", null, null));
    eventos.add(new Eventos("Blog Cícero", anoAtual + "-" + mesAtual + "-23", null, "http://www.ciceroednilson.com.br"));
    
    Gson gson = new Gson();
    return gson.toJson(eventos);
  }
}
