package com.goodfood2.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represente un groupe de franchise
 */
@Entity
public class Groupe_Franchise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_groupe_franchise")
	private int a_idGroupeFranchise;

	@Column(name = "nom_groupe_franchise")
	private String b_nomGroupeFranchise;

	@Column(name = "est_active")
	private int c_estActive;

	public Groupe_Franchise() {
	}

	public int getA_idGroupeFranchise() {
		return a_idGroupeFranchise;
	}

	public void setA_idGroupeFranchise(int a_idGroupeFranchise) {
		this.a_idGroupeFranchise = a_idGroupeFranchise;
	}

	public String getB_nomGroupeFranchise() {
		return b_nomGroupeFranchise;
	}

	public void setB_nomGroupeFranchise(String b_nomGroupeFranchise) {
		this.b_nomGroupeFranchise = b_nomGroupeFranchise;
	}

	public int getC_estActive() {
		return c_estActive;
	}

	public void setC_estActive(int c_estActive) {
		this.c_estActive = c_estActive;
	}

}