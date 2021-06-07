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
	private int a_idArticle;

	@Column(name = "id_categorie_article")
	private int b_idCategorieArticle;

	@Column(name = "id_franchise")
	private int c_idFranchise;

	@Column(name = "libelle_article")
	private String d_libelleArticle;

	@Column(name = "description_article")
	private String e_descriptionArticle;

	@Column(name = "url_img_article")
	private String f_urlImgArticle;

	@Column(name = "prix_article_ht")
	private double g_prixArticleHt;

	@Column(name = "TVA")
	private double h_tva;

	@Column(name = "est_menu")
	private String i_estMenu;

	@Column(name = "est_active")
	private int j_estActive;

	@Column(name = "stock_article")
	private double k_stockArticle;

	public Article() {
	}

	public int getA_idArticle() {
		return a_idArticle;
	}

	public void setA_idArticle(int a_idArticle) {
		this.a_idArticle = a_idArticle;
	}

	public int getB_idCategorieArticle() {
		return b_idCategorieArticle;
	}

	public void setB_idCategorieArticle(int b_idCategorieArticle) {
		this.b_idCategorieArticle = b_idCategorieArticle;
	}

	public int getC_idFranchise() {
		return c_idFranchise;
	}

	public void setC_idFranchise(int c_idFranchise) {
		this.c_idFranchise = c_idFranchise;
	}

	public String getD_libelleArticle() {
		return d_libelleArticle;
	}

	public void setD_libelleArticle(String d_libelleArticle) {
		this.d_libelleArticle = d_libelleArticle;
	}

	public String getE_descriptionArticle() {
		return e_descriptionArticle;
	}

	public void setE_descriptionArticle(String e_descriptionArticle) {
		this.e_descriptionArticle = e_descriptionArticle;
	}

	public String getF_urlImgArticle() {
		return f_urlImgArticle;
	}

	public void setF_urlImgArticle(String f_urlImgArticle) {
		this.f_urlImgArticle = f_urlImgArticle;
	}

	public double getG_prixArticleHt() {
		return g_prixArticleHt;
	}

	public void setG_prixArticleHt(double g_prixArticleHt) {
		this.g_prixArticleHt = g_prixArticleHt;
	}

	public double getH_tva() {
		return h_tva;
	}

	public void setH_tva(double h_tva) {
		this.h_tva = h_tva;
	}

	public String getI_estMenu() {
		return i_estMenu;
	}

	public void setI_estMenu(String i_estMenu) {
		this.i_estMenu = i_estMenu;
	}

	public int getJ_estActive() {
		return j_estActive;
	}

	public void setJ_estActive(int j_estActive) {
		this.j_estActive = j_estActive;
	}

	public double getK_stockArticle() {
		return k_stockArticle;
	}

	public void setK_stockArticle(double k_stockArticle) {
		this.k_stockArticle = k_stockArticle;
	}

	
}