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

	public int getA_idPromo() {
		return a_idPromo;
	}

	public void setA_idPromo(int a_idPromo) {
		this.a_idPromo = a_idPromo;
	}

	public int getB_estActive() {
		return b_estActive;
	}

	public void setB_estActive(int b_estActive) {
		this.b_estActive = b_estActive;
	}

	public int getC_idArticle() {
		return c_idArticle;
	}

	public void setC_idArticle(int c_idArticle) {
		this.c_idArticle = c_idArticle;
	}

	public String getD_libellePromo() {
		return d_libellePromo;
	}

	public void setD_libellePromo(String d_libellePromo) {
		this.d_libellePromo = d_libellePromo;
	}

	public int getE_reduction() {
		return e_reduction;
	}

	public void setE_reduction(int e_reduction) {
		this.e_reduction = e_reduction;
	}

	
}