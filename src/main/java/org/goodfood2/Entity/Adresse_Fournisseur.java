package org.goodfood2.Entity;

import javax.persistence.NamedQuery;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Column;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
/**
 * The persistent class for the Adresse_Fournisseur database table.
 * 
 */
@Entity
@NamedQuery(name="Adresse_Fournisseur.findAll", query="SELECT a FROM Adresse_Fournisseur a")
public class Adresse_Fournisseur  extends PanacheEntityBase{
	@Id
	@Column(name="id_adresse")
	private int idAdresse;

	@Column(name="code_postal")
	private int codePostal;

	@Column(name="nom_adresse")
	private String nomAdresse;

	@Column(name="numero_adresse")
	private int numeroAdresse;

	private String pays;

	@Column(name="supp_nom_adresse")
	private String suppNomAdresse;

	@Column(name="ville_adresse")
	private String villeAdresse;

	@Column(name="est_active")
	private int estActive;
	//bi-directional many-to-one association to Fournisseur
	@ManyToOne
	@JoinColumn(name="id_tiers")
	private Fournisseur fournisseur;

	public Adresse_Fournisseur() {
	}

	public int getIdAdresse() {
		return this.idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	public int getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getNomAdresse() {
		return this.nomAdresse;
	}

	public void setNomAdresse(String nomAdresse) {
		this.nomAdresse = nomAdresse;
	}

	public int getNumeroAdresse() {
		return this.numeroAdresse;
	}

	public void setNumeroAdresse(int numeroAdresse) {
		this.numeroAdresse = numeroAdresse;
	}

	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getSuppNomAdresse() {
		return this.suppNomAdresse;
	}

	public void setSuppNomAdresse(String suppNomAdresse) {
		this.suppNomAdresse = suppNomAdresse;
	}

	public String getVilleAdresse() {
		return this.villeAdresse;
	}

	public void setVilleAdresse(String villeAdresse) {
		this.villeAdresse = villeAdresse;
	}

	public int getEstActive() {
		return this.estActive;
	}

	public void setEstActive(int estActive) {
		this.estActive = estActive;
	}


	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

}