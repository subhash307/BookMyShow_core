package com.subhash.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subhash.bookmyshow.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
