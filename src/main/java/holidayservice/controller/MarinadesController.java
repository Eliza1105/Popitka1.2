package holidayservice.controller;

import holidayservice.entity.Marinade;
import holidayservice.service.MarinadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class MarinadesController {
    private final MarinadeService marinadeService;

    @GetMapping(value = "/marinades")
    public String findAll(Model model){
        model.addAttribute("marinades", marinadeService.findAll());
        return "marinades";
    }

    @GetMapping(value ="/create_marinade")
    public String createFood(Model model) {
        model.addAttribute("marinade", new Marinade());
        return "create_marinade";
    }

    @PostMapping("/create_marinade")
    public String createMarinade(@RequestParam("file") MultipartFile file, @ModelAttribute("newMarinade") Marinade marinad) {
        String fileName = file.getOriginalFilename();
        if (!fileName.equals("")){
            File uploadedDirectory = new File("src/main/resources/static/img/");
            try {
                file.transferTo(new File(uploadedDirectory.getAbsolutePath() + "/" + fileName));
                marinad.setLink("/img/" + fileName);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            marinad.setLink("/image/not-found.jpg");
        }

        marinadeService.save(marinad);
        return "redirect:/marinades";
    }
}
