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

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.ManyToMany;
import javax.persistence.Column;


/**
 * The persistent class for the Article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
@JsonPropertyOrder({"idArticle", "idCategorie", "idFranchise", "libelleArticle", "descriptionArticle", "urlImgArticle", "prixArticleHt", "tva", "estMenu", "stockArticle"})
public class Article {

	@Id
	@Column(name="id_article")
	private int idArticle;

	@Column(name="description_article")
	private String descriptionArticle;

	@Column(name="est_menu")
	private byte estMenu;

	@Column(name="id_categorie")
	private int idCategorie;

	@Column(name="id_franchise")
	private int idFranchise;

	@Column(name="libelle_article")
	private String libelleArticle;

	@Column(name="prix_article_ht")
	private double prixArticleHt;

	@Column(name="stock_article")
	private double stockArticle;

	private double tva;

	@Column(name="url_img_article")
	private String urlImgArticle;

	public Article(){
	}


	public void setParams(String descriptionArticle, byte estMenu, int idCategorie, int idFranchise,
	String libelleArticle, double prixArticleHt, double stockArticle, double tva, String urlImgArticle){
		this.descriptionArticle = descriptionArticle;
		this.estMenu = estMenu;
		this.idCategorie = idCategorie;
		this.idFranchise = idFranchise;
		this.libelleArticle = libelleArticle;
		this.prixArticleHt = prixArticleHt;
		this.stockArticle = stockArticle;
		this.tva = tva;
		this.urlImgArticle = urlImgArticle;
	}

	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getDescriptionArticle() {
		return this.descriptionArticle;
	}

	public void setDescriptionArticle(String descriptionArticle) {
		this.descriptionArticle = descriptionArticle;
	}

	public byte getEstMenu() {
		return this.estMenu;
	}

	public void setEstMenu(byte estMenu) {
		this.estMenu = estMenu;
	}

	public int getIdCategorie() {
		return this.idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public int getIdFranchise() {
		return this.idFranchise;
	}

	public void setIdFranchise(int idFranchise) {
		this.idFranchise = idFranchise;
	}

	public String getLibelleArticle() {
		return this.libelleArticle;
	}

	public void setLibelleArticle(String libelleArticle) {
		this.libelleArticle = libelleArticle;
	}

	public double getPrixArticleHt() {
		return this.prixArticleHt;
	}

	public void setPrixArticleHt(double prixArticleHt) {
		this.prixArticleHt = prixArticleHt;
	}

	public double getStockArticle() {
		return this.stockArticle;
	}

	public void setStockArticle(double stockArticle) {
		this.stockArticle = stockArticle;
	}

	public double getTva() {
		return this.tva;
	}

	public void setTva(double tva) {
		this.tva = tva;
	}

	public String getUrlImgArticle() {
		return this.urlImgArticle;
	}

	public void setUrlImgArticle(String urlImgArticle) {
		this.urlImgArticle = urlImgArticle;
	}

}