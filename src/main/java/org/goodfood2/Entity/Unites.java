package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Unites
 */
@Entity
public class Unites extends PanacheEntity{

    public String un;
    public String des;
    public String un_FAM0001;
    public String un_FAM0002;
    public String un_FAM0003;
}