package br.com.empresa.sgt.model.acesso;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.empresa.sgt.enumeration.MappedEnum;
import br.com.empresa.sgt.model.arq.Modelo;

@Entity
@Table(name="T_REGISTROACESSO", schema="ACESSO")
// FIXME Parace que a propriedade shema na nesta anotação está bugada, por isso o "sequenceName" foi adaptado.
@SequenceGenerator(name="SEQ_ID_REGISTROACESSO", sequenceName="ACESSO.SEQ_ID_REGISTROACESSO", schema="ACESSO", allocationSize=1)
public class RegistroAcesso implements Modelo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDREGISTROACESSO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ID_REGISTROACESSO")
	private Integer id;
	
	@Column(nullable=false)
	private String usuario;
	
	@Column(nullable=false)
	private String senha;
	
	private String ip;
	private String browser;
	private String browserVersion;
	private String sistemaOperacional;
	private String dispositivo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAcesso;
	
	@Enumerated(EnumType.ORDINAL)
	private RegistroAcessoTipoEnum tipo;
	
	public RegistroAcesso() {}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public Date getDataAcesso() {
		return dataAcesso;
	}

	public void setDataAcesso(Date dataAcesso) {
		this.dataAcesso = dataAcesso;
	}

	public RegistroAcessoTipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(RegistroAcessoTipoEnum tipo) {
		this.tipo = tipo;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public String getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(String dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	public enum RegistroAcessoTipoEnum implements MappedEnum{
		negado("registroAcesso.tipo.negado"),
		sucesso("registroAcesso.tipo.sucesso"),
		bloqueado("registroAcesso.tipo.bloqueado");
		
		private String descricao;
		
		RegistroAcessoTipoEnum(String descricao) {
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
