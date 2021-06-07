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

	public int getA_idAllergene() {
		return a_idAllergene;
	}

	public void setA_idAllergene(int a_idAllergene) {
		this.a_idAllergene = a_idAllergene;
	}

	public String getB_libelleAllergene() {
		return b_libelleAllergene;
	}

	public void setB_libelleAllergene(String b_libelleAllergene) {
		this.b_libelleAllergene = b_libelleAllergene;
	}

	public int getC_estActive() {
		return c_estActive;
	}

	public void setC_estActive(int c_estActive) {
		this.c_estActive = c_estActive;
	}
}