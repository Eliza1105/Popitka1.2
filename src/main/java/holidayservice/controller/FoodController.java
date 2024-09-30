package holidayservice.controller;

import holidayservice.entity.Food;
import holidayservice.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @GetMapping("/calculate-quantity")
    public String calculateQuantity(@RequestParam String name, @RequestParam int userInput, Model model) {
        double quantity = foodService.calculateQuantity(name, userInput);
        model.addAttribute("quantity", quantity);
        return "quantity-result";
    }
}
