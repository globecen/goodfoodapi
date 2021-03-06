package org.goodfood2;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * UsersRepository
 */
@ApplicationScoped
public class UsersRepository implements PanacheRepository<Users>{
    public List<Users> findByName(String name) {
        return find("name",name).list();
    }
    
}