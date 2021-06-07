package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represente un fournisseur.
 */
@Entity
public class Fournisseur {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fournisseur")
	private int a_idFournisseur;

	@Column(name="id_franchise")
	private int b_idFranchise;

	@Column(name="nom_fournisseur")
	private String c_nomFournisseur;

	@Column(name="numero_siret_fournisseur")
	private int d_numeroSiretFournisseur;

	@Column(name="email_fournisseur")
	private String e_emailFournisseur;

	@Column(name="numero_tel_fourniseur")
	private int f_numeroTelFourniseur;

	@Column(name="adresse_fournisseur")
	private int g_adresseFournisseur;

	@Column(name="est_active")
	private int h_estActive;

	public Fournisseur() {
	}

	public int getIdFournisseur() {
		return this.a_idFournisseur;
	}

	public void setIdFournisseur(int idFournisseur) {
		this.a_idFournisseur = idFournisseur;
	}

	public int getAdresseFournisseur() {
		return this.g_adresseFournisseur;
	}

	public void setAdresseFournisseur(int adresseFournisseur) {
		this.g_adresseFournisseur = adresseFournisseur;
	}

	public String getEmailFournisseur() {
		return this.e_emailFournisseur;
	}

	public void setEmailFournisseur(String emailFournisseur) {
		this.e_emailFournisseur = emailFournisseur;
	}

	public String getNomFournisseur() {
		return this.c_nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.c_nomFournisseur = nomFournisseur;
	}

	public int getNumeroSiretFournisseur() {
		return this.d_numeroSiretFournisseur;
	}

	public void setNumeroSiretFournisseur(int numeroSiretFournisseur) {
		this.d_numeroSiretFournisseur = numeroSiretFournisseur;
	}

	public int getNumeroTelFourniseur() {
		return this.f_numeroTelFourniseur;
	}

	public void setNumeroTelFourniseur(int numeroTelFourniseur) {
		this.f_numeroTelFourniseur = numeroTelFourniseur;
	}

	public int getIdFranchise() {
		return this.b_idFranchise;
	}

	public void setIdFranchise(int idFranchise) {
		this.b_idFranchise = idFranchise;
	}

	public int getEstActive() {
		return this.h_estActive;
	}

	public void setEstActive(int estActive) {
		this.h_estActive = estActive;
	}
}