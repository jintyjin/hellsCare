package hells.care;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HellsCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellsCareApplication.class, args);
	}

}
