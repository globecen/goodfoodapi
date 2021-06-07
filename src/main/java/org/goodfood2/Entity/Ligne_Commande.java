package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Represente une ligne de commande.
 */
@Entity
public class Ligne_Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ligneCommande")
	private int a_idLigneCommande;
	
	@Column(name="id_commande")
	private int b_idCommande;

	@Column(name="id_article")
	private int c_idArticle;

	@Column(name="quantite_article")
	private double d_quantiteArticle;

	@Column(name="sous_total_ttc")
	private double e_sousTotalTtc;

	@Column(name="est_active")
	private int f_estActive;

	public Ligne_Commande() {
	}

	public int getA_idLigneCommande() {
		return a_idLigneCommande;
	}

	public void setA_idLigneCommande(int a_idLigneCommande) {
		this.a_idLigneCommande = a_idLigneCommande;
	}

	public int getB_idCommande() {
		return b_idCommande;
	}

	public void setB_idCommande(int b_idCommande) {
		this.b_idCommande = b_idCommande;
	}

	public int getC_idArticle() {
		return c_idArticle;
	}

	public void setC_idArticle(int c_idArticle) {
		this.c_idArticle = c_idArticle;
	}

	public double getD_quantiteArticle() {
		return d_quantiteArticle;
	}

	public void setD_quantiteArticle(double d_quantiteArticle) {
		this.d_quantiteArticle = d_quantiteArticle;
	}

	public double getE_sousTotalTtc() {
		return e_sousTotalTtc;
	}

	public void setE_sousTotalTtc(double e_sousTotalTtc) {
		this.e_sousTotalTtc = e_sousTotalTtc;
	}

	public int getF_estActive() {
		return f_estActive;
	}

	public void setF_estActive(int f_estActive) {
		this.f_estActive = f_estActive;
	}

	
}