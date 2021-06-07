package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * Represente un utilisateur.
 */
@Entity
public class Utilisateur  extends PanacheEntityBase {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_utilisateur")
	private int a_idUtilisateur;

	@Column(name="id_adresse_livraison")
	private int b_idAdresseLivraison;

	@Column(name="id_adresse_facturation")
	private int c_idAdresseFacturation;

	@Column(name="email_utilisateur")
	private String d_emailUtilisateur;

	@Column(name="mdp_utilisateur")
	private String e_mdpUtilisateur;

	@Column(name="nom_utilisateur")
	private String f_nomUtilisateur;

	@Column(name="numero_tel_utilisateur")
	private String g_numeroTelUtilisateur;

	@Column(name="prenom_utilisateur")
	private String h_prenomUtilisateur;

	@Column(name="role")
	private String i_role;

	@Column(name="id_franchise")
	private int j_idFranchise;

	@Column(name="est_active")
	private int k_estActive;
	

	public Utilisateur() {
	}

	public int getIdUtilisateur() {
		return this.a_idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.a_idUtilisateur = idUtilisateur;
	}
	
	public int getIdAdresseLivraison() {
		return b_idAdresseLivraison;
	}

	public void setIdAdresseLivraison(int idAdresseLivraison) {
		this.b_idAdresseLivraison = idAdresseLivraison;
	}

	public int getIdAdresseFacturation() {
		return c_idAdresseFacturation;
	}

	public void setIdAdresseFacturation(int idAdresseFacturation) {
		this.c_idAdresseFacturation = idAdresseFacturation;
	}

	public String getEmailUtilisateur() {
		return this.d_emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.d_emailUtilisateur = emailUtilisateur;
	}

	public String getRole() {
		return this.i_role;
	}

	public void setRole(String role) {
		this.i_role = role;
	}

	public String getMdpUtilisateur() {
		return this.e_mdpUtilisateur;
	}

	public void setMdpUtilisateur(String mdpUtilisateur) {
		this.e_mdpUtilisateur = mdpUtilisateur;
	}

	public String getNomUtilisateur() {
		return this.f_nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.f_nomUtilisateur = nomUtilisateur;
	}

	public String getNumeroTelUtilisateur() {
		return this.g_numeroTelUtilisateur;
	}

	public void setNumeroTelUtilisateur(String numeroTelUtilisateur) {
		this.g_numeroTelUtilisateur = numeroTelUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return this.h_prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.h_prenomUtilisateur = prenomUtilisateur;
	}	

	public int getIdFranchise() {
		return this.j_idFranchise;
	}

	public void setIdFranchise(int idFranchise) {
		this.j_idFranchise = idFranchise;
	}

	public int getEstActive() {
		return this.k_estActive;
	}

	public void setEstActive(int estActive) {
		this.k_estActive = estActive;
	}

}