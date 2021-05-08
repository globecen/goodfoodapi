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

/**
 * The persistent class for the Allergene database table.
 * 
 */
@Entity
@NamedQuery(name="Allergene.findAll", query="SELECT a FROM Allergene a")
public class Allergene{

	@Id
	@Column(name="id_allergene")
	private int idAllergene;

	@Column(name="libelle_allergene")
	private String libelleAllergene;

	public Allergene() {
	}

	public int getIdAllergene() {
		return this.idAllergene;
	}

	public void setIdAllergene(int idAllergene) {
		this.idAllergene = idAllergene;
	}

	public String getLibelleAllergene() {
		return this.libelleAllergene;
	}

	public void setLibelleAllergene(String libelleAllergene) {
		this.libelleAllergene = libelleAllergene;
	}

}