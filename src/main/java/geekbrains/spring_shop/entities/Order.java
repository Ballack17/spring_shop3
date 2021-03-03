package geekbrains.spring_shop.entities;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "id_user")
    private User user;

    @Column(name = "date")
    private Date date;

    @Column(name = "total_price")
    private double totalPrice;

    @ManyToMany
    @JoinTable (
            name = "sales",
            joinColumns = @JoinColumn (name = "id_order"),
            inverseJoinColumns = @JoinColumn (name = "id_product")
    )
    private List<Product> products;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                ", products=" + products +
                '}';
    }
}
