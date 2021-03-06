package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Unites_Conversion extends PanacheEntity{
    String unite_Source;
    Double unite_Qte;
    String unite_DEst;
    Double unite_DEstQte; 
}
