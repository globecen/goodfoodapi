package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
@Entity
public class Promos extends PanacheEntity{
    String ref;
    String des;
    Double qteMin;
    Double qteMax;
}