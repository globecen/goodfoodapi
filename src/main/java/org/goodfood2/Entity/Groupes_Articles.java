package org.goodfood2.Entity;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
/**
 * Groupes_Articles
 */
@Entity
public class Groupes_Articles extends PanacheEntity{
    public String ref;
    public String des;
}