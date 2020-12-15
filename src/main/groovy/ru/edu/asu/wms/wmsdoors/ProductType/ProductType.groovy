package ru.edu.asu.wms.wmsdoors.ProductType

import lombok.Data
import ru.edu.asu.wms.wmsdoors.Product.Product

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Data
@Entity
class ProductType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id
    private String name

    @OneToMany(mappedBy = "productType", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<Product> products = new HashSet<Product>()

    Integer getId() {
        return id
    }

    Set<Product> getProducts() {
        return products
    }

    void setProducts(Set<Product> products) {
        this.products = products
    }

    void setId(Integer id) {
        this.id = id
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    ProductType() {
    }
}
