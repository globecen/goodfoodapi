package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * Represente un article.
 */
@Entity(name = "Article")
@Table(name = "Article")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Article extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_article")
	private int idArticle;

	@Column(name = "id_categorie_article")
	private int idCategorieArticle;

	@Column(name = "id_franchise")
	private int idFranchise;

	@Column(name = "libelle_article")
	private String libelleArticle;

	@Column(name = "description_article")
	private String descriptionArticle;

	@Column(name = "url_img_article")
	private String urlImgArticle;

	@Column(name = "prix_article_ht")
	private double prixArticleHt;

	@Column(name = "TVA")
	private double tva;

	@Column(name = "est_menu")
	private String estMenu;

	@Column(name = "est_active")
	private int estActive;

	@Column(name = "stock_article")
	private double stockArticle;

	public Article() {
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

	public int getEstActive() {
		return this.estActive;
	}

	public void setEstActive(int estActive) {
		this.estActive = estActive;
	}

	public int getIdCategorieArticle() {
		return this.idCategorieArticle;
	}

	public void setIdCategorieArticle(int idCategorieArticle) {
		this.idCategorieArticle = idCategorieArticle;
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