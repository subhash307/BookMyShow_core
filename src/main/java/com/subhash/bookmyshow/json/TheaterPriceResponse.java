package com.subhash.bookmyshow.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TheaterPriceResponse {
	
	private Long theaterId;
	private Long movieId;
	private String ownerName;
	private String updatedPrice;

}
