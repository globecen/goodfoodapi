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

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;

import javax.persistence.ManyToMany;
import javax.persistence.Column;
import java.io.Serializable;
import javax.persistence.*;


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