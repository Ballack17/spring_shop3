package geekbrains.spring_shop.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product_group")
public class ProductGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "product_group_name")
    private String productGroupName;

    public ProductGroup() {    }

    public ProductGroup(String productGroupName) {
        this.productGroupName = productGroupName;
    }
}
