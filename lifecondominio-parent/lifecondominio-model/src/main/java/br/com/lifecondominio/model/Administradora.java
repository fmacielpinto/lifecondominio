package br.com.lifecondominio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the administradora database table.
 * 
 */
@Entity
@Table(name = "administradora")
@NamedQuery(name = "Administradora.findAll", query = "SELECT a FROM Administradora a")
public class Administradora extends BaseModel implements Serializable {

	private static final long serialVersionUID = -4193513661492170100L;

	private String bairro;

	private String cidade;

	private String cnpj;

	private String contato;

	private String endereco;

	private String estado;

	private BigDecimal mensalidade;

	private String nome;

	private String telefone;

	// bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy = "administradora", fetch = FetchType.LAZY)
	private List<Usuario> usuarios;

	public Administradora() {
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getMensalidade() {
		return this.mensalidade;
	}

	public void setMensalidade(BigDecimal mensalidade) {
		this.mensalidade = mensalidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}