package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Articles_Detail
 */
@Entity
public class Articles_Detail extends PanacheEntity{

    public String ref;
    public String des;
    public String sref1;
    public String sref2;
    public String lot;
    public int perempdt;
    public int dtstock;
    public Double pu;
    public int stqte;
    
}