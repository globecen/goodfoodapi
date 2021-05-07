package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class Adresses extends PanacheEntity{
    public String cp;
    public String ville;
    public String rue1;
    public String rue2;
    public String pays;
    public String device;
    public Boolean defaut;
    public Boolean type_Livraison;
    public String getCp() {
        return cp;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }
    public String getVille() {
        return ville;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public String getRue1() {
        return rue1;
    }
    public void setRue1(String rue1) {
        this.rue1 = rue1;
    }
    public String getRue2() {
        return rue2;
    }
    public void setRue2(String rue2) {
        this.rue2 = rue2;
    }
    public String getPays() {
        return pays;
    }
    public void setPays(String pays) {
        this.pays = pays;
    }
    public String getDevice() {
        return device;
    }
    public void setDevice(String device) {
        this.device = device;
    }
    public Boolean getDefaut() {
        return defaut;
    }
    public void setDefaut(Boolean defaut) {
        this.defaut = defaut;
    }
    public Boolean getType_Livraison() {
        return type_Livraison;
    }
    public void setType_Livraison(Boolean type_Livraison) {
        this.type_Livraison = type_Livraison;
    }
    
}
