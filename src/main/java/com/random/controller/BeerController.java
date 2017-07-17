package com.random.controller;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.random.App;
import com.random.domain.Beer;
import com.random.repository.BeerRepository;

@RestController
@RequestMapping("/api")
public class BeerController {

	private static final Logger log = LoggerFactory.getLogger(App.class);

    
	@Autowired
	private final BeerRepository beerRepository;

	@Autowired
	public BeerController(BeerRepository repository) {
		this.beerRepository = repository;
	}

	/**
	 * Test just to return a string to the front end
	 * @return
	 */
	@RequestMapping("/getBeerTest")
	public String index() {
		return "Test returning a basic string!";
	}

	/**
	 *  Test to get a beer object back to the front end page index.html
	 * @return
	 */
	@RequestMapping("/getHeinekenBeer")
	public Beer getBeersObject() {
		Beer beer = new Beer("Heineken", "lager", 4.2f, "Netherlands");
		return beer;
	}

	/**
	 * Get a random beer
	 * @return
	 */
	@RequestMapping("/getRandomBeer")
	public Beer getRandomBeer() {
		
		
		// Get the count of all beers in the database
		long countAll = beerRepository.count();
		
		// Get a random number between 1 and the max number
		long LOWER_RANGE = 1; // assign lower range value
		long UPPER_RANGE = countAll; // assign upper range value
		//Random random = new Random();
		//long randomId = LOWER_RANGE + (long) (random.nextDouble() * (UPPER_RANGE - LOWER_RANGE));
		long randomId=ThreadLocalRandom.current().nextLong(LOWER_RANGE, UPPER_RANGE);
		
		
		// Get the beer by that random Id
		Beer beer = beerRepository.findById(randomId);
		
		return beer;
	}
}
