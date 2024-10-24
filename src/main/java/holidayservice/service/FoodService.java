package holidayservice.service;

import holidayservice.entity.Food;
import holidayservice.repository.FoodRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepo foodRepo;
    public List<Food> findAll(){ return foodRepo.findAll();}

    public Food save(Food food){return foodRepo.save(food);}

    public void deleteById(Integer id){
        foodRepo.deleteById(id);
    };

    public double calculateQuantity(String name, int userInput) {
        Food food = foodRepo.findByName(name).orElseThrow();
        double unitValue = food.getUnit();
        return unitValue * userInput;
    }
}
