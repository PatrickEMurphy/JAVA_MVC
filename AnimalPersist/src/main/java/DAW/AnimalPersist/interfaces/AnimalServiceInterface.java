package DAW.AnimalPersist.interfaces;

import DAW.AnimalPersist.models.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalServiceInterface {

    List<Animal> getAnimals();

    Optional<Animal> getAnimal(int id);

    Animal addAnimal(Animal animal);

    Animal updateAnimal(int id, Animal updatedAnimal);

    boolean deleteAnimal(int id);
}
