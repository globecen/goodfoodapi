package org.goodfood2.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

/**
 * Represente un allergene.
 */
@Entity
public class Allergene{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_allergene")
	private int idAllergene;

	@Column(name="libelle_allergene")
	private String libelleAllergene;

	@Column(name="est_active")
	private int estActive;

	public Allergene() {
	}

	public int getIdAllergene() {
		return this.idAllergene;
	}

	public void setIdAllergene(int idAllergene) {
		this.idAllergene = idAllergene;
	}

	public String getLibelleAllergene() {
		return this.libelleAllergene;
	}

	public void setLibelleAllergene(String libelleAllergene) {
		this.libelleAllergene = libelleAllergene;
	}

	public int getEstActive() {
		return this.estActive;
	}

	public void setEstActive(int estActive) {
		this.estActive = estActive;
	}

}