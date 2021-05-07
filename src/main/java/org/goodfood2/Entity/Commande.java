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
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Commande database table.
 * 
 */
@Entity
@NamedQuery(name="Commande.findAll", query="SELECT c FROM Commande c")
public class Commande  {

	@Id
	@Column(name="id_commande")
	private int idCommande;

	@Temporal(TemporalType.DATE)
	@Column(name="date_commande")
	private Date dateCommande;

	@Column(name="statut_commande")
	private int statutCommande;

	@Column(name="total_ttc")
	private double totalTtc;

	//bi-directional many-to-one association to Adresse_Utilisateur
	@ManyToOne
	@JoinColumn(name="id_adresse")
	private Adresse_Utilisateur adresseUtilisateur;

	//bi-directional many-to-one association to Utilisateur
	@ManyToOne
	@JoinColumn(name="id_utilisateur")
	private Utilisateur utilisateur;

	public Commande() {
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
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

	public Adresse_Utilisateur getAdresseUtilisateur() {
		return this.adresseUtilisateur;
	}

	public void setAdresseUtilisateur(Adresse_Utilisateur adresseUtilisateur) {
		this.adresseUtilisateur = adresseUtilisateur;
	}

	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}