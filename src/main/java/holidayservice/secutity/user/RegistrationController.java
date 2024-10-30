package holidayservice.secutity.user;

import holidayservice.secutity.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserRepo userRepo;

    @GetMapping(value = "/login")
    public String login(User user, Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/registration")
    public String registr(User user) {
        return "registration";
    }

        @PostMapping("/registration")
        public String registration(@ModelAttribute User user) {
        System.out.println("====="+user.toString());
          //  User userFromDb = userRepo.findByUsername(user.getUsername());

            user.setRoles(Role.ROLE_USER);
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            System.out.println("====="+user.toString());
            userRepo.save(user);

            return "redirect:/";
        }
    }
