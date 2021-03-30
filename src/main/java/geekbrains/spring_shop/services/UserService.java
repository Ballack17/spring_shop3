package geekbrains.spring_shop.services;

import geekbrains.spring_shop.entities.SystemUser;
import geekbrains.spring_shop.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    void save(SystemUser systemUser);
}
