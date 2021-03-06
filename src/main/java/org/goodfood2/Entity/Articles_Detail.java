package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Articles_Detail
 */
@Entity
public class Articles_Detail extends PanacheEntity{

    String ref;
    String des;
    String sref1;
    String sref2;
    String lot;
    int perempdt;
    int dtstock;
    Double pu;
    int stqte;
    
}