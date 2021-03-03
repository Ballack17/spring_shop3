package geekbrains.spring_shop.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_brand")
public class ProductBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "product_brand_name")
    private String productBrandName;

    public ProductBrand() {    }

    public ProductBrand(String productBrandName) {
        this.productBrandName = productBrandName;
    }
}
