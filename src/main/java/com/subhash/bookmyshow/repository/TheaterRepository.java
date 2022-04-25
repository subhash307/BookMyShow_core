package com.subhash.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subhash.bookmyshow.entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long>{

}
