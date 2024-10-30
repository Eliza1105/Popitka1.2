package holidayservice.repository;

import holidayservice.entity.AlcoholFree;
import holidayservice.entity.Marinade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlcoFreeRepo extends JpaRepository<AlcoholFree, Integer> {
    Optional<Marinade> findByName(String name);
}
