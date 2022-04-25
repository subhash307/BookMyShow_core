package com.subhash.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subhash.bookmyshow.entity.Screen;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, Long>{

}
