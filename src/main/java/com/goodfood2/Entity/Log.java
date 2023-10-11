package com.goodfood2.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Log
 */
@Entity
public class Log extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log")
    private int a_IdLog;
    @Column(name = "libelle")
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