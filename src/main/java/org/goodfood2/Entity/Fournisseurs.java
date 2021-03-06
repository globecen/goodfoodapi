package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Fournisseurs
 */
@Entity
public class Fournisseurs extends PanacheEntity{

    String siret;
    String des;
}