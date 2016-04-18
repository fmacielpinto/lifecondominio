package br.com.lifecondominio.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@Table(name = "perfil")
@NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p")
public class Perfil extends BaseModel implements Serializable {

	private static final long serialVersionUID = 3030814560290424125L;

	private String descricao;

	public static final int ID_SINDICO = 3;
	public static final int ID_ADMINISTRADOR = 1;
	public static final int ID_MORADOR = 2;

	public static final String SINDICO = "sindico";
	public static final String ADMINISTRADOR = "admin";
	public static final String MORADOR = "morador";
	public static final String SUPER = "super";

	// bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy = "perfils")
	private List<Usuario> usuarios;

	public Perfil() {
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	

}