package geekbrains.spring_shop.repositories;

import geekbrains.spring_shop.entities.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);

    List<User> findAll(PageRequest pageRequest);
}
