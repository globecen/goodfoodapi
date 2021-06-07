package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represente une categorie d'article.
 */
@Entity
public class Categorie_Article {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categorie_article")
	private int a_idCategorieArticle;

	@Column(name="libelle_categorie_article")
	private String b_libelleCategorieArticle;

	@Column(name="est_active")
	private int c_estActive;

	public Categorie_Article() {
	}

	public int getIdCategorieArticle() {
		return this.a_idCategorieArticle;
	}

	public void setIdCategorieArticle(int idCategorieArticle) {
		this.a_idCategorieArticle = idCategorieArticle;
	}

	public String getLibelleCategorieArticle() {
		return this.b_libelleCategorieArticle;
	}

	public void setLibelleCategorieArticle(String libelleCategorieArticle) {
		this.b_libelleCategorieArticle = libelleCategorieArticle;
	}

	public int getEstActive() {
		return this.c_estActive;
	}

	public void setEstActive(int estActive) {
		this.c_estActive = estActive;
	}

}