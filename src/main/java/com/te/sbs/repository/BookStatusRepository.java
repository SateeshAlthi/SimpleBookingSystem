package com.te.sbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.sbs.entity.BookStatus;

@Repository
public interface BookStatusRepository extends JpaRepository<BookStatus, Integer> {

}
