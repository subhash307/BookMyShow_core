package com.subhash.bookmyshow.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.subhash.bookmyshow.entity.Location;
import com.subhash.bookmyshow.entity.Movie;
import com.subhash.bookmyshow.entity.Screen;
import com.subhash.bookmyshow.entity.Theater;
import com.subhash.bookmyshow.json.LocationRequest;
import com.subhash.bookmyshow.json.TheaterPriceResponse;
import com.subhash.bookmyshow.repository.LocationRepository;
import com.subhash.bookmyshow.repository.MovieRepository;
import com.subhash.bookmyshow.repository.ScreenRepository;
import com.subhash.bookmyshow.repository.TheaterRepository;

@RequestMapping("/api")
@RestController
@CrossOrigin
public class LocationController {
	
	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private ScreenRepository screenRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private TheaterRepository theaterRepository;
	
	
	@GetMapping("/bookmyshow")
	public ResponseEntity<List<Location>> getMovieDetailsByLocation(@RequestParam(required = false) String location){
	
		List<Location> locationList = locationRepository.findByLocationName(location);
		System.out.println("location: "+ locationList);
		return new ResponseEntity<List<Location>>(locationList, HttpStatus.OK);
		
	}
	
	@GetMapping("/bookmyshow/all")
	public ResponseEntity<List<Location>> addLocation() {
		List<Location> locationList = locationRepository.findAll();
		  return new ResponseEntity<List<Location>>(locationList, HttpStatus.OK);
	}
	
	@PostMapping("/bookmyshow/add")
	public ResponseEntity<List<Location>> addLocation(@RequestBody LocationRequest request) {
		 locationRepository.save(request.getLocation());
		 List<Location> list = locationRepository.findAll();
		 return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/bookmyshow/updatePrice")
	public ResponseEntity<?> updateMoviePrice(@RequestBody TheaterPriceResponse theaterPriceResponse) {
		Theater theater = theaterRepository.findById(theaterPriceResponse.getTheaterId()).get();
			if(theater.getOwner().equals(theaterPriceResponse.getOwnerName())) {
				Movie movie = movieRepository.findById(theaterPriceResponse.getMovieId()).get();
				movie.setMovieCost(theaterPriceResponse.getUpdatedPrice());
				movieRepository.save(movie);
				return new ResponseEntity<Movie>(movie, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Owner of Theater is wrong", HttpStatus.NOT_FOUND);
			}
		
		
	}

}
