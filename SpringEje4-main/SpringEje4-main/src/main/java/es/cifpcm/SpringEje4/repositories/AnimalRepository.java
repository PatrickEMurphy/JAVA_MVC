package es.cifpcm.SpringEje4.repositories;

import es.cifpcm.SpringEje4.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.repository.CrudRepository;*/

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
