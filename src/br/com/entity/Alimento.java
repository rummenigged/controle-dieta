package br.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "alimento")
@Entity
@Table(name = "alimento")
public class Alimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "nome")
	String nome;
	
	@Column(name = "grupo_alimentar_id")
	Integer grupo_alimentar_id;
	
	@Column(name = "nutrientes_id")
	Integer nutrientes_id;
	
	public Alimento(){}
	
	public Alimento(Integer id, String nome, Integer grupo_alimentar_id, Integer nutrientes_id){
		this.id = id;
		this.nome = nome;
		this.grupo_alimentar_id = grupo_alimentar_id;
		this.nutrientes_id = nutrientes_id;
	}
	
	public Integer getId(){
		return this.id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getGrupo_alimentar_id() {
		return grupo_alimentar_id;
	}

	public Integer getNutrientes_id() {
		return nutrientes_id;
	}
	
	
}
