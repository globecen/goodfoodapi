package org.goodfood2.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represente une adresse utilisateur.
 */
@Entity
public class Adresse_Utilisateur extends PanacheEntityBase{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_adresse")
	private int a_idAdresse;

	@Column(name="id_utilisateur")
	private int b_idUtilisateur;

	@Column(name="code_postal")
	private int c_codePostal;

	@Column(name="nom_adresse")
	private String d_nomAdresse;

	@Column(name="numero_adresse")
	private int e_numeroAdresse;

	@Column(name="pays")
	private String f_pays;

	@Column(name="supp_nom_adresse")
	private String g_suppNomAdresse;

	@Column(name="ville_adresse")
	private String h_villeAdresse;	

	@Column(name="est_active")
	private int i_estActive;

	public Adresse_Utilisateur() {
	}

	public int getIdAdresse() {
		return this.a_idAdresse;
	}

	public void setIdAdresse(int idAdresse) {
		this.a_idAdresse = idAdresse;
	}

	public int getIdUtilisateur() {
		return this.b_idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.b_idUtilisateur = idUtilisateur;
	}

	public int getCodePostal() {
		return this.c_codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.c_codePostal = codePostal;
	}

	public String getNomAdresse() {
		return this.d_nomAdresse;
	}

	public void setNomAdresse(String nomAdresse) {
		this.d_nomAdresse = nomAdresse;
	}

	public int getNumeroAdresse() {
		return this.e_numeroAdresse;
	}

	public void setNumeroAdresse(int numeroAdresse) {
		this.e_numeroAdresse = numeroAdresse;
	}

	public String getPays() {
		return this.f_pays;
	}

	public void setPays(String pays) {
		this.f_pays = pays;
	}

	public String getSuppNomAdresse() {
		return this.g_suppNomAdresse;
	}

	public void setSuppNomAdresse(String suppNomAdresse) {
		this.g_suppNomAdresse = suppNomAdresse;
	}

	public String getVilleAdresse() {
		return this.h_villeAdresse;
	}

	public void setVilleAdresse(String villeAdresse) {
		this.h_villeAdresse = villeAdresse;
	}
	
	public int getEstActive() {
		return this.i_estActive;
	}

	public void setEstActive(int estActive) {
		this.i_estActive = estActive;
	}

}