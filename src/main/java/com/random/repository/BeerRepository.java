package com.random.repository;
import org.springframework.data.repository.*;

import com.random.domain.Beer;

public interface BeerRepository extends CrudRepository<Beer, Long> {
	long count();
	
    Beer findByName(String name);
    
    Beer findById(long id);
    
}

