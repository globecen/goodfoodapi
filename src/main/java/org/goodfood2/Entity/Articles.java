package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Articles
 */
@Entity
public class Articles extends PanacheEntity{
    public String ref;
    public String des;
    public String url_img;
    public String tycode;
    public String grp_0001;
    public String grp_0002;
    public String grp_0003;
}