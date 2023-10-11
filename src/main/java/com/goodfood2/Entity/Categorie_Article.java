package com.goodfood2.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Represente une categorie d'article.
 */
@Entity
public class Categorie_Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categorie_article")
	private int a_idCategorieArticle;

	@Column(name = "libelle_categorie_article")
	private String b_libelleCategorieArticle;

	@Column(name = "est_active")
	private int c_estActive;

	public Categorie_Article() {
	}

	public int getA_idCategorieArticle() {
		return a_idCategorieArticle;
	}

	public void setA_idCategorieArticle(int a_idCategorieArticle) {
		this.a_idCategorieArticle = a_idCategorieArticle;
	}

	public String getB_libelleCategorieArticle() {
		return b_libelleCategorieArticle;
	}

	public void setB_libelleCategorieArticle(String b_libelleCategorieArticle) {
		this.b_libelleCategorieArticle = b_libelleCategorieArticle;
	}

	public int getC_estActive() {
		return c_estActive;
	}

	public void setC_estActive(int c_estActive) {
		this.c_estActive = c_estActive;
	}
}