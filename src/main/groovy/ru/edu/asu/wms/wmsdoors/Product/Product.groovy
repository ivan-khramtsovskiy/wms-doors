package ru.edu.asu.wms.wmsdoors.Product

import lombok.Data
import ru.edu.asu.wms.wmsdoors.ProductType.ProductType

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Data
@Entity
@Table(name = "product")
class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id
    private String name

    ProductType getProductType() { return productType }

    void setProductType(ProductType productType) {
        this.productType = productType
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_type_id", nullable = false)
    private ProductType productType

    Product() {}

    Integer getId() { return id }

    void setId(Integer id) { this.id = id }

    String getName() { return name }

    void setName(String name) { this.name = name }
}
