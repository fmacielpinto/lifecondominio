package br.com.lifecondominio.dao;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;

import br.com.lifecondominio.model.Condominio;

/**
 * 
 * Classe para Testes
 * 
 * @author
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.print("inicio");
		Condominio c = new Condominio();
		c.setNome("BB");
		c.setBairro("bairro");
		Timestamp ts = new Timestamp(new Date().getTime());
		c.setDataCadastro(ts);

		EntityManager em = EntityManagerProvider.getInstance().createManager();

		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();

		em.close();
		System.out.print("fim");
	}

}
