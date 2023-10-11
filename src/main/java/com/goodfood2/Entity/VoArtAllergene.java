package com.goodfood2.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * Vue pour faciliter le lien entre les articles et les allergenes.
 */
@Entity
public class VoArtAllergene extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_article")
	private int a_idArticle;

	@Column(name = "libelle_allergene")
	private String b_libelleAllergene;

	public VoArtAllergene() {
	}

	public int getIdArticle() {
		return this.a_idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.a_idArticle = idArticle;
	}

	public String getLibelleAllergene() {
		return this.b_libelleAllergene;
	}

	public void setLibelleAllergene(String libelleAllergene) {
		this.b_libelleAllergene = libelleAllergene;
	}

}