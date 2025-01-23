package DAW.AnimalPersist.repositories;

import DAW.AnimalPersist.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
