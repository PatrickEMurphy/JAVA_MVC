package services;

import models.Animal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    private List<Animal> Animals;

    public Animal List(){
        return new Animal();
    }

    public Animal GetAnimal(int id){
        return new Animal();
    }

    public Animal AddAnimal(Animal animal){
        return new Animal();
    }

    public Animal UpdateAnimal(int id, Animal animal){
        return new Animal();
    }

    public Animal DeleteAnimal(int id){
        return new Animal();
    }
}


