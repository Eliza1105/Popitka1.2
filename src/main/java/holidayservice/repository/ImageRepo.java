package holidayservice.repository;

import holidayservice.entity.ImagesFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepo extends JpaRepository<ImagesFood, Integer> {
}
