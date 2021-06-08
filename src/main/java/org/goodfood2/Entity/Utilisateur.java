package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * Represente un utilisateur.
 */
@Entity
public class Utilisateur extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilisateur")
	private int a_idUtilisateur;

	@Column(name = "id_adresse_livraison")
	private int b_idAdresseLivraison;

	@Column(name = "id_adresse_facturation")
	private int c_idAdresseFacturation;

	@Column(name = "email_utilisateur")
	private String d_emailUtilisateur;

	@Column(name = "mdp_utilisateur")
	private String e_mdpUtilisateur;

	@Column(name = "nom_utilisateur")
	private String f_nomUtilisateur;

	@Column(name = "numero_tel_utilisateur")
	private String g_numeroTelUtilisateur;

	@Column(name = "prenom_utilisateur")
	private String h_prenomUtilisateur;

	@Column(name = "role")
	private String i_role;

	@Column(name = "id_franchise")
	private int j_idFranchise;

	@Column(name = "est_active")
	private int k_estActive;

	public Utilisateur() {
	}

	public int getA_idUtilisateur() {
		return a_idUtilisateur;
	}

	public void setA_idUtilisateur(int a_idUtilisateur) {
		this.a_idUtilisateur = a_idUtilisateur;
	}

	public int getB_idAdresseLivraison() {
		return b_idAdresseLivraison;
	}

	public void setB_idAdresseLivraison(int b_idAdresseLivraison) {
		this.b_idAdresseLivraison = b_idAdresseLivraison;
	}

	public int getC_idAdresseFacturation() {
		return c_idAdresseFacturation;
	}

	public void setC_idAdresseFacturation(int c_idAdresseFacturation) {
		this.c_idAdresseFacturation = c_idAdresseFacturation;
	}

	public String getD_emailUtilisateur() {
		return d_emailUtilisateur;
	}

	public void setD_emailUtilisateur(String d_emailUtilisateur) {
		this.d_emailUtilisateur = d_emailUtilisateur;
	}

	@Transient
	public String getE_mdpUtilisateur() {
		return e_mdpUtilisateur;
	}

	public String retrieveCryptedPwd() {
		return e_mdpUtilisateur;
	}

	public void setE_mdpUtilisateur(String e_mdpUtilisateur) {
		this.e_mdpUtilisateur = e_mdpUtilisateur;
	}

	public String getF_nomUtilisateur() {
		return f_nomUtilisateur;
	}

	public void setF_nomUtilisateur(String f_nomUtilisateur) {
		this.f_nomUtilisateur = f_nomUtilisateur;
	}

	public String getG_numeroTelUtilisateur() {
		return g_numeroTelUtilisateur;
	}

	public void setG_numeroTelUtilisateur(String g_numeroTelUtilisateur) {
		this.g_numeroTelUtilisateur = g_numeroTelUtilisateur;
	}

	public String getH_prenomUtilisateur() {
		return h_prenomUtilisateur;
	}

	public void setH_prenomUtilisateur(String h_prenomUtilisateur) {
		this.h_prenomUtilisateur = h_prenomUtilisateur;
	}

	public String getI_role() {
		return i_role;
	}

	public void setI_role(String i_role) {
		this.i_role = i_role;
	}

	public int getJ_idFranchise() {
		return j_idFranchise;
	}

	public void setJ_idFranchise(int j_idFranchise) {
		this.j_idFranchise = j_idFranchise;
	}

	public int getK_estActive() {
		return k_estActive;
	}

	public void setK_estActive(int k_estActive) {
		this.k_estActive = k_estActive;
	}

}