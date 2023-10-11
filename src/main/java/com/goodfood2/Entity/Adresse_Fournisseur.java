package com.goodfood2.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represente une adresse d'un fournisseur.
 */
@Entity
public class Adresse_Fournisseur extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_adresse")
	private int a_idAdresse;
	//

	@Column(name = "id_tiers")
	private int b_idTiers;

	@Column(name = "code_postal")
	private int c_codePostal;

	@Column(name = "nom_adresse")
	private String d_nomAdresse;

	@Column(name = "numero_adresse")
	private int e_numeroAdresse;

	@Column(name = "pays")
	private String f_pays;

	@Column(name = "supp_nom_adresse")
	private String g_suppNomAdresse;

	@Column(name = "ville_adresse")
	private String h_villeAdresse;

	@Column(name = "est_active")
	private int i_estActive;

	public Adresse_Fournisseur() {
	}

	public int getA_idAdresse() {
		return a_idAdresse;
	}

	public void setA_idAdresse(int a_idAdresse) {
		this.a_idAdresse = a_idAdresse;
	}

	public int getB_idTiers() {
		return b_idTiers;
	}

	public void setB_idTiers(int b_idTiers) {
		this.b_idTiers = b_idTiers;
	}

	public int getC_codePostal() {
		return c_codePostal;
	}

	public void setC_codePostal(int c_codePostal) {
		this.c_codePostal = c_codePostal;
	}

	public String getD_nomAdresse() {
		return d_nomAdresse;
	}

	public void setD_nomAdresse(String d_nomAdresse) {
		this.d_nomAdresse = d_nomAdresse;
	}

	public int getE_numeroAdresse() {
		return e_numeroAdresse;
	}

	public void setE_numeroAdresse(int e_numeroAdresse) {
		this.e_numeroAdresse = e_numeroAdresse;
	}

	public String getF_pays() {
		return f_pays;
	}

	public void setF_pays(String f_pays) {
		this.f_pays = f_pays;
	}

	public String getG_suppNomAdresse() {
		return g_suppNomAdresse;
	}

	public void setG_suppNomAdresse(String g_suppNomAdresse) {
		this.g_suppNomAdresse = g_suppNomAdresse;
	}

	public String getH_villeAdresse() {
		return h_villeAdresse;
	}

	public void setH_villeAdresse(String h_villeAdresse) {
		this.h_villeAdresse = h_villeAdresse;
	}

	public int getI_estActive() {
		return i_estActive;
	}

	public void setI_estActive(int i_estActive) {
		this.i_estActive = i_estActive;
	}

}