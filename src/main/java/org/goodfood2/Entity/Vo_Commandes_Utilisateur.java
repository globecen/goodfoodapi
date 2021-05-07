package org.goodfood2.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NamedQuery;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.Column;

import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import io.quarkus.elytron.security.common.BcryptUtil;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Vo_Commandes_Utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Vo_Commandes_Utilisateur.findAll", query="SELECT v FROM Vo_Commandes_Utilisateur v")
public class Vo_Commandes_Utilisateur {

	@Temporal(TemporalType.DATE)
	@Column(name="date_commande")
	private Date dateCommande;

	@Column(name="id_commande")
	private int idCommande;

	@Column(name="id_utilisateur")
	private int idUtilisateur;

	@Column(name="statut_commande")
	private int statutCommande;

	@Column(name="total_ttc")
	private double totalTtc;

	public Vo_Commandes_Utilisateur() {
	}

	public Date getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getStatutCommande() {
		return this.statutCommande;
	}

	public void setStatutCommande(int statutCommande) {
		this.statutCommande = statutCommande;
	}

	public double getTotalTtc() {
		return this.totalTtc;
	}

	public void setTotalTtc(double totalTtc) {
		this.totalTtc = totalTtc;
	}

}