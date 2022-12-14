package com.nicolo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolo.entities.Bimbo;

@Repository
public interface BimbiDAO extends JpaRepository<Bimbo, Integer> {

}
