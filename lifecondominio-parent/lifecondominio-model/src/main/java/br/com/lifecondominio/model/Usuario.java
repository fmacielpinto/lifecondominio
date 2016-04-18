package br.com.lifecondominio.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name = "usuario", uniqueConstraints = { @UniqueConstraint(columnNames = "login") })
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario extends BaseModel implements Serializable {

	private static final long serialVersionUID = 770107578511338185L;

	public static final String FIND_POR_USUARIO = "select u from Usuario u join fetch u.perfils where u.login = :login";

	private String login;

	private boolean ativo;

	private String celular;

	private String contato;

	private String cpf;

	private String email;

	private String garagem;

	private String nome;

	private Integer numero = new Integer(0);

	private String password;

	private String telefone;

	private Integer tentativa;

	private byte[] imagem;

	// bi-directional many-to-one association to Ocorrencia
	@OneToMany(mappedBy = "usuario")
	private List<Ocorrencia> ocorrencias;

	// private Condominio condominio;

	@Column(name = "data_cadastro")
	private Timestamp dataCadastro;

	@Column(name = "data_atualizacao")
	private Timestamp dataAtualizacao;

	// bi-directional many-to-many association to Condominio
	@ManyToMany
	@JoinTable(name = "usuario_condominio", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_condominio") })
	private List<Condominio> condominios;

	// bi-directional many-to-many association to Perfil
	@ManyToMany
	@JoinTable(name = "usuario_perfil", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_perfil") })
	private List<Perfil> perfils;

	@ManyToOne
	@JoinColumn(name = "id_administradora", referencedColumnName = "id")
	private Administradora administradora;
	
	public Usuario() {
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getContato() {
		return this.contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGaragem() {
		return this.garagem;
	}

	public void setGaragem(String garagem) {
		this.garagem = garagem;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		if (this.numero == null) {
			return new Integer(0);
		}
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getTentativa() {
		return this.tentativa;
	}

	public void setTentativa(int tentativa) {
		this.tentativa = tentativa;
	}

	public List<Condominio> getCondominios() {
		return this.condominios;
	}

	public void setCondominios(List<Condominio> condominios) {
		this.condominios = condominios;
	}

	public List<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	public Administradora getAdministradora() {
		return administradora;
	}

	public void setAdministradora(Administradora administradora) {
		this.administradora = administradora;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setTentativa(Integer tentativa) {
		this.tentativa = tentativa;
	}

	public Timestamp getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Timestamp getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Timestamp dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public List<Ocorrencia> getOcorrencias() {
		return this.ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencia> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	
}