package holidayservice.controller;

import holidayservice.service.CoctailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CoctailController {
    private final CoctailService coctailService;

    @GetMapping(value = "/coctails")
    public String findAll(Model model){
        model.addAttribute("coctails", coctailService.findAll());
        return "coctails";
    }
}
