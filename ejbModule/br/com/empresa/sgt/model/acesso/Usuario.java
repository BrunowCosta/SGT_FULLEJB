package br.com.empresa.sgt.model.acesso;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.br.CPF;

import br.com.empresa.sgt.enumeration.MappedEnum;
import br.com.empresa.sgt.model.arq.Modelo;

@Entity
@Table(name="T_USUARIO", schema="ACESSO")
@SequenceGenerator(name="SEQ_ID_USUARIO", sequenceName="ACESSO.SEQ_ID_USUARIO", schema="ACESSO", allocationSize=1)
@NamedQuery(name = "Usuario.autenticacao", query = "select u from Usuario u where u.login = :login and u.senha = :senha")
public class Usuario implements Modelo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8221347861916518793L;
	
	public final static String QUERY_AUTENTICACAO = "Usuario.autenticacao";
	
	@Id
	@Column(name="IDUSUARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_USUARIO")
	private Integer id;
	
	//TODO botar unique
	@Column(nullable=false, length=30)
	private String login;
	
	//É hashado com salt.
	@Column(nullable=false, length=32)
	private String senha;
	
	@Enumerated(EnumType.ORDINAL)
	private UsuarioStatusEnum status;
	
	// Dados Pessoais
	@Column(nullable=false, length=50)
	private String nome;
	
	@Column(nullable=false, length=10)
	private String nomeExibicao;
	
	@Column(nullable=false, length=30)
	private String email;
	
	@CPF
	@Column(nullable=false, length=11)
	private String cpf;
	
	@Column(nullable=false)
	private String registroGeral;
	
	private String orgaoExpedidor;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	private String telefonePrincipal;
	
	private String telefoneAuxiliar;
	
	@Column(nullable=false)
	private char sexo;
	
	private String urlFotoPerfil;
	
	// Endereço
	@Embedded
	private Endereco endereco;
	
	@ManyToOne
	private GrupoPermissao grupoPermissao;
	
	// Milisegundos do cadastro ou ultima alteração de senha do usuário.
	@Column(nullable=false)
	private String saltAgent;
	
	public Usuario() {
		this.endereco = new Endereco();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSaltAgent() {
		return saltAgent;
	}

	public void setSaltAgent(String saltAgent) {
		this.saltAgent = saltAgent;
	}

	public UsuarioStatusEnum getStatus() {
		return status;
	}

	public void setStatus(UsuarioStatusEnum status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeExibicao() {
		return nomeExibicao;
	}

	public void setNomeExibicao(String nomeExibicao) {
		this.nomeExibicao = nomeExibicao;
	}

	public String getRegistroGeral() {
		return registroGeral;
	}

	public void setRegistroGeral(String registroGeral) {
		this.registroGeral = registroGeral;
	}

	public String getOrgaoExpedidor() {
		return orgaoExpedidor;
	}

	public void setOrgaoExpedidor(String orgaoExpeditor) {
		this.orgaoExpedidor = orgaoExpeditor;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public String getTelefoneAuxiliar() {
		return telefoneAuxiliar;
	}

	public void setTelefoneAuxiliar(String telefoneAuxiliar) {
		this.telefoneAuxiliar = telefoneAuxiliar;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getUrlFotoPerfil() {
		return urlFotoPerfil;
	}

	public void setUrlFotoPerfil(String urlFotoPerfil) {
		this.urlFotoPerfil = urlFotoPerfil;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public GrupoPermissao getGrupoPermissao() {
		return grupoPermissao;
	}

	public void setGrupoPermissao(GrupoPermissao grupoPermissao) {
		this.grupoPermissao = grupoPermissao;
	}
	
	public enum UsuarioStatusEnum implements MappedEnum{
		INATIVO("usuario.status.ativo"),
		ATIVO("usuario.status.inativo"),
		CANCELADO("usuario.status.cancelado"),
		BLOQUEADO("usuario.status.bloqueado"),
		EXPIRADO("usuario.status.expirado");
		
		private String descricao;
		
		UsuarioStatusEnum(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
	}
	
} 
