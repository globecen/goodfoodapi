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

import io.quarkus.security.jpa.Roles;

import javax.persistence.ManyToMany;
import javax.persistence.Column;
import javax.persistence.*;


/**
 * The persistent class for the Role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role {
	@Id
	@Column(name="id_role")
	private int idRole;

	@Roles
	@Column(name="libelle_role")
	private String libelleRole;

	public Role() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getLibelleRole() {
		return this.libelleRole;
	}

	public void setLibelleRole(String libelleRole) {
		this.libelleRole = libelleRole;
	}

}