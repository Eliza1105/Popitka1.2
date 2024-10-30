package holidayservice.repository;

import holidayservice.entity.Coctail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoctailRepo extends JpaRepository<Coctail, Integer> {
    Optional<Coctail> findByName(String name);
}
