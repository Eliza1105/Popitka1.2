package holidayservice.repository;

import holidayservice.entity.Alcohol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlcoholRepo extends JpaRepository<Alcohol, Integer> {
    Optional<Alcohol> findByName(String name);
}
