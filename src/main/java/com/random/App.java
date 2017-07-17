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
        	repository.save(new Beer("Guiness","is an Irish dry stout that originated in Dublin, Ireland. It was introduced in 1759. Guinness is one of the most successful beer brands worldwide. It is brewed in almost 50 countries and is available in over 120.", 4.3f, "Ireland"));
        	repository.save(new Beer("Bulmers","Bulmers is branded as Magners Irish Cider outside the Republic of Ireland. It is produced in county Tipperary. it was introduced in 1937", 4.5f, "Ireland"));
        	repository.save(new Beer("Heineken","Heineken is a pale lager beer, it was introduced in 1873.  In 2011, 2.74 billion litres of Heineken brand beer were produced worldwide.Heineken has been sold in more than 170 countries", 5.0f, "Netherlands"));
        	repository.save(new Beer("Kinnegar Rustbucket","Kinnegar Rustbucket is a rye ale. rye ales are unusual in Ireland but they have been taking off in the US for a while", 5.1f, "Ireland"));
        	repository.save(new Beer("Budweiser","Budweiser is an American-style pale lager. It was introduced in 1876.  It is made with up to 30% rice in addition to hops and barley malt.", 5.0f, "USA"));
        	repository.save(new Beer("Corona","Corona is a pale lager produced in Mexico. It was introduced in 1925. It is one of the top selling beers worldwide. It is commonly served with a wedge of lime or lemon", 4.5f, "Mexico"));
        	repository.save(new Beer("Coors Light","Coors Light is brewed in Golden, Colerado. It was introduced in 1978. The water from the Rocky Mountains is the primary source of water in this beer", 4.2f, "US"));
        	repository.save(new Beer("Miller","Miller is a pale lager that is produced in Wisconson, USA. It was introduced in 1855", 4.66f, "USA"));
        	repository.save(new Beer("Stella Artois","Stela Artois is a pale lager made in Belgium. It was introduced in 1926", 5.0f, "Belgium"));
        	
        	repository.save(new Beer("","", 0.0f, ""));//blank entry, bug fix
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
