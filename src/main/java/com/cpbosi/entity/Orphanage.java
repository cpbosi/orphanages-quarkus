package com.cpbosi.entity;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

/**
 * Orphanage
 */
@Entity
public class Orphanage extends PanacheEntity {

    private String name;

    public Orphanage() {
    }

    public Orphanage(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Orphanage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}