package sda.tema.SDA_Tema_4.controller.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sda.tema.SDA_Tema_4.controller.auth.payload.extra.UserIdentityAvailability;
import sda.tema.SDA_Tema_4.controller.auth.payload.extra.UserSummary;
import sda.tema.SDA_Tema_4.security.UserPrincipal;
import sda.tema.SDA_Tema_4.security.annotations.CurrentUser;
import sda.tema.SDA_Tema_4.security.repository.UserDao;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserDao userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserDao userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/user/me")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    @PreAuthorize("hasRole('USER')")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    @PreAuthorize("hasRole('USER')")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

}
