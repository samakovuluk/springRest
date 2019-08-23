package com.example.springRest.Repositories;

import com.example.springRest.Entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RepositoryCity extends JpaRepository<City, Integer> {
  }
