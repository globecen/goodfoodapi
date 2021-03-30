package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class References_Fournisseurs extends PanacheEntity{
    public String ref;
    public String des;
    public String sRefF1;
    public String sRefF2;
    public String prixUnitaire;
    public String getRef() {
        return ref;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }
    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public String getsRefF1() {
        return sRefF1;
    }
    public void setsRefF1(String sRefF1) {
        this.sRefF1 = sRefF1;
    }
    public String getsRefF2() {
        return sRefF2;
    }
    public void setsRefF2(String sRefF2) {
        this.sRefF2 = sRefF2;
    }
    public String getPrixUnitaire() {
        return prixUnitaire;
    }
    public void setPrixUnitaire(String prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
    
}
