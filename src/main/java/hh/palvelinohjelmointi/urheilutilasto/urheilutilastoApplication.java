package hh.palvelinohjelmointi.urheilutilasto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.urheilutilasto.domain.Score;
import hh.palvelinohjelmointi.urheilutilasto.domain.ScoreRepository;

@SpringBootApplication
public class urheilutilastoApplication {
	private static final Logger log = LoggerFactory.getLogger(urheilutilastoApplication.class);

	public static void main(String[] args) {
		/* Responsible for launching the boot application. */
		SpringApplication.run(urheilutilastoApplication.class, args);
	}

	@Bean
	public CommandLineRunner scoreDemo(ScoreRepository scoreRepository) {
		return (args) -> {
			log.info("Save a couple of scores :)");
			//scoreRepository.save(new Score("BO3", "Sampo K", "Seppo A", "Sampo K", "1", [null, null, null] 6));
			//scoreRepository.save(new Score("BO3", "Seppo A", "Sampo K", "Seppo A", "1-2", 1-2, 11));

			log.info("fetch all scores:");
			for (Score score : scoreRepository.findAll()) {
				log.info(score.toString());
			}
		};
	}
}

