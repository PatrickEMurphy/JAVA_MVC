package DAW.AnimalPersist.services;


import DAW.AnimalPersist.interfaces.AnimalServiceInterface;
import DAW.AnimalPersist.models.Animal;
import DAW.AnimalPersist.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service
public class AnimalServiceDB implements AnimalServiceInterface {
    @Autowired
    private AnimalRepository ar;

    @Override
    public Optional<Animal> getAnimal(int id) {
        return ar.findById(id);
    }

    @Override
    public Animal addAnimal(Animal animal) {
        return ar.save(animal);
    }

    @Override
    public Animal updateAnimal(int id, Animal updatedAnimal) {
        return ar.findById(id).map(existingAnimal -> {
            existingAnimal.setName(updatedAnimal.getName());
            existingAnimal.setLifeSpan(updatedAnimal.getLifeSpan());
            existingAnimal.setExtinct(updatedAnimal.getExtinct());
            return ar.save(existingAnimal);
        }).orElse(null);
    }

    @Override
    public boolean deleteAnimal(int id) {
        if (ar.existsById(id)) {
            ar.deleteById(id);
            return true;
        }
        return false;
    }
}
