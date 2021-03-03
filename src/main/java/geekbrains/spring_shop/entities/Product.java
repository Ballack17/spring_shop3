package geekbrains.spring_shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private double price;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "product_brand_id")
    private ProductBrand productBrand;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "product_group_id")
    private  ProductGroup productGroup;

    @ManyToMany
    @JoinTable (
            name = "sales",
            joinColumns = @JoinColumn (name = "id_product"),
            inverseJoinColumns = @JoinColumn (name = "id_order")
    )
    private List<Order> orders;

    public Product() {    }

    public Product(String productName, double price, ProductBrand productBrand, ProductGroup productGroup, int quantityInStock) {
        this.productName = productName;
        this.price = price;
        this.productBrand = productBrand;
        this.productGroup = productGroup;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", productBrand=" + productBrand +
                ", productGroup=" + productGroup +
                '}';
    }
}
