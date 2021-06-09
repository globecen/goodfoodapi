package org.goodfood2.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/**
 * Log
 */
@Entity
public class Log extends PanacheEntityBase {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_log")
    private int a_IdLog;
    @Column(name="libelle")
    private String b_Lbelle;
    public int getA_IdLog() {
        return a_IdLog;
    }
    public void setA_IdLog(int a_IdLog) {
        this.a_IdLog = a_IdLog;
    }
    public String getB_Lbelle() {
        return b_Lbelle;
    }
    public void setB_Lbelle(String b_Lbelle) {
        this.b_Lbelle = b_Lbelle;
    }
    public Log() {
    }
    
}