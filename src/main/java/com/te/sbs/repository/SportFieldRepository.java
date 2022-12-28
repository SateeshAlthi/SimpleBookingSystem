package com.te.sbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.sbs.entity.SportField;

@Repository
public interface SportFieldRepository extends JpaRepository<SportField, Integer>{

}
