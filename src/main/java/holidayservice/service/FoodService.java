package holidayservice.service;

import holidayservice.entity.Food;
import holidayservice.repository.FoodRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepo foodRepo;
    public List<Food> findAll(){ return foodRepo.findAll();}

    public Food save(Food food){return foodRepo.save(food);}

    public void deleteById(Integer id){
        foodRepo.deleteById(id);
    };

    public Food findById(Integer id){
        return foodRepo.findById(id).get();
    }
}
