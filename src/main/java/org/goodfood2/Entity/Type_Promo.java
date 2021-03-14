package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Type_Promo
 */
@Entity
public class Type_Promo extends PanacheEntity{

    public String typePromo;
}