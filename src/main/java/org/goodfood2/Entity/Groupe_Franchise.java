package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represente un groupe de franchise
 */
@Entity
public class Groupe_Franchise {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_groupe_franchise")
	private int a_idGroupeFranchise;

	@Column(name="nom_groupe_franchise")
	private String b_nomGroupeFranchise;

	@Column(name="est_active")
	private int c_estActive;

	public Groupe_Franchise() {
	}

	public int getIdGroupeFranchise() {
		return this.a_idGroupeFranchise;
	}

	public void setIdGroupeFranchise(int idGroupeFranchise) {
		this.a_idGroupeFranchise = idGroupeFranchise;
	}

	public String getNomGroupeFranchise() {
		return this.b_nomGroupeFranchise;
	}

	public void setNomGroupeFranchise(String nomGroupeFranchise) {
		this.b_nomGroupeFranchise = nomGroupeFranchise;
	}

	public int getEstActive() {
		return this.c_estActive;
	}

	public void setEstActive(int estActive) {
		this.c_estActive = estActive;
	}

}