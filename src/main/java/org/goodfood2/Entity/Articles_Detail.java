package org.goodfood2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class Articles_Detail extends PanacheEntity{
    public String refArticleDetail;
    public String des;
    public String sref1;
    public String sref2;
    public String lot;
    public int perempdt;
    public int dtstock;
    public Double pu;
    public int stqte;

    @ManyToOne
    @JoinColumn(name="refArticleDetail",referencedColumnName ="refArticle",insertable=false, updatable=false)
    public Articles article;

    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public String getSref1() {
        return sref1;
    }
    public void setSref1(String sref1) {
        this.sref1 = sref1;
    }
    public String getSref2() {
        return sref2;
    }
    public void setSref2(String sref2) {
        this.sref2 = sref2;
    }
    public String getLot() {
        return lot;
    }
    public void setLot(String lot) {
        this.lot = lot;
    }
    public int getPerempdt() {
        return perempdt;
    }
    public void setPerempdt(int perempdt) {
        this.perempdt = perempdt;
    }
    public int getDtstock() {
        return dtstock;
    }
    public void setDtstock(int dtstock) {
        this.dtstock = dtstock;
    }
    public Double getPu() {
        return pu;
    }
    public void setPu(Double pu) {
        this.pu = pu;
    }
    public int getStqte() {
        return stqte;
    }
    public void setStqte(int stqte) {
        this.stqte = stqte;
    }
}
    