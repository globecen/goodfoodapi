package org.goodfood2.Entity;

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
	private int a_idCommande;

	@Column(name="id_utilisateur")
	private int b_idUtilisateur;

	@Column(name="id_adresse_facturation")
	private int c_idAdresseFacturation;

	@Column(name="id_adresse_livraison")
	private int d_idAdresseLivraison;

	@Column(name="date_commande")
	private String e_dateCommande;

	@Column(name="total_ttc")
	private double f_totalTtc;

	@Column(name="statut_commande")
	private int g_statutCommande;

	@Column(name="id_franchise")
	private int h_idFranchise;

	@Column(name="est_active")
	private int i_estActive;

	public Commande() {
	}

	public int getIdCommande() {
		return this.a_idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.a_idCommande = idCommande;
	}

	public String getDateCommande() {
		return this.e_dateCommande;
	}

	public void setDateCommande(String dateCommande) {
		this.e_dateCommande = dateCommande;
	}

	public int getStatutCommande() {
		return this.g_statutCommande;
	}

	public void setStatutCommande(int statutCommande) {
		this.g_statutCommande = statutCommande;
	}

	public double getTotalTtc() {
		return this.f_totalTtc;
	}

	public void setTotalTtc(double totalTtc) {
		this.f_totalTtc = totalTtc;
	}

	public int getIdAdresseFacturation() {
		return this.c_idAdresseFacturation;
	}

	public void setIdAdresseFacturation(int idAdresseFacturation) {
		this.c_idAdresseFacturation = idAdresseFacturation;
	}

	public int getIdAdresseLivraison() {
		return this.d_idAdresseLivraison;
	}

	public void setIdAdresseLivraison(int idAdresseLivraison) {
		this.d_idAdresseLivraison = idAdresseLivraison;
	}	
	
	public int getIdUtilisateur() {
		return this.b_idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.b_idUtilisateur = idUtilisateur;
	}

	public int getIdFranchise() {
		return this.h_idFranchise;
	}

	public void setIdFranchise(int idFranchise) {
		this.h_idFranchise = idFranchise;
	}

	public int getEstActive() {
		return this.i_estActive;
	}

	public void setEstActive(int estActive) {
		this.i_estActive = estActive;
	}

}
