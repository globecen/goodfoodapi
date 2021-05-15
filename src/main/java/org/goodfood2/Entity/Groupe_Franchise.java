package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the Groupe_Franchise database table.
 * 
 */
@Entity
@NamedQuery(name="Groupe_Franchise.findAll", query="SELECT g FROM Groupe_Franchise g")
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