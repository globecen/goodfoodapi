package com.goodfood2.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represente une fournisseur.
 */
@Entity
public class Franchise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_franchise")
	private int a_idFranchise;

	@Column(name = "email_franchise")
	private String b_emailFranchise;

	@Column(name = "id_groupe_franchise")
	private int c_idGroupeFranchise;

	@Column(name = "nom_franchise")
	private String d_nomFranchise;

	@Column(name = "numero_siret_franchise")
	private int e_numeroSiretFranchise;

	@Column(name = "numero_tel_franchise")
	private int f_numeroTelFranchise;

	@Column(name = "est_active")
	private int g_estActive;

	public Franchise() {
	}

	public int getA_idFranchise() {
		return a_idFranchise;
	}

	public void setA_idFranchise(int a_idFranchise) {
		this.a_idFranchise = a_idFranchise;
	}

	public String getB_emailFranchise() {
		return b_emailFranchise;
	}

	public void setB_emailFranchise(String b_emailFranchise) {
		this.b_emailFranchise = b_emailFranchise;
	}

	public int getC_idGroupeFranchise() {
		return c_idGroupeFranchise;
	}

	public void setC_idGroupeFranchise(int c_idGroupeFranchise) {
		this.c_idGroupeFranchise = c_idGroupeFranchise;
	}

	public String getD_nomFranchise() {
		return d_nomFranchise;
	}

	public void setD_nomFranchise(String d_nomFranchise) {
		this.d_nomFranchise = d_nomFranchise;
	}

	public int getE_numeroSiretFranchise() {
		return e_numeroSiretFranchise;
	}

	public void setE_numeroSiretFranchise(int e_numeroSiretFranchise) {
		this.e_numeroSiretFranchise = e_numeroSiretFranchise;
	}

	public int getF_numeroTelFranchise() {
		return f_numeroTelFranchise;
	}

	public void setF_numeroTelFranchise(int f_numeroTelFranchise) {
		this.f_numeroTelFranchise = f_numeroTelFranchise;
	}

	public int getG_estActive() {
		return g_estActive;
	}

	public void setG_estActive(int g_estActive) {
		this.g_estActive = g_estActive;
	}
}