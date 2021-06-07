package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * Represente un utilisateur.
 */
@Entity
public class Utilisateur extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilisateur")
	private int idUtilisateur;

	@Column(name = "id_adresse_livraison")
	private int idAdresseLivraison;

	@Column(name = "id_adresse_facturation")
	private int idAdresseFacturation;

	@Column(name = "email_utilisateur")
	private String emailUtilisateur;

	@Column(name = "mdp_utilisateur")
	private String mdpUtilisateur;

	@Column(name = "nom_utilisateur")
	private String nomUtilisateur;

	@Column(name = "numero_tel_utilisateur")
	private String numeroTelUtilisateur;

	@Column(name = "prenom_utilisateur")
	private String prenomUtilisateur;

	@Column(name = "role")
	private String role;

	@Column(name="est_active")
	private int estActive;
	

	public Utilisateur() {
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getIdAdresseLivraison() {
		return idAdresseLivraison;
	}

	public void setIdAdresseLivraison(int idAdresseLivraison) {
		this.idAdresseLivraison = idAdresseLivraison;
	}

	public int getIdAdresseFacturation() {
		return idAdresseFacturation;
	}

	public void setIdAdresseFacturation(int idAdresseFacturation) {
		this.idAdresseFacturation = idAdresseFacturation;
	}

	public String getEmailUtilisateur() {
		return this.emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Transient
	private String getMdpUtilisateur() {
		return this.mdpUtilisateur;
	}

	public String retrieveEncryptPassword() {
		return this.mdpUtilisateur;
	}

	public void setMdpUtilisateur(String mdpUtilisateur) {
		this.mdpUtilisateur = mdpUtilisateur;
	}

	public String getNomUtilisateur() {
		return this.nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getNumeroTelUtilisateur() {
		return this.numeroTelUtilisateur;
	}

	public void setNumeroTelUtilisateur(String numeroTelUtilisateur) {
		this.numeroTelUtilisateur = numeroTelUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return this.prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

		public int getEstActive() {
		return this.estActive;
	}

	public void setEstActive(int estActive) {
		this.estActive = estActive;
	}

}