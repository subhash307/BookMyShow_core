package com.subhash.bookmyshow.json;

import com.subhash.bookmyshow.entity.Location;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LocationRequest {
	
	private Location location;

}
