package holidayservice.service;

import holidayservice.entity.Food;
import holidayservice.repository.FoodRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepo foodRepo;
    public List<Food> findAll(){ return foodRepo.findAll();}
    public double calculateQuantity(String name, int userInput) {
        Food food = foodRepo.findByName(name).orElseThrow();
        double unitValue = food.getUnit();
        return unitValue * userInput;
    }

}
