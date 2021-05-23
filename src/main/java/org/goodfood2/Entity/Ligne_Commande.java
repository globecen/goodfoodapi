package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * The persistent class for the Ligne_Commande database table.
 * 
 */
@Entity
@NamedQuery(name="Ligne_Commande.findAll", query="SELECT l FROM Ligne_Commande l")
public class Ligne_Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ligneCommande")
	private int idLigneCommande;
	
	@Column(name="id_commande")
	private int idCommande;

	@Column(name="id_article")
	private int idArticle;

	@Column(name="quantite_article")
	private double quantiteArticle;

	@Column(name="sous_total_ttc")
	private double sousTotalTtc;

	public Ligne_Commande() {
	}

	public int getIdLigneCommande() {
		return this.idLigneCommande;
	}

	public void setIdLigneCommande(int idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public int getIdCommande() {
		return this.idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public double getQuantiteArticle() {
		return this.quantiteArticle;
	}

	public void setQuantiteArticle(double quantiteArticle) {
		this.quantiteArticle = quantiteArticle;
	}

	public double getSousTotalTtc() {
		return this.sousTotalTtc;
	}

	public void setSousTotalTtc(double sousTotalTtc) {
		this.sousTotalTtc = sousTotalTtc;
	}

}