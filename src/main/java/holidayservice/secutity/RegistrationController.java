package holidayservice.secutity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

   //я не сфоткала, как поменялся этот метод и теперь у меня ошибка 500 при попытке зайти на страницу регистрации
    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        //   model.addAttribute("user", new User());
        if (userFromDb != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/index";
    }
}