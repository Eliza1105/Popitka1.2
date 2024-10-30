package holidayservice.secutity.user;

import holidayservice.secutity.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    private final UserRepo userRepo;

    @GetMapping("/userList")
    @PreAuthorize("hasRole('ADMIN')")
    public String userList(Model model) {
        List<User> users=userRepo.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/delete_user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id); // Удаляем блюдо по ID
        return "redirect:/userList";
    }

    @GetMapping(value ="/user_save/{id}")
    public String updateUser(@PathVariable Long id, User user, Model model) {
        model.addAttribute("user", userService.findById(id));
        System.out.println(user.toString());
        return "user_save";
    }
    @PostMapping("/user_save")
    public String updateUser(@ModelAttribute User user, Model model) {
        System.out.println(user.toString());
        User userDb = userService.findById(user.getId());
        System.out.println(userDb.toString());

        userDb.setUsername(user.getUsername());
        userDb.setRoles(user.getRoles());

        userService.save(userDb);
        return "redirect:/userList";
    }

}