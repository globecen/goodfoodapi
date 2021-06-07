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
	private int idFranchise;

	@Column(name="email_franchise")
	private String emailFranchise;

	@Column(name="id_groupe_franchise")
	private int idGroupeFranchise;

	@Column(name="nom_franchise")
	private String nomFranchise;

	@Column(name="numero_siret_franchise")
	private int numeroSiretFranchise;

	@Column(name="numero_tel_franchise")
	private int numeroTelFranchise;

	@Column(name="est_active")
	private int estActive;

	public Franchise() {
	}

	public int getIdFranchise() {
		return this.idFranchise;
	}

	public void setIdFranchise(int idFranchise) {
		this.idFranchise = idFranchise;
	}

	public String getEmailFranchise() {
		return this.emailFranchise;
	}

	public void setEmailFranchise(String emailFranchise) {
		this.emailFranchise = emailFranchise;
	}

	public int getIdGroupeFranchise() {
		return this.idGroupeFranchise;
	}

	public void setIdGroupeFranchise(int idGroupeFranchise) {
		this.idGroupeFranchise = idGroupeFranchise;
	}

	public String getNomFranchise() {
		return this.nomFranchise;
	}

	public void setNomFranchise(String nomFranchise) {
		this.nomFranchise = nomFranchise;
	}

	public int getNumeroSiretFranchise() {
		return this.numeroSiretFranchise;
	}

	public void setNumeroSiretFranchise(int numeroSiretFranchise) {
		this.numeroSiretFranchise = numeroSiretFranchise;
	}

	public int getNumeroTelFranchise() {
		return this.numeroTelFranchise;
	}

	public void setNumeroTelFranchise(int numeroTelFranchise) {
		this.numeroTelFranchise = numeroTelFranchise;
	}

	public int getEstActive() {
		return this.estActive;
	}

	public void setEstActive(int estActive) {
		this.estActive = estActive;
	}
}