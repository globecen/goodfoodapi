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
    private int b_Lbelle;
    public int getA_IdLog() {
        return a_IdLog;
    }
    public void setA_IdLog(int a_IdLog) {
        this.a_IdLog = a_IdLog;
    }
    public int getB_Lbelle() {
        return b_Lbelle;
    }
    public void setB_Lbelle(int b_Lbelle) {
        this.b_Lbelle = b_Lbelle;
    }
    public Log() {
    }
    
}