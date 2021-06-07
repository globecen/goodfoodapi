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
	private int idFournisseur;

	@Column(name="id_franchise")
	private int idFranchise;

	@Column(name="nom_fournisseur")
	private String nomFournisseur;

	@Column(name="numero_siret_fournisseur")
	private int numeroSiretFournisseur;

	@Column(name="email_fournisseur")
	private String emailFournisseur;

	@Column(name="numero_tel_fourniseur")
	private int numeroTelFourniseur;

	@Column(name="adresse_fournisseur")
	private int adresseFournisseur;

	@Column(name="est_active")
	private int estActive;

	public Fournisseur() {
	}

	public int getIdFournisseur() {
		return this.idFournisseur;
	}

	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public int getAdresseFournisseur() {
		return this.adresseFournisseur;
	}

	public void setAdresseFournisseur(int adresseFournisseur) {
		this.adresseFournisseur = adresseFournisseur;
	}

	public String getEmailFournisseur() {
		return this.emailFournisseur;
	}

	public void setEmailFournisseur(String emailFournisseur) {
		this.emailFournisseur = emailFournisseur;
	}

	public String getNomFournisseur() {
		return this.nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public int getNumeroSiretFournisseur() {
		return this.numeroSiretFournisseur;
	}

	public void setNumeroSiretFournisseur(int numeroSiretFournisseur) {
		this.numeroSiretFournisseur = numeroSiretFournisseur;
	}

	public int getNumeroTelFourniseur() {
		return this.numeroTelFourniseur;
	}

	public void setNumeroTelFourniseur(int numeroTelFourniseur) {
		this.numeroTelFourniseur = numeroTelFourniseur;
	}

	public int getIdFranchise() {
		return this.idFranchise;
	}

	public void setIdFranchise(int idFranchise) {
		this.idFranchise = idFranchise;
	}

	public int getEstActive() {
		return this.estActive;
	}

	public void setEstActive(int estActive) {
		this.estActive = estActive;
	}
}