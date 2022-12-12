package com.nicolo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolo.entities.Consegna;

@Repository
public interface ConsegnaDAO extends JpaRepository<Consegna, Integer> {

}
