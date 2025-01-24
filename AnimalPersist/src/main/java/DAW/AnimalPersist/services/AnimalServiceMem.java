package DAW.AnimalPersist.services;

import DAW.AnimalPersist.interfaces.AnimalServiceInterface;
import DAW.AnimalPersist.models.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AnimalServiceMem implements AnimalServiceInterface {
    private List<Animal> animals = new ArrayList<>();
    private int currentId = 1;

    public List<Animal> getAnimals() {
        return animals;
    }

    public Optional<Animal> getAnimal(int id) {
        return animals.stream().filter(a -> a.getId() == id).findFirst();
    }

    public Animal addAnimal(Animal animal) {
        animal.setId(currentId++);
        animals.add(animal);
        return animal;
    }

    public Animal updateAnimal(int id, Animal updatedAnimal) {
        return getAnimal(id).map(animal -> {
            animal.setName(updatedAnimal.getName());
            animal.setLifeSpan(updatedAnimal.getLifeSpan());
            animal.setExtinct(updatedAnimal.getExtinct());
            return animal;
        }).orElse(null);
    }

    public boolean deleteAnimal(int id) {
        return animals.removeIf(animal -> animal.getId() == id);
    }
}