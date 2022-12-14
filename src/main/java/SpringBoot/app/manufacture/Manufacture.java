package SpringBoot.app.manufacture;

import SpringBoot.app.product.Product;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
//@Table(name = "manufacture")
@AllArgsConstructor
public class Manufacture {
    private UUID id;
    private  String name;
    Set<Product> products;

    public Manufacture() {}

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy="manufacture", cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SUBSELECT)
    public Set<Product> getProducts() {
        return products;
    }

}
