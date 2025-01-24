package DAW.AnimalPersist.repositories;

import DAW.AnimalPersist.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    Animal create(Animal t);

    void delete(Animal t);

    Animal find(Animal t);

    Animal update(Animal t);

    List<Animal> findAll();
}
