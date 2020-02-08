package sda.tema.SDA_Tema_4.business;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sda.tema.SDA_Tema_4.security.entitys.User;
import sda.tema.SDA_Tema_4.security.repository.UserDao;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public Optional<User> findUserByEmail(@NotNull String email) {
        return this.userDao.findByEmail(email);
    }

}
