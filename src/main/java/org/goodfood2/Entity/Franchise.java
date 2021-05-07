package org.goodfood2.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import io.quarkus.elytron.security.common.BcryptUtil;
import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Franchise database table.
 * 
 */
@Entity
@NamedQuery(name="Franchise.findAll", query="SELECT f FROM Franchise f")
public class Franchise {
	@Id
	@Column(name="id_franchise")
	private int idFranchise;


	@Column(name="email_franchise")
	private String emailFranchise;

	@Column(name="id_groupe_franchise")
	private int idGroupeFranchise;

	@Column(name="nom_franchise")
	private String nomFranchise;

	@Column(name="numero_siret_franchise")
	private int numeroSiretFranchise;

	@Column(name="numero_tel_franchise")
	private int numeroTelFranchise;

	//bi-directional many-to-one association to Fournisseur
	@OneToMany(mappedBy="franchise")
	private List<Fournisseur> fournisseurs;

	public Franchise() {
	}

	public int getIdFranchise() {
		return this.idFranchise;
	}

	public void setIdFranchise(int idFranchise) {
		this.idFranchise = idFranchise;
	}

	public String getEmailFranchise() {
		return this.emailFranchise;
	}

	public void setEmailFranchise(String emailFranchise) {
		this.emailFranchise = emailFranchise;
	}

	public int getIdGroupeFranchise() {
		return this.idGroupeFranchise;
	}

	public void setIdGroupeFranchise(int idGroupeFranchise) {
		this.idGroupeFranchise = idGroupeFranchise;
	}

	public String getNomFranchise() {
		return this.nomFranchise;
	}

	public void setNomFranchise(String nomFranchise) {
		this.nomFranchise = nomFranchise;
	}

	public int getNumeroSiretFranchise() {
		return this.numeroSiretFranchise;
	}

	public void setNumeroSiretFranchise(int numeroSiretFranchise) {
		this.numeroSiretFranchise = numeroSiretFranchise;
	}

	public int getNumeroTelFranchise() {
		return this.numeroTelFranchise;
	}

	public void setNumeroTelFranchise(int numeroTelFranchise) {
		this.numeroTelFranchise = numeroTelFranchise;
	}

	public List<Fournisseur> getFournisseurs() {
		return this.fournisseurs;
	}

	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public Fournisseur addFournisseur(Fournisseur fournisseur) {
		getFournisseurs().add(fournisseur);
		fournisseur.setFranchise(this);

		return fournisseur;
	}

	public Fournisseur removeFournisseur(Fournisseur fournisseur) {
		getFournisseurs().remove(fournisseur);
		fournisseur.setFranchise(null);

		return fournisseur;
	}

}