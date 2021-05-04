package org.goodfood2.Entity;
import javax.persistence.Entity;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@UserDefinition
@Entity
public class Users extends PanacheEntity{
    public String name;
    @Username
    public String email;
    @Password
    public String password;
    @Roles
    public String role;
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

    public String uncryptPassword() {
        return BcryptUtil.bcryptHash(password);
    }

    public void setPassword(String password) {
        this.password = BcryptUtil.bcryptHash(password);
    }
}
