package by.perkal.model;

import by.perkal.validator.Password;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 5, max = 50, message = "Login must contain from 5 to 50 characters")
    @Column
    private String login;

    @Password(message = "{valid.password.password}")
    @Column
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roleEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(Role roleEntity) {
        this.roleEntity = roleEntity;
    }
}
