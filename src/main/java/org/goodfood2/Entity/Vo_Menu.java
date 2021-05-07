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
import javax.persistence.ManyToMany;
import javax.persistence.Column;

import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import io.quarkus.elytron.security.common.BcryptUtil;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Vo_Menu database table.
 * 
 */
@Entity
@NamedQuery(name="Vo_Menu.findAll", query="SELECT v FROM Vo_Menu v")
public class Vo_Menu {

	@Column(name="description_article")
	private String descriptionArticle;

	@Column(name="est_menu")
	private byte estMenu;

	@Column(name="id_article")
	private int idArticle;

	@Column(name="id_categorie")
	private int idCategorie;

	@Column(name="id_franchise")
	private int idFranchise;

	@Column(name="libelle_article")
	private String libelleArticle;

	@Column(name="prix_article_ht")
	private double prixArticleHt;

	@Column(name="stock_article")
	private double stockArticle;

	private double tva;

	@Column(name="url_img_article")
	private String urlImgArticle;

	public Vo_Menu() {
	}

	public String getDescriptionArticle() {
		return this.descriptionArticle;
	}

	public void setDescriptionArticle(String descriptionArticle) {
		this.descriptionArticle = descriptionArticle;
	}

	public byte getEstMenu() {
		return this.estMenu;
	}

	public void setEstMenu(byte estMenu) {
		this.estMenu = estMenu;
	}

	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public int getIdCategorie() {
		return this.idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public int getIdFranchise() {
		return this.idFranchise;
	}

	public void setIdFranchise(int idFranchise) {
		this.idFranchise = idFranchise;
	}

	public String getLibelleArticle() {
		return this.libelleArticle;
	}

	public void setLibelleArticle(String libelleArticle) {
		this.libelleArticle = libelleArticle;
	}

	public double getPrixArticleHt() {
		return this.prixArticleHt;
	}

	public void setPrixArticleHt(double prixArticleHt) {
		this.prixArticleHt = prixArticleHt;
	}

	public double getStockArticle() {
		return this.stockArticle;
	}

	public void setStockArticle(double stockArticle) {
		this.stockArticle = stockArticle;
	}

	public double getTva() {
		return this.tva;
	}

	public void setTva(double tva) {
		this.tva = tva;
	}

	public String getUrlImgArticle() {
		return this.urlImgArticle;
	}

	public void setUrlImgArticle(String urlImgArticle) {
		this.urlImgArticle = urlImgArticle;
	}

}