package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


/**
 * The persistent class for the Article database table.
 * 
 */
@Entity
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
@JsonPropertyOrder({"idArticle", "idCategorie", "idFranchise", "libelleArticle", "descriptionArticle", "urlImgArticle", "prixArticleHt", "tva", "estMenu", "stockArticle"})
public class Article extends PanacheEntityBase {

	@Id
	@Column(name="id_article")
	private int idArticle;

	@Column(name="id_categorie_article")
	private int idCategorieArticle;

	@Column(name="id_franchise")
	private int idFranchise;

	@Column(name="libelle_article")
	private String libelleArticle;

	@Column(name="description_article")
	private String descriptionArticle;

	@Column(name="url_img_article")
	private String urlImgArticle;

	@Column(name="prix_article_ht")
	private double prixArticleHt;

	private double tva;

	@Column(name="est_menu")
	private String estMenu;

	@Column(name="stock_article")
	private double stockArticle;

	public Article(){
	}


	public void setParams(String descriptionArticle, String estMenu, int idCategorie, int idFranchise,
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

	public String getEstMenu() {
		return this.estMenu;
	}

	public void setEstMenu(String estMenu) {
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