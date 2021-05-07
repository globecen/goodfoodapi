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
 * The persistent class for the Article_Allergene database table.
 * 
 */
@Entity
@NamedQuery(name="Article_Allergene.findAll", query="SELECT a FROM Article_Allergene a")
public class Article_Allergene {

	@Column(name="id_allergene")
	private int idAllergene;

	@Column(name="id_article")
	private int idArticle;

	public Article_Allergene() {
	}

	public int getIdAllergene() {
		return this.idAllergene;
	}

	public void setIdAllergene(int idAllergene) {
		this.idAllergene = idAllergene;
	}

	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

}