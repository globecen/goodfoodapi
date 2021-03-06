package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Unites
 */
@Entity
public class Unites extends PanacheEntity{

    String un;
    String des;
    String un_FAM0001;
    String un_FAM0002;
    String un_FAM0003; 
}