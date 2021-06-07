package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Represente une fournisseur.
 */
@Entity
public class Franchise {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_franchise")
	private int a_idFranchise;

	@Column(name="email_franchise")
	private String b_emailFranchise;

	@Column(name="id_groupe_franchise")
	private int c_idGroupeFranchise;

	@Column(name="nom_franchise")
	private String d_nomFranchise;

	@Column(name="numero_siret_franchise")
	private int e_numeroSiretFranchise;

	@Column(name="numero_tel_franchise")
	private int f_numeroTelFranchise;

	@Column(name="est_active")
	private int g_estActive;

	public Franchise() {
	}

	public int getIdFranchise() {
		return this.a_idFranchise;
	}

	public void setIdFranchise(int idFranchise) {
		this.a_idFranchise = idFranchise;
	}

	public String getEmailFranchise() {
		return this.b_emailFranchise;
	}

	public void setEmailFranchise(String emailFranchise) {
		this.b_emailFranchise = emailFranchise;
	}

	public int getIdGroupeFranchise() {
		return this.c_idGroupeFranchise;
	}

	public void setIdGroupeFranchise(int idGroupeFranchise) {
		this.c_idGroupeFranchise = idGroupeFranchise;
	}

	public String getNomFranchise() {
		return this.d_nomFranchise;
	}

	public void setNomFranchise(String nomFranchise) {
		this.d_nomFranchise = nomFranchise;
	}

	public int getNumeroSiretFranchise() {
		return this.e_numeroSiretFranchise;
	}

	public void setNumeroSiretFranchise(int numeroSiretFranchise) {
		this.e_numeroSiretFranchise = numeroSiretFranchise;
	}

	public int getNumeroTelFranchise() {
		return this.f_numeroTelFranchise;
	}

	public void setNumeroTelFranchise(int numeroTelFranchise) {
		this.f_numeroTelFranchise = numeroTelFranchise;
	}

	public int getEstActive() {
		return this.g_estActive;
	}

	public void setEstActive(int estActive) {
		this.g_estActive = estActive;
	}
}