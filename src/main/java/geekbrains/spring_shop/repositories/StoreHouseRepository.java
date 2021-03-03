package geekbrains.spring_shop.repositories;

import geekbrains.spring_shop.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreHouseRepository extends CrudRepository<Product, Long> {


}
