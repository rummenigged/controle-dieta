package br.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "nutrientes")
@Entity
@Table(name = "nutrientes")
public class Nutrientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "proteinas")
	double proteinas;
	
	@Column(name = "carboidratos")
	double carboidratos;
	
	@Column(name = "calorias")
	double calorias;
	
	@Column(name = "gorduras_totais")
	double gorduras_totais;
	
	@Column(name = "gorduras_saturadas")
	double gorduras_saturadas;
	
	@Column(name = "sodio")
	double sodio;
	
	public Nutrientes(){}

	public Nutrientes(Integer id, double proteinas, double carboidratos, double calorias, double gorduras_totais,
			double gorduras_saturadas, double sodio) {
		this.id = id;
		this.proteinas = proteinas;
		this.carboidratos = carboidratos;
		this.calorias = calorias;
		this.gorduras_totais = gorduras_totais;
		this.gorduras_saturadas = gorduras_saturadas;
		this.sodio = sodio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getProteinas() {
		return proteinas;
	}

	public void setProteinas(double proteinas) {
		this.proteinas = proteinas;
	}

	public double getCarboidratos() {
		return carboidratos;
	}

	public void setCarboidratos(double carboidratos) {
		this.carboidratos = carboidratos;
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	public double getGorduras_totais() {
		return gorduras_totais;
	}

	public void setGorduras_totais(double gorduras_totais) {
		this.gorduras_totais = gorduras_totais;
	}

	public double getGorduras_saturadas() {
		return gorduras_saturadas;
	}

	public void setGorduras_saturadas(double gorduras_saturadas) {
		this.gorduras_saturadas = gorduras_saturadas;
	}

	public double getSodio() {
		return sodio;
	}

	public void setSodio(double sodio) {
		this.sodio = sodio;
	}
	
	
}
