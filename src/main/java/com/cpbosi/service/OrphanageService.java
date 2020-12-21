package com.cpbosi.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.cpbosi.dao.OrphanageRepository;
import com.cpbosi.entity.Orphanage;

@ApplicationScoped
@Transactional
public class OrphanageService {

	@Inject OrphanageRepository orphanageRepository;

	public List<Orphanage> listOrphanages() {
		return orphanageRepository.listAll();
	}

	public void createOrphanage(Orphanage orphanage) {
		orphanage.persist();
	}
    
}
