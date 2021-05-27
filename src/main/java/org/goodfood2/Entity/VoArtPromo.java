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
public class VoArtPromo extends PanacheEntityBase{
	@Id
	@Column(name="id_article")
	private int idArticle;

	@Column(name="libelle_promo")
	private String libellePromo;

    @Column(name="reduction")
    private int reduction;

	public VoArtPromo() {
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

	public void setLibelleAllergene(String libellePromo) {
		this.libellePromo = libellePromo;
	}

    public int getReduction() {
		return this.reduction;
	}

	public void setReduction(int reduction) {
		this.reduction = reduction;
	}
}