package com.te.sbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.sbs.entity.SportsDetails;
@Repository
public interface SportsDetailsRepository extends JpaRepository<SportsDetails, String>{

}
