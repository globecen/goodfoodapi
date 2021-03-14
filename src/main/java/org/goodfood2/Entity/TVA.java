package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class TVA extends PanacheEntity{
    public String pays;
    public String devise;
    public int tva;
}
