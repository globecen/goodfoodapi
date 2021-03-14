package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Fournisseurs
 */
@Entity
public class Fournisseurs extends PanacheEntity{

    public String siret;
    public String des;
}