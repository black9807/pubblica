package com.nicolo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolo.entities.Dono;

@Repository
public interface DoniDAO extends JpaRepository<Dono, Integer> {

}
