package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Articles
 */
@Entity
public class Articles extends PanacheEntity{
    String ref;
    String des;
    String url_img;
    String tycode;
    String grp_0001;
    String grp_0002; 
    String grp_0003;  
}