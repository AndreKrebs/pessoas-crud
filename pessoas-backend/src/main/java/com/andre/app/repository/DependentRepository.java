package com.andre.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andre.app.domain.Dependent;

@Repository
public interface DependentRepository extends JpaRepository<Dependent, Integer> {

}
