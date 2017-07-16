package com.random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.random.domain.Beer;
import com.random.repository.BeerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx, BeerRepository repository) {
        return args -> {
        	repository.save(new Beer("Guiness","stout", 4.2f, "Ireland"));
        	repository.save(new Beer("Bulmers","cider", 4.2f, "Ireland"));
        	repository.save(new Beer("Heineken","lager", 4.2f, "Netherlands"));
			// fetch all Beers
			log.info("Beers found with findAll():");
			log.info("-------------------------------");
			for (Beer beer : repository.findAll()) {
				log.info("Id=" + beer.getId() + ", beer=" + beer.getName());
			}
			log.info("");

			// fetch an individual Beer by ID
			Beer Beer = repository.findOne(1L);
			log.info("Beer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(Beer.getName());
			log.info("");

			// fetch Beers by last name
			log.info("Beer found with findByName('Heineken'):");
			log.info("--------------------------------------------");
			Beer heineken = repository.findByName("Heineken");
			log.info(heineken.getName());
			
			log.info("");        	
            /* System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }*/

        };
    }
}
