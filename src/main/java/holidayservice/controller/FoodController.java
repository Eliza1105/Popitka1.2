package holidayservice.controller;

import holidayservice.entity.Food;
import holidayservice.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import  java.lang.String;

@Controller
@RequiredArgsConstructor
public class FoodController {
    public final FoodService foodService;
    //private final String uploadDir = "src/main/resources/static/img";
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

   @PostMapping("/create_food")
    public String createFood(@RequestParam("file") MultipartFile file, @ModelAttribute("newFood") Food food) {
        String fileName = file.getOriginalFilename();
        if (!fileName.equals("")){
            File uploadedDirectory = new File("src/main/resources/static/img/");
            try {
                file.transferTo(new File(uploadedDirectory.getAbsolutePath() + "/" + fileName));
                food.setLink("/img/" + fileName);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            food.setLink("/image/not-found.jpg");
        }

        foodService.save(food);
        return "redirect:/food";
    }

    @GetMapping("/quantity")
    public String calculateQuantity(Model model) {
        List<Food> foods = foodService.findAll();
        model.addAttribute("foods", foods);
        return "quantity-result";
    }

    @PostMapping(value = "/delete_food")
public String deleteFood(@PathVariable("id") Integer id){
        foodService.deleteById(id);
        return "redirect:/food";
    }
}