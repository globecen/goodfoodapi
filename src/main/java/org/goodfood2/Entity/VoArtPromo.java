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
	private int a_idArticle;

	@Column(name="libelle_promo")
	private String b_libellePromo;

    @Column(name="reduction")
    private int c_reduction;

	public VoArtPromo() {
	}

	public int getIdArticle() {
		return this.a_idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.a_idArticle = idArticle;
	}

	public String getLibellePromo() {
		return this.b_libellePromo;
	}

	public void setLibelleAllergene(String libellePromo) {
		this.b_libellePromo = libellePromo;
	}

    public int getReduction() {
		return this.c_reduction;
	}

	public void setReduction(int reduction) {
		this.c_reduction = reduction;
	}
}