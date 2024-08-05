package com.txrental.tool.config;


import com.txrental.tool.entity.Tool;
import com.txrental.tool.entity.ToolRental;
import com.txrental.tool.repository.ToolRentalRepository;
import com.txrental.tool.repository.ToolRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  This configuration to load database during startup
 */
@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Autowired
	ToolRepository repository;
	@Autowired
	ToolRentalRepository toolRentalRepository;

	@Bean
	CommandLineRunner initDatabase() {

		return args -> {

			/*  To load test data in Tool table */
			log.info("Preloading" + repository.save(new Tool("CHNS","Chainsaw", "Stihl")));
			log.info("Preloading" + repository.save(new Tool("LADW","Ladder", "Werner")));
			log.info("Preloading" + repository.save(new Tool("JAKD","Jackhammer", "DeWalt")));
			log.info("Preloading" + repository.save(new Tool("JAKR","Jackhammer", "Ridgid")));


			/*  To load test data in ToolRental table */
			log.info("Preloading" + toolRentalRepository.save(new ToolRental("Ladder", 1.99,"Yes","Yes","No")));
			log.info("Preloading" + toolRentalRepository.save(new ToolRental("Chainsaw", 1.49,"Yes","No","Yes")));
			log.info("Preloading" + toolRentalRepository.save(new ToolRental("Jackhammer", 2.99,"Yes","No","No")));

		};
	}
}
