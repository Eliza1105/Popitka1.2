package holidayservice.repository;

import holidayservice.entity.Marinade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarinadesRepo extends JpaRepository<Marinade,Integer> {
    Optional<Marinade> findByName(String name);
}
