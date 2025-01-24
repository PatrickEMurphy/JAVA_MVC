package es.cifpcm.SpringEje4.services;

import es.cifpcm.SpringEje4.models.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class AnimalServiceMem implements AnimalService{


    private List<Animal> animales = new ArrayList<Animal>(Arrays.asList(
            new Animal(1, "Dodo", 50, true)
    ));

    private int animalsCount = 1;

    public List<Animal> getAnimals() {
        return animales;
    }

    public Animal getAnimal(int id){
        return animales.stream()
                .filter(a -> id == a.getId())
                .findAny()
                .orElse(null);
    }

    public Animal addAnimal(Animal animal){
        animal.setId(++animalsCount);
        animales.add(animal);

        return animal;
    }

    public Animal editAnimal(Animal animal){
        Animal animalAux = getAnimal(animal.getId());

        if(animalAux != null){
            int pos = animales.indexOf(animalAux);
            animales.remove(pos);
            animales.add(pos, animal);
        }

        return animal;
    }

    public void deleteAnimal(int id){
        Animal animalAux = getAnimal(id);

        if(animalAux != null){
            int pos = animales.indexOf(animalAux);
            animales.remove(pos);
        }
    }


}
