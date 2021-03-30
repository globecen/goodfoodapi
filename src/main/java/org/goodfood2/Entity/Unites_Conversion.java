package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Unites_Conversion extends PanacheEntity{
    public String unite_Source;
    public Double unite_Qte;
    public String unite_DEst;
    public Double unite_DEstQte;
    public String getUnite_Source() {
        return unite_Source;
    }
    public void setUnite_Source(String unite_Source) {
        this.unite_Source = unite_Source;
    }
    public Double getUnite_Qte() {
        return unite_Qte;
    }
    public void setUnite_Qte(Double unite_Qte) {
        this.unite_Qte = unite_Qte;
    }
    public String getUnite_DEst() {
        return unite_DEst;
    }
    public void setUnite_DEst(String unite_DEst) {
        this.unite_DEst = unite_DEst;
    }
    public Double getUnite_DEstQte() {
        return unite_DEstQte;
    }
    public void setUnite_DEstQte(Double unite_DEstQte) {
        this.unite_DEstQte = unite_DEstQte;
    }
    
}
