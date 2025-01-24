package es.cifpcm.SpringEje4.services;

import es.cifpcm.SpringEje4.models.Animal;

import java.util.List;

public interface AnimalService {

    public List<Animal> getAnimals();

    public Animal getAnimal(int id);

    public Animal addAnimal(Animal animal);

    public Animal editAnimal(Animal animal);

    public void deleteAnimal(int id);
}
