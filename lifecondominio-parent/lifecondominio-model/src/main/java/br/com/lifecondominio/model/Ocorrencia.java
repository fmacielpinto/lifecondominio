package br.com.lifecondominio.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the ocorrencia database table.
 * 
 */
@Entity
@Table(name = "ocorrencia")
@NamedQuery(name = "Ocorrencia.findAll", query = "SELECT o FROM Ocorrencia o")
public class Ocorrencia extends BaseModel implements Serializable {

	private static final long serialVersionUID = 821340828740940138L;

	public static final String FIND_POR_LOGIN_NAO_LIDO = "select o from Ocorrencia as o where o.lido=false  and o.usuario.id=:id_usuario";

	public static final String FIND_POR_LOGIN = "select o from Ocorrencia as o where o.usuario.id=:id_usuario";;

	private String descricao;

	private boolean multa;

	private boolean reincidente;

	private boolean lido;

	private String titulo;

	private BigDecimal valor;

	@Column(name = "data_cadastro")
	private Timestamp dataCadastro;

	@Column(name = "data_atualizacao")
	private Timestamp dataAtualizacao;

	// bi-directional many-to-one association to Usuario
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Ocorrencia() {
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean getMulta() {
		return this.multa;
	}

	public void setMulta(boolean multa) {
		this.multa = multa;
	}

	public boolean getReincidente() {
		return this.reincidente;
	}

	public void setReincidente(boolean reincidente) {
		this.reincidente = reincidente;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public boolean isLido() {
		return lido;
	}

	public void setLido(boolean lido) {
		this.lido = lido;
	}

}