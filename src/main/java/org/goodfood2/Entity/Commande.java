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

	public int getA_idCommande() {
		return a_idCommande;
	}

	public void setA_idCommande(int a_idCommande) {
		this.a_idCommande = a_idCommande;
	}

	public int getB_idUtilisateur() {
		return b_idUtilisateur;
	}

	public void setB_idUtilisateur(int b_idUtilisateur) {
		this.b_idUtilisateur = b_idUtilisateur;
	}

	public int getC_idAdresseFacturation() {
		return c_idAdresseFacturation;
	}

	public void setC_idAdresseFacturation(int c_idAdresseFacturation) {
		this.c_idAdresseFacturation = c_idAdresseFacturation;
	}

	public int getD_idAdresseLivraison() {
		return d_idAdresseLivraison;
	}

	public void setD_idAdresseLivraison(int d_idAdresseLivraison) {
		this.d_idAdresseLivraison = d_idAdresseLivraison;
	}

	public String getE_dateCommande() {
		return e_dateCommande;
	}

	public void setE_dateCommande(String e_dateCommande) {
		this.e_dateCommande = e_dateCommande;
	}

	public double getF_totalTtc() {
		return f_totalTtc;
	}

	public void setF_totalTtc(double f_totalTtc) {
		this.f_totalTtc = f_totalTtc;
	}

	public int getG_statutCommande() {
		return g_statutCommande;
	}

	public void setG_statutCommande(int g_statutCommande) {
		this.g_statutCommande = g_statutCommande;
	}

	public int getH_idFranchise() {
		return h_idFranchise;
	}

	public void setH_idFranchise(int h_idFranchise) {
		this.h_idFranchise = h_idFranchise;
	}

	public int getI_estActive() {
		return i_estActive;
	}

	public void setI_estActive(int i_estActive) {
		this.i_estActive = i_estActive;
	}

	
}
