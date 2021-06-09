package org.goodfood2.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

/**
 * Represente un article_allergene.
 */
@Entity
public class Article_Allergene{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_allergene_article")
	private int a_idAllergeneArticle;

	@Column(name="id_article")
	private String b_idArticle;

	@Column(name="id_allergene")
	private int c_idAllergene;

    @Column(name="est_active")
	private int d_estActive;

	public Article_Allergene() {
	}

    public int getA_idAllergeneArticle() {
        return a_idAllergeneArticle;
    }

    public void setA_idAllergeneArticle(int a_idAllergeneArticle) {
        this.a_idAllergeneArticle = a_idAllergeneArticle;
    }

    public String getB_idArticle() {
        return b_idArticle;
    }

    public void setB_idArticle(String b_idArticle) {
        this.b_idArticle = b_idArticle;
    }

    public int getC_idAllergene() {
        return c_idAllergene;
    }

    public void setC_idAllergene(int c_idAllergene) {
        this.c_idAllergene = c_idAllergene;
    }

    public int getD_estActive() {
        return d_estActive;
    }

    public void setD_estActive(int d_estActive) {
        this.d_estActive = d_estActive;
    }

    
}