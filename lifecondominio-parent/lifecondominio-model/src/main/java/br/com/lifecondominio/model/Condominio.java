package br.com.lifecondominio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the condominio database table.
 * 
 */
@Entity
@Table(name = "condominio")
@NamedQuery(name = "Condominio.findAll", query = "SELECT c FROM Condominio c")
public class Condominio extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = -7031260167965653054L;

	public static final String FIND_POR_ADMINISTRADORA = "select c from Condominio as c inner join c.usuarios u"
			+ " where u.administradora.id= :idAdministradora ";

	public static final String FIND_POR_SINDICO = "select c from Condominio as c inner join c.usuarios u"
			+ " where u.login=:login ";

	

	private boolean ativo;

	private String bairro;

	private String celular;

	private String cep;

	private String cidade;

	private String cnpj;

	private String contato;

	@Column(name = "data_cadastro")
	private Timestamp dataCadastro;

	@Column(name = "data_atualizacao")
	private Timestamp dataAtualizacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_final")
	private Date dataFinal;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio")
	private Date dataInicio;

	private String endereco;

	private String estado;

	private BigDecimal mensalidade;

	private String nome;

	private String telefone;

	@ManyToMany
	@JoinTable(name = "usuario_condominio", joinColumns = {
			@JoinColumn(name = "id_condominio") }, inverseJoinColumns = { @JoinColumn(name = "id_usuario") })
	private List<Usuario> usuarios;

	public Condominio() {
	}



	public boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public Timestamp getDataCadastro() {
		return this.dataCadastro;
	}

	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataFinal() {
		return this.dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
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

	public Timestamp getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Timestamp dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}