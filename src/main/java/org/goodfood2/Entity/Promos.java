package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class Promos extends PanacheEntity{
    public String ref;
    public String des;
    public Double qteMin;
    public Double qteMax;
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
    public Double getQteMin() {
        return qteMin;
    }
    public void setQteMin(Double qteMin) {
        this.qteMin = qteMin;
    }
    public Double getQteMax() {
        return qteMax;
    }
    public void setQteMax(Double qteMax) {
        this.qteMax = qteMax;
    }
    
}
