package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * Vue pour faciliter le lien entre les articles et les promotions.
 */
@Entity
public class VoArtPromo extends PanacheEntityBase{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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