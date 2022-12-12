package com.nicolo.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolo.entities.Sacco;

@Repository
public interface SaccoDAO extends JpaRepository<Sacco, Integer> {

}
