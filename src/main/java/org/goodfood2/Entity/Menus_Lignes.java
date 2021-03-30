package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Menus_Lignes
 */
@Entity
public class Menus_Lignes extends PanacheEntity{
    public String art_ref_menu;
    public String art_ref;
    public String getArt_ref_menu() {
        return art_ref_menu;
    }
    public void setArt_ref_menu(String art_ref_menu) {
        this.art_ref_menu = art_ref_menu;
    }
    public String getArt_ref() {
        return art_ref;
    }
    public void setArt_ref(String art_ref) {
        this.art_ref = art_ref;
    }
    
}