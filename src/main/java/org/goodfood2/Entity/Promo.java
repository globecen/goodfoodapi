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
	private int a_idPromo;

	@Column(name="est_active")
	private int b_estActive;

	@Column(name="id_article")
	private int c_idArticle;

	@Column(name="libelle_promo")
	private String d_libellePromo;

	@Column(name="reduction")
	private int e_reduction;

	public Promo() {
	}

	public int getIdPromo() {
		return this.a_idPromo;
	}

	public void setIdPromo(int idPromo) {
		this.a_idPromo = idPromo;
	}

	public int getEstActive() {
		return this.b_estActive;
	}

	public void setEstActive(byte estActive) {
		this.b_estActive = estActive;
	}

	public int getIdArticle() {
		return this.c_idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.c_idArticle = idArticle;
	}

	public String getLibellePromo() {
		return this.d_libellePromo;
	}

	public void setLibellePromo(String libellePromo) {
		this.d_libellePromo = libellePromo;
	}

	public int getReduction() {
		return this.e_reduction;
	}

	public void setReduction(int reduction) {
		this.e_reduction = reduction;
	}
}