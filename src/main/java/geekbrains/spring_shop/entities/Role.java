package geekbrains.spring_shop.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "role_name")
    private String roleName;

    public Role() {}

    public Role(long id, String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", name='" + roleName + '\'' + '}';
    }

}
