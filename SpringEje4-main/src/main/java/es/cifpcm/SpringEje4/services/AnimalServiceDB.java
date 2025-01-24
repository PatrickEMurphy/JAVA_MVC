package es.cifpcm.SpringEje4.services;

import es.cifpcm.SpringEje4.models.Animal;
import es.cifpcm.SpringEje4.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class AnimalServiceDB implements AnimalService{

    @Autowired
    private AnimalRepository ar;

    public List<Animal> getAnimals() {
        return ar.findAll();
    }

    public Animal getAnimal(int id){
        return ar.findById(id).orElse(null);
    }

    public Animal addAnimal(Animal animal){
        return ar.save(animal);
    }

    public Animal editAnimal(Animal animal){
        return ar.save(animal);
    }

    public void deleteAnimal(int id){
        ar.deleteById(id);
    }

}

