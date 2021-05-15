package org.goodfood2.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the Fournisseur database table.
 * 
 */
@Entity
@NamedQuery(name="Fournisseur.findAll", query="SELECT f FROM Fournisseur f")
public class Fournisseur {
	@Id
	@Column(name="id_fournisseur")
	private int idFournisseur;

	@Column(name="adresse_fournisseur")
	private int adresseFournisseur;

	@Column(name="email_fournisseur")
	private String emailFournisseur;

	@Column(name="nom_fournisseur")
	private String nomFournisseur;

	@Column(name="numero_siret_fournisseur")
	private int numeroSiretFournisseur;

	@Column(name="numero_tel_fourniseur")
	private int numeroTelFourniseur;

	//bi-directional many-to-one association to Adresse_Fournisseur
	@OneToMany(mappedBy="fournisseur")
	private List<Adresse_Fournisseur> adresseFournisseurs;

	//bi-directional many-to-one association to Franchise
	@ManyToOne
	@JoinColumn(name="id_franchise")
	private Franchise franchise;

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

	public List<Adresse_Fournisseur> getAdresseFournisseurs() {
		return this.adresseFournisseurs;
	}

	public void setAdresseFournisseurs(List<Adresse_Fournisseur> adresseFournisseurs) {
		this.adresseFournisseurs = adresseFournisseurs;
	}

	public Adresse_Fournisseur addAdresseFournisseur(Adresse_Fournisseur adresseFournisseur) {
		getAdresseFournisseurs().add(adresseFournisseur);
		adresseFournisseur.setFournisseur(this);

		return adresseFournisseur;
	}

	public Adresse_Fournisseur removeAdresseFournisseur(Adresse_Fournisseur adresseFournisseur) {
		getAdresseFournisseurs().remove(adresseFournisseur);
		adresseFournisseur.setFournisseur(null);

		return adresseFournisseur;
	}

	public Franchise getFranchise() {
		return this.franchise;
	}

	public void setFranchise(Franchise franchise) {
		this.franchise = franchise;
	}

}