package holidayservice.controller;

import holidayservice.service.AlcoholFreeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AlcoholFreeController {
    private final AlcoholFreeService alcoholFreeService;

    @GetMapping(value = "/alcoholfree")
    public String findAll(Model model){
        model.addAttribute("alcoholfrees", alcoholFreeService.findAll());
        return "alcoholfree";
    }
}
