package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Unites_Conversion extends PanacheEntity{
    public String unite_Source;
    public Double unite_Qte;
    public String unite_DEst;
    public Double unite_DEstQte;
}
