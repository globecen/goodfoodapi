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
@NamedQuery(name="Promo.findAll", query="SELECT p FROM Promo p")
public class Promo extends PanacheEntityBase{
	@Id
	@Column(name="id_promo")
	private int idPromo;

	@Column(name="est_active")
	private byte estActive;

	@Column(name="id_article")
	private int idArticle;

	@Column(name="libelle_promo")
	private String libellePromo;

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

}