package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class References_Fournisseur extends PanacheEntity{

    public String ref;
    public String des;
    public String sRefF1;
    public String sRefF2;
    public String prixUnitaire;
}
