package holidayservice.controller;

import holidayservice.entity.Food;
import holidayservice.entity.FoodDTO;
import holidayservice.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.DatatypeConverter;
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
    /* @PostMapping("/create_food")
    public String createFood(@RequestParam("file") MultipartFile file1, @ModelAttribute("newFood") FoodDTO foodDTO) throws IOException {
        foodService.saveFood(food, file1) ;
        return "redirect:/create_food";
        if (!file.isEmpty()) {
            try {
                // Создаем папку, если она не существует
                File directory = new File(uploadDir);
                if (!directory.exists()) {
                    directory.mkdirs();
                }

                // Создаем путь к файлу
                String filePath = uploadDir + file.getOriginalFilename();
                File destinationFile = new File(filePath);

                // Сохраняем файл
                file.transferTo(destinationFile);
                return "redirect:/success"; // Перенаправление на страницу успеха
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/error"; // Перенаправление на страницу ошибки
    }
    }

     */
   /*  @PostMapping(value = "/create_food")
    public Food createOrSaveFood(Model model, @RequestBody FoodDTO foodDTO){
        String imageBase = foodDTO.getImage().split(",")[1];
        byte[] imageBytes = DatatypeConverter.parseBase64Binary(imageBase);
        Food newFood = new Food(); //id++
        foodService.save(new Food(newFood.getId(), foodDTO.getName(), foodDTO.getDescription(),
                foodDTO.getUnit(), imageBytes));
        model.addAttribute("foods", foodService.findAll());
        return "redirect:/food";
    }

    */

    @GetMapping("/quantity")
    public String calculateQuantity(Model model) {
        List<Food> foods = foodService.findAll();
        model.addAttribute("foods", foods);
        return "quantity-result";
    }

}