package holidayservice.controller;

import holidayservice.entity.Food;
import holidayservice.entity.FoodDTO;
import holidayservice.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.DatatypeConverter;
import java.util.List;
import  java.lang.String;

@Controller
@RequiredArgsConstructor
public class FoodController {
    public final FoodService foodService;
    @GetMapping(value = "/")
    public String index(){
        return "index";
    }
    @GetMapping(value = "/food")
   public String findAll(Model model){
        model.addAttribute("foods", foodService.findAll());
        return "food";
    }

    @GetMapping(value ="/create_food")
    public String createFood(Model model) {
        model.addAttribute("food", new Food());
        return "create_food";
    }
@PostMapping(value = "/create_food")
  public Food createOrSaveFood(Model model, @RequestBody FoodDTO foodDTO){
        String imageBase = foodDTO.getImage().split(",")[1];
    byte[] imageBytes = DatatypeConverter.parseBase64Binary(imageBase);
    Food newFood = new Food(); //id++
     foodService.save(new Food(newFood.getId(), foodDTO.getName(), foodDTO.getDescription(),
            foodDTO.getUnit(), imageBytes));
    model.addAttribute("foods", foodService.findAll());
    return "redirect:/food";
}

    /*@GetMapping("/quantity")
    public String calculateQuantity(Model model) {
        List<Food> foods = foodService.findAll();
        model.addAttribute("foods", foods);
        return "quantity-result";
    }
     */
    }
