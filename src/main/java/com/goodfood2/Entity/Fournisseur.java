package com.goodfood2.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represente un fournisseur.
 */
@Entity
public class Fournisseur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fournisseur")
	private int a_idFournisseur;

	@Column(name = "id_franchise")
	private int b_idFranchise;

	@Column(name = "nom_fournisseur")
	private String c_nomFournisseur;

	@Column(name = "numero_siret_fournisseur")
	private int d_numeroSiretFournisseur;

	@Column(name = "email_fournisseur")
	private String e_emailFournisseur;

	@Column(name = "numero_tel_fourniseur")
	private int f_numeroTelFourniseur;

	@Column(name = "adresse_fournisseur")
	private int g_adresseFournisseur;

	@Column(name = "est_active")
	private int h_estActive;

	public Fournisseur() {
	}

	public int getA_idFournisseur() {
		return a_idFournisseur;
	}

	public void setA_idFournisseur(int a_idFournisseur) {
		this.a_idFournisseur = a_idFournisseur;
	}

	public int getB_idFranchise() {
		return b_idFranchise;
	}

	public void setB_idFranchise(int b_idFranchise) {
		this.b_idFranchise = b_idFranchise;
	}

	public String getC_nomFournisseur() {
		return c_nomFournisseur;
	}

	public void setC_nomFournisseur(String c_nomFournisseur) {
		this.c_nomFournisseur = c_nomFournisseur;
	}

	public int getD_numeroSiretFournisseur() {
		return d_numeroSiretFournisseur;
	}

	public void setD_numeroSiretFournisseur(int d_numeroSiretFournisseur) {
		this.d_numeroSiretFournisseur = d_numeroSiretFournisseur;
	}

	public String getE_emailFournisseur() {
		return e_emailFournisseur;
	}

	public void setE_emailFournisseur(String e_emailFournisseur) {
		this.e_emailFournisseur = e_emailFournisseur;
	}

	public int getF_numeroTelFourniseur() {
		return f_numeroTelFourniseur;
	}

	public void setF_numeroTelFourniseur(int f_numeroTelFourniseur) {
		this.f_numeroTelFourniseur = f_numeroTelFourniseur;
	}

	public int getG_adresseFournisseur() {
		return g_adresseFournisseur;
	}

	public void setG_adresseFournisseur(int g_adresseFournisseur) {
		this.g_adresseFournisseur = g_adresseFournisseur;
	}

	public int getH_estActive() {
		return h_estActive;
	}

	public void setH_estActive(int h_estActive) {
		this.h_estActive = h_estActive;
	}

}