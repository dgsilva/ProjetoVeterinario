package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientecao")
public class ClienteCao implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long idCliente;
    @Column(length = 50)
	private String nome;
    @Column(length = 50)
	private String endereco;
    @Column(length = 10)
	private String cep;
    @Column(length = 10)
	private String dataNasc;
	private String numero;
	@Column(length = 50 , unique = true)
	private String email;
	@Column(length = 50)
	private String raçaCachorro;
	@Column(length = 50)
	private String nomeCachorro;
	@Column(length = 10)
	private String dataNascCachorro;
	
	public ClienteCao() {
		// TODO Auto-generated constructor stub
	}

	public ClienteCao(Long idCliente, String nome, String endereco, String cep, String dataNasc, String numero,
			String email, String raçaCachorro, String nomeCachorro, String dataNascCachorro) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.endereco = endereco;
		this.cep = cep;
		this.dataNasc = dataNasc;
		this.numero = numero;
		this.email = email;
		this.raçaCachorro = raçaCachorro;
		this.nomeCachorro = nomeCachorro;
		this.dataNascCachorro = dataNascCachorro;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRaçaCachorro() {
		return raçaCachorro;
	}

	public void setRaçaCachorro(String raçaCachorro) {
		this.raçaCachorro = raçaCachorro;
	}

	public String getNomeCachorro() {
		return nomeCachorro;
	}

	public void setNomeCachorro(String nomeCachorro) {
		this.nomeCachorro = nomeCachorro;
	}

	public String getDataNascCachorro() {
		return dataNascCachorro;
	}

	public void setDataNascCachorro(String dataNascCachorro) {
		this.dataNascCachorro = dataNascCachorro;
	}

	@Override
	public String toString() {
		return "ClienteCao [idCliente=" + idCliente + ", nome=" + nome + ", endereco=" + endereco + ", cep=" + cep
				+ ", dataNasc=" + dataNasc + ", numero=" + numero + ", email=" + email + ", raçaCachorro="
				+ raçaCachorro + ", nomeCachorro=" + nomeCachorro + ", dataNascCachorro=" + dataNascCachorro + "]";
	}
	
	
	
}
