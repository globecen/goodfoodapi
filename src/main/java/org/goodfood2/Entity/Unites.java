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
    public String getUn() {
        return un;
    }
    public void setUn(String un) {
        this.un = un;
    }
    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }
    public String getUn_FAM0001() {
        return un_FAM0001;
    }
    public void setUn_FAM0001(String un_FAM0001) {
        this.un_FAM0001 = un_FAM0001;
    }
    public String getUn_FAM0002() {
        return un_FAM0002;
    }
    public void setUn_FAM0002(String un_FAM0002) {
        this.un_FAM0002 = un_FAM0002;
    }
    public String getUn_FAM0003() {
        return un_FAM0003;
    }
    public void setUn_FAM0003(String un_FAM0003) {
        this.un_FAM0003 = un_FAM0003;
    }
    
}