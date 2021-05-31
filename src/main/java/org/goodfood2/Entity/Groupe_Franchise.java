package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Represente un groupe de franchise
 */
@Entity
public class Groupe_Franchise {

	@Id
	@Column(name="id_groupe_franchise")
	private int idGroupeFranchise;

	@Column(name="nom_groupe_franchise")
	private String nomGroupeFranchise;

	public Groupe_Franchise() {
	}

	public int getIdGroupeFranchise() {
		return this.idGroupeFranchise;
	}

	public void setIdGroupeFranchise(int idGroupeFranchise) {
		this.idGroupeFranchise = idGroupeFranchise;
	}

	public String getNomGroupeFranchise() {
		return this.nomGroupeFranchise;
	}

	public void setNomGroupeFranchise(String nomGroupeFranchise) {
		this.nomGroupeFranchise = nomGroupeFranchise;
	}

}