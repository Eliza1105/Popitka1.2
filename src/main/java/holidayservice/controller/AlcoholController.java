package holidayservice.controller;

import holidayservice.service.AlcoholService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AlcoholController {
    private final AlcoholService alcoholService;

    @GetMapping(value = "/alcohol")
    public String findAll(Model model){
        model.addAttribute("alcohols", alcoholService.findAll());
        return "alcohol";
    }
}
