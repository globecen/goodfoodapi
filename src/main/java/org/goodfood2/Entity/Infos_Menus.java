package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class Infos_Menus extends PanacheEntity{
    String nom_Info;
    String des;
    int info_Ligne;
}
