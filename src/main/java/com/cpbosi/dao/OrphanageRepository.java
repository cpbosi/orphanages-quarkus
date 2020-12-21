package com.cpbosi.dao;

import javax.enterprise.context.ApplicationScoped;

import com.cpbosi.entity.Orphanage;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrphanageRepository implements PanacheRepository<Orphanage>{
    
}
