package springboot22.springboot2022;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Springboot2022Application {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2022Application.class, args);
	}

}
