package com.subhash.bookmyshow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.subhash.bookmyshow.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

	List<Location> findByLocationName(String location);

//	@Query(value="select a from Location a where a.state = ?1")
//	List<Location> findByState(String location);

}
