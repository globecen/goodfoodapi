package org.goodfood2.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;


/**
 * The persistent class for the Promo database table.
 * 
 */
@Entity
public class VoArtAllergene extends PanacheEntityBase{
	@Id
	@Column(name="id_article")
	private int idArticle;

	@Column(name="libelle_allergene")
	private String libelleAllergene;

	public VoArtAllergene() {
	}

	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getLibelleAllergene() {
		return this.libelleAllergene;
	}

	public void setLibelleAllergene(String libelleAllergene) {
		this.libelleAllergene = libelleAllergene;
	}

}