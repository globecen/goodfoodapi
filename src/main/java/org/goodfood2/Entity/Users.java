package org.goodfood2.Entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Users extends PanacheEntity{
    public String name;
    public String email;
    public String password;
}
