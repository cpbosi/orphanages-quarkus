package com.cpbosi.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.cpbosi.entity.Orphanage;

@ApplicationScoped
public class OrphanageRepository {
    
    @Inject EntityManager entityManager;

    public List<Orphanage> listOrphanages(){
        List<Orphanage> orphanages = entityManager.createQuery("select o from Orphanage o", Orphanage.class).getResultList();
        System.out.println("teste" + orphanages);
        // List<Orphanage> orphanages = new ArrayList<Orphanage>();
		// orphanages.add(new Orphanage(1L, "ORPHANATO 1"));
		// orphanages.add(new Orphanage(2L, "ORPHANATO 2"));
        return orphanages;
    }

	public void createOrphanage(Orphanage orphanage) {
		entityManager.persist(orphanage);
	}

}
