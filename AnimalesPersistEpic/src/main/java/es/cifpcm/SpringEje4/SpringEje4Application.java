package es.cifpcm.SpringEje4;

import es.cifpcm.SpringEje4.models.Animal;
import es.cifpcm.SpringEje4.repositories.AnimalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringEje4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringEje4Application.class, args);
	}

	@Bean
	CommandLineRunner seedAnimals(AnimalRepository repo) {
		return (args) -> {
			Animal animal1 = new Animal("Dodo", 8, true);
			Animal animal2 = new Animal("T-Rex", 55, true);
			Animal animal3 = new Animal("Tiburón", 70, false);

			repo.save(animal1);
			repo.save(animal2);
			repo.save(animal3);
		};
	}

}
