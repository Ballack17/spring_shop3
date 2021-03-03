package geekbrains.spring_shop.repositories;

import geekbrains.spring_shop.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Product findByProductName(String productName);
    Optional<Product> findById (Long id);
}
