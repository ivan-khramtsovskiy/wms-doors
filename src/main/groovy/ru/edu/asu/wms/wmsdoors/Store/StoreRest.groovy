package ru.edu.asu.wms.wmsdoors.Store

import ru.edu.asu.wms.wmsdoors.Product.Product
import ru.edu.asu.wms.wmsdoors.Warehouse.Warehouse

class StoreRest {
    private Warehouse warehouse
    private Product product
    private Integer quantity

    StoreRest() {
    }

    Warehouse getWarehouse() {
        return warehouse
    }

    void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse
    }

    Product getProduct() {
        return product
    }

    void setProduct(Product product) {
        this.product = product
    }

    Integer getQuantity() {
        return quantity
    }

    void setQuantity(Integer quantity) {
        this.quantity = quantity
    }
}
