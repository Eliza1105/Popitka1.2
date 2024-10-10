package holidayservice.repository;

import holidayservice.entity.Food;
import holidayservice.entity.FoodDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepo extends JpaRepository<Food,Integer> {
    Optional<Food> findByName(String name);

}
