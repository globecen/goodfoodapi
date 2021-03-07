package org.goodfood2.Repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.goodfood2.Entity.Articles;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * ArticlesResources
 */
@ApplicationScoped
public class ArticlesRepository  implements PanacheRepository <Articles>{
    public List<Articles> findByRef(String ref) {
        return find("ref",ref).list();
    }
    public List<Articles> findById(Long id) {
        return find("id",id).list();
    }
    public List<Articles> findByTycode(String tycode) {
        return find("tycode",tycode).list();
    }
    
}