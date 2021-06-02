package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * Represente une promotion sur un article.
 */
@Entity
public class Promo extends PanacheEntityBase{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_promo")
	private int idPromo;

	@Column(name="est_active")
	private byte estActive;

	@Column(name="id_article")
	private int idArticle;

	@Column(name="libelle_promo")
	private String libellePromo;

	@Column(name="reduction")
	private int reduction;

	public Promo() {
	}

	public int getIdPromo() {
		return this.idPromo;
	}

	public void setIdPromo(int idPromo) {
		this.idPromo = idPromo;
	}

	public byte getEstActive() {
		return this.estActive;
	}

	public void setEstActive(byte estActive) {
		this.estActive = estActive;
	}

	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getLibellePromo() {
		return this.libellePromo;
	}

	public void setLibellePromo(String libellePromo) {
		this.libellePromo = libellePromo;
	}

	public int getReduction() {
		return this.reduction;
	}

	public void setReduction(int reduction) {
		this.reduction = reduction;
	}
}