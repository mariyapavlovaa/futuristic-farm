package com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.user;

import com.sun.istack.NotNull;
import com.uni.fmi.futuristicfarm.persistence.entity.BaseEntity;
import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.userrole.UserRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import java.util.Objects;

import static com.uni.fmi.futuristicfarm.util.Constants.NAME_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.PASSWORD_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.USERNAME_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.USER_EMAIL;
import static com.uni.fmi.futuristicfarm.util.Constants.USER_EMAIL_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.IS_DELETED;
import static com.uni.fmi.futuristicfarm.util.Constants.USER_FIRST_NAME;
import static com.uni.fmi.futuristicfarm.util.Constants.USER_LAST_NAME;
import static com.uni.fmi.futuristicfarm.util.Constants.USER_PASSWORD;
import static com.uni.fmi.futuristicfarm.util.Constants.USER_TABLE_NAME;
import static com.uni.fmi.futuristicfarm.util.Constants.USER_USERNAME;
import static com.uni.fmi.futuristicfarm.util.Constants.USER_USER_POSITION_ID;

@Entity
@Table(name = USER_TABLE_NAME)
public class User extends BaseEntity {

    private static final long SERIAL_VERSION_ID = 1L;

    @NotNull
    @Size(max = USERNAME_SIZE)
    @Column(name = USER_USERNAME)
    private String username;

    @NotNull
    @Size(max = PASSWORD_SIZE)
    @Column(name = USER_PASSWORD)
    private String password;

    @NotNull
    @Size(max = NAME_SIZE)
    @Column(name = USER_FIRST_NAME)
    private String firstName;

    @NotNull
    @Size(max = NAME_SIZE)
    @Column(name = USER_LAST_NAME)
    private String lastName;

    @NotNull
    @Size(max = USER_EMAIL_SIZE)
    @Column(name = USER_EMAIL)
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = USER_USER_POSITION_ID, referencedColumnName = "id")
    private UserRole role;

    @Column(name = IS_DELETED, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    public User() {
    }

    public User(String username,
                String password,
                String firstName,
                String lastName,
                String email,
                UserRole role,
                Boolean isDeleted) {

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.isDeleted = isDeleted;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;

        User user = (User) o;
        return Objects.equals(this.getId(), user.getId()) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(role, user.role) &&
                Objects.equals(isDeleted, user.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), username, password, firstName, lastName, email, role, isDeleted);
    }
}