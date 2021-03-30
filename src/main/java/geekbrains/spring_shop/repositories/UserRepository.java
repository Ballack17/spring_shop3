package geekbrains.spring_shop.repositories;


import geekbrains.spring_shop.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByUserName(String userName);
}
