package com.amt.mygarden.repository;

import com.amt.mygarden.models.Kart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KartRepository extends CrudRepository<Kart, String> {
}
