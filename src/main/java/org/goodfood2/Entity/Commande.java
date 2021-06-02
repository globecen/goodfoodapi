package org.goodfood2.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represente une commande.
 */
@Entity
public class Commande{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_commande")
	private int idCommande;

	@Column(name="date_commande")
	private String dateCommande;

	@Column(name="statut_commande")
	private int statutCommande;

	@Column(name="total_ttc")
	private double totalTtc;

	@Column(name="id_adresse_facturation")
	private int idAdresseFacturation;

	@Column(name="id_adresse_livraison")
	private int idAdresseLivraison;

	@Column(name="id_utilisateur")
	private int idUtilisateur;

	@Column(name="est_active")
	private int estActive;

	public Commande() {
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public String getDateCommande() {
		return this.dateCommande;
	}

	public void setDateCommande(String dateCommande) {
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

	public int getIdAdresseFacturation() {
		return this.idAdresseFacturation;
	}

	public void setIdAdresseFacturation(int idAdresseFacturation) {
		this.idAdresseFacturation = idAdresseFacturation;
	}

	public int getIdAdresseLivraison() {
		return this.idAdresseLivraison;
	}

	public void setIdAdresseLivraison(int idAdresseLivraison) {
		this.idAdresseLivraison = idAdresseLivraison;
	}	
	
	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getEstActive() {
		return this.estActive;
	}

	public void setEstActive(int estActive) {
		this.estActive = estActive;
	}

}
