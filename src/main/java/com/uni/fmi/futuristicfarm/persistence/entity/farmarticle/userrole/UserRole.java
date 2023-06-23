package com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.userrole;

import com.sun.istack.NotNull;
import com.uni.fmi.futuristicfarm.persistence.entity.BaseEntity;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import java.util.Objects;

import static com.uni.fmi.futuristicfarm.util.Constants.USER_ROLE;
import static com.uni.fmi.futuristicfarm.util.Constants.USER_ROLE_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.USER_ROLE_TABLE_NAME;

@Entity
@Table(name = USER_ROLE_TABLE_NAME)
@Immutable
public class UserRole extends BaseEntity {

    @NotNull
    @Size(max = USER_ROLE_SIZE)
    @Column(name = USER_ROLE)
    private String role;

    public UserRole() {
    }

    public UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;
        if (!super.equals(o)) return false;

        UserRole userRole = (UserRole) o;
        return Objects.equals(this.getId(), userRole.getId()) &&
                Objects.equals(role, userRole.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), role);
    }
}