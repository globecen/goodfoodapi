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

	public int getIdLigneCommande() {
		return this.a_idLigneCommande;
	}

	public void setIdLigneCommande(int idLigneCommande) {
		this.a_idLigneCommande = idLigneCommande;
	}

	public int getIdCommande() {
		return this.b_idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.c_idArticle = idCommande;
	}

	public int getIdArticle() {
		return this.c_idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.c_idArticle = idArticle;
	}

	public double getQuantiteArticle() {
		return this.d_quantiteArticle;
	}

	public void setQuantiteArticle(double quantiteArticle) {
		this.d_quantiteArticle = quantiteArticle;
	}

	public double getSousTotalTtc() {
		return this.e_sousTotalTtc;
	}

	public void setSousTotalTtc(double sousTotalTtc) {
		this.e_sousTotalTtc = sousTotalTtc;
	}

	public int getEstActive() {
		return this.f_estActive;
	}

	public void setEstActive(int estActive) {
		this.f_estActive = estActive;
	}
}