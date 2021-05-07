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
 * The persistent class for the Vo_Full_Art_Allergenes database table.
 * 
 */
@Entity
@Table(name="Vo_Full_Art_Allergenes")
@NamedQuery(name="Vo_Full_Art_Allergene.findAll", query="SELECT v FROM Vo_Full_Art_Allergene v")
public class Vo_Full_Art_Allergene {

	@Column(name="id_article")
	private int idArticle;

	@Column(name="libelle_allergene")
	private String libelleAllergene;

	public Vo_Full_Art_Allergene() {
	}

	public int getIdArticle() {
		return this.idArticle;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public String getLibelleAllergene() {
		return this.libelleAllergene;
	}

	public void setLibelleAllergene(String libelleAllergene) {
		this.libelleAllergene = libelleAllergene;
	}

}