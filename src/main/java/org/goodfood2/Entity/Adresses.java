package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class Adresses extends PanacheEntity{
    String cp;
    String ville;
    String rue1;
    String rue2;
    String pays;
    String device;
    Boolean defaut;
    Boolean type_Livraison;
}
