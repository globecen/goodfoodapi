package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class Menus extends PanacheEntity{
    public String ref;
    public String des;
}
