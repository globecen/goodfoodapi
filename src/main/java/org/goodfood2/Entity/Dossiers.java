package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class Dossiers extends PanacheEntity{
    String nom;
}
