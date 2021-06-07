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
	private int idCategorieArticle;

	@Column(name="libelle_categorie_article")
	private String libelleCategorieArticle;

	@Column(name="est_active")
	private int estActive;

	public Categorie_Article() {
	}

	public int getIdCategorieArticle() {
		return this.idCategorieArticle;
	}

	public void setIdCategorieArticle(int idCategorieArticle) {
		this.idCategorieArticle = idCategorieArticle;
	}

	public String getLibelleCategorieArticle() {
		return this.libelleCategorieArticle;
	}

	public void setLibelleCategorieArticle(String libelleCategorieArticle) {
		this.libelleCategorieArticle = libelleCategorieArticle;
	}

	public int getEstActive() {
		return this.estActive;
	}

	public void setEstActive(int estActive) {
		this.estActive = estActive;
	}

}