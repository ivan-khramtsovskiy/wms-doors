package ru.edu.asu.wms.wmsdoors.Store

import lombok.Data
import ru.edu.asu.wms.wmsdoors.Product.Product
import ru.edu.asu.wms.wmsdoors.Warehouse.Warehouse
import ru.edu.asu.wms.wmsdoors.Сontractor.Contractor

import javax.persistence.*

@Data
@Entity
@Table(name = "store")
class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id

    private Integer quantity
    private Double price

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id", nullable = false)
    private Contractor contractor

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse

    Store() {
    }

    Integer getId() {
        return id
    }

    void setId(Integer id) {
        this.id = id
    }

    Contractor getContractor() {
        return contractor
    }

    void setContractor(Contractor contractor) {
        this.contractor = contractor
    }

    Product getProduct() {
        return product
    }

    void setProduct(Product product) {
        this.product = product
    }

    Warehouse getWarehouse() {
        return warehouse
    }

    void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse
    }

    Integer getQuantity() {
        return quantity
    }

    void setQuantity(Integer quantity) {
        this.quantity = quantity
    }

    Double getPrice() {
        return price
    }

    void setPrice(Double price) {
        this.price = price
    }
}