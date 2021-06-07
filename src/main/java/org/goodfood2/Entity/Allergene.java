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
	private int a_idAllergene;

	@Column(name="libelle_allergene")
	private String b_libelleAllergene;

	@Column(name="est_active")
	private int c_estActive;

	public Allergene() {
	}

	public int getIdAllergene() {
		return this.a_idAllergene;
	}

	public void setIdAllergene(int idAllergene) {
		this.a_idAllergene = idAllergene;
	}

	public String getLibelleAllergene() {
		return this.b_libelleAllergene;
	}

	public void setLibelleAllergene(String libelleAllergene) {
		this.b_libelleAllergene = libelleAllergene;
	}

	public int getEstActive() {
		return this.c_estActive;
	}

	public void setEstActive(int estActive) {
		this.c_estActive = estActive;
	}

}