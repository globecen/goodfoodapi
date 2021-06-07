package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * Represente un article.
 */
@Entity
public class Article extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_article")
	private int a_idArticle;

	@Column(name="id_categorie_article")
	private int b_idCategorieArticle;

	@Column(name="id_franchise")
	private int c_idFranchise;

	@Column(name="libelle_article")
	private String d_libelleArticle;

	@Column(name="description_article")
	private String e_descriptionArticle;

	@Column(name="url_img_article")
	private String f_urlImgArticle;

	@Column(name="prix_article_ht")
	private double g_prixArticleHt;

	@Column(name="TVA")
	private double h_tva;

	@Column(name="est_menu")
	private String i_estMenu;

	@Column(name="est_active")
	private int j_estActive;

	@Column(name="stock_article")
	private double k_stockArticle;

	public Article(){
	}
	
	public int getIdArticle() {
		return this.a_idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.a_idArticle = idArticle;
	}

	public String getDescriptionArticle() {
		return this.e_descriptionArticle;
	}

	public void setDescriptionArticle(String descriptionArticle) {
		this.e_descriptionArticle = descriptionArticle;
	}

	public String getEstMenu() {
		return this.i_estMenu;
	}

	public void setEstMenu(String estMenu) {
		this.i_estMenu = estMenu;
	}

	public int getEstActive() {
		return this.j_estActive;
	}

	public void setEstActive(int estActive) {
		this.j_estActive = estActive;
	}

	public int getIdCategorieArticle() {
		return this.b_idCategorieArticle;
	}

	public void setIdCategorieArticle(int idCategorieArticle) {
		this.b_idCategorieArticle = idCategorieArticle;
	}

	public int getIdFranchise() {
		return this.c_idFranchise;
	}

	public void setIdFranchise(int idFranchise) {
		this.c_idFranchise = idFranchise;
	}

	public String getLibelleArticle() {
		return this.d_libelleArticle;
	}

	public void setLibelleArticle(String libelleArticle) {
		this.d_libelleArticle = libelleArticle;
	}

	public double getPrixArticleHt() {
		return this.g_prixArticleHt;
	}

	public void setPrixArticleHt(double prixArticleHt) {
		this.g_prixArticleHt = prixArticleHt;
	}

	public double getStockArticle() {
		return this.k_stockArticle;
	}

	public void setStockArticle(double stockArticle) {
		this.k_stockArticle = stockArticle;
	}

	public double getTva() {
		return this.h_tva;
	}

	public void setTva(double tva) {
		this.h_tva = tva;
	}

	public String getUrlImgArticle() {
		return this.f_urlImgArticle;
	}

	public void setUrlImgArticle(String urlImgArticle) {
		this.f_urlImgArticle = urlImgArticle;
	}

}