package com.uni.fmi.futuristicfarm.persistence.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long SERIAL_VERSION_ID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof BaseEntity)) return false;

        BaseEntity obj = (BaseEntity) o;
        return Objects.equals(getId(), obj.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}