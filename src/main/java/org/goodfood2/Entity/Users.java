package org.goodfood2.Entity;

import javax.persistence.Entity;
import io.quarkus.security.jpa.Password;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Users extends PanacheEntity{
    public String name;
    public String email;
    public String password;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return BcryptUtil.bcryptHash(password);
    }
    public void setPassword(String password) {
        this.password = BcryptUtil.bcryptHash(password);
    }
    
}
