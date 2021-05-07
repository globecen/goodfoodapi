package org.goodfood2.Repository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;
import org.goodfood2.Entity.Users;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * UsersRepository
 */
@ApplicationScoped
public class UsersRepository implements PanacheRepository<Users>{
    
    @Inject
    EntityManager entityManager;

    public List<Users> findByName(String name) {
        return find("name",name).list();    
    }
    
    public List<Users> findByEmail(String email) {
        return find("email",email).list();  
    }
}