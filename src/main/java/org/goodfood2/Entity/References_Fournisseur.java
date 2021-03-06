package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class References_Fournisseur extends PanacheEntity{

    String ref;
    String des;
    String sRefF1;
    String sRefF2;
    String prixUnitaire;
}
