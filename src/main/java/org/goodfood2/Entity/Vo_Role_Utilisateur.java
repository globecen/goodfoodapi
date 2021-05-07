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
 * The persistent class for the Vo_Role_Utilisateur database table.
 * 
 */
@Entity
@NamedQuery(name="Vo_Role_Utilisateur.findAll", query="SELECT v FROM Vo_Role_Utilisateur v")
public class Vo_Role_Utilisateur {

	@Column(name="id_utilisateur")
	private int idUtilisateur;

	@Column(name="libelle_role")
	private String libelleRole;

	public Vo_Role_Utilisateur() {
	}

	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getLibelleRole() {
		return this.libelleRole;
	}

	public void setLibelleRole(String libelleRole) {
		this.libelleRole = libelleRole;
	}

}