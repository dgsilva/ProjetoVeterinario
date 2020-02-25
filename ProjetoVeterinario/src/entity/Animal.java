package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="animal")
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnimal;
	@Column(length = 50)
	private String nomeAnimal;
	@Column(length = 50)
	private String cor;
	@Column(length = 50)
	private String raca;
	@Column
	private Integer vida;
	@Column(length = 50)
	private String tamanho;
	
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	public Animal(Long idAnimal, String nomeAnimal, String cor, String raca, Integer vida, String tamanho) {
		super();
		this.idAnimal = idAnimal;
		this.nomeAnimal = nomeAnimal;
		this.cor = cor;
		this.raca = raca;
		this.vida = vida;
		this.tamanho = tamanho;
	}

	public Long getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Long idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	@Override
	public String toString() {
		return "Animal [idAnimal=" + idAnimal + ", nomeAnimal=" + nomeAnimal + ", cor=" + cor + ", raca=" + raca
				+ ", vida=" + vida + ", tamanho=" + tamanho + "]";
	}
	
	
	

}
