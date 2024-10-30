package holidayservice.secutity.user;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
@Autowired
    private  UserRepo userRepo;

@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        return new MyUserDetails(userRepo.findByUsername(username));
    }
    public void deleteById(Long id){
        userRepo.deleteById(id);
    }

    public User findById(Long id){return userRepo.findById(id).get();}

    public User save(User user){return userRepo.save(user);}
}
