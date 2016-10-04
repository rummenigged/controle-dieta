package br.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "grupo_alimentar")
@Entity
@Table(name = "grupo_alimentar")
public class GrupoAlimentar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "grupo_alimentar")
	String grupo_alimentar;
	
	public GrupoAlimentar(){}

	public GrupoAlimentar(Integer id, String grupo_alimentar) {
		this.id = id;
		this.grupo_alimentar = grupo_alimentar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGrupo_alimentar() {
		return grupo_alimentar;
	}

	public void setGrupo_alimentar(String grupo_alimentar) {
		this.grupo_alimentar = grupo_alimentar;
	}
	
}
