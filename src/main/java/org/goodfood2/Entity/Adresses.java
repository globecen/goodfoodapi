package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class Adresses extends PanacheEntity{
    public String cp;
    public String ville;
    public String rue1;
    public String rue2;
    public String pays;
    public String device;
    public Boolean defaut;
    public Boolean type_Livraison;
}
