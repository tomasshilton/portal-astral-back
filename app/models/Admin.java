package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.ebeaninternal.server.lib.util.Str;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.validation.Constraint;

@Entity
public class Admin extends User {

    public Admin() {
        name = "";
        lastName = "";
        file = "";
        email = "";
        password = "";
    }

    public Admin(String name, String lastName, String file, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.file = file;
        this.email = email;
        this.password = password;
    }
}
