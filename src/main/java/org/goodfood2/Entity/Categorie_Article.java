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
import javax.persistence.ManyToMany;
import javax.persistence.Column;


/**
 * The persistent class for the Categorie_Article database table.
 * 
 */
@Entity
@NamedQuery(name="Categorie_Article.findAll", query="SELECT c FROM Categorie_Article c")
public class Categorie_Article {
	@Id
	@Column(name="id_categorie_article")
	private int idCategorieArticle;


	@Column(name="libelle_categorie_article")
	private String libelleCategorieArticle;

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

}