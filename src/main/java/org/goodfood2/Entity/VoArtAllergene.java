package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * Vue pour faciliter le lien entre les articles et les allergenes.
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