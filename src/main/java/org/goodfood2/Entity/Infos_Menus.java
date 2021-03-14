package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class Infos_Menus extends PanacheEntity{
    public String nom_Info;
    public String des;
    public int info_Ligne;
}
