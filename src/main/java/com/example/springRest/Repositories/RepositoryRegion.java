package com.example.springRest.Repositories;

import com.example.springRest.Entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryRegion extends JpaRepository<Region, Integer> {
}

