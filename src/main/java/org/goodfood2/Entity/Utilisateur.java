package org.goodfood2.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.PasswordType;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;


/**
 * The persistent class for the Utilisateur database table.
 */
@Entity
@UserDefinition
@NamedQuery(name="Utilisateur.findAll", query="SELECT u FROM Utilisateur u")
public class Utilisateur  extends PanacheEntityBase {
	
	@Id
	@Column(name="id_utilisateur")
	private int idUtilisateur;

	@Column(name="adresse_utilisateur")
	private int adresseUtilisateur;

	@Username
	@Column(name="email_utilisateur")
	private String emailUtilisateur;

	@Password(PasswordType.CLEAR)
	@Column(name="mdp_utilisateur")
	private String mdpUtilisateur;

	@Column(name="nom_utilisateur")
	private String nomUtilisateur;

	@Column(name="numero_tel_utilisateur")
	private String numeroTelUtilisateur;

	@Column(name="prenom_utilisateur")
	private String prenomUtilisateur;

	@Roles
	@Column(name="role")
	private String role;

	public Utilisateur() {
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getAdresseUtilisateur() {
		return this.adresseUtilisateur;
	}

	public void setAdresseUtilisateur(int adresseUtilisateur) {
		this.adresseUtilisateur = adresseUtilisateur;
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

	public String getMdpUtilisateur() {
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

}