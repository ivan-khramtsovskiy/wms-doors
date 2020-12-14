package ru.edu.asu.wms.wmsdoors.ProductType

import lombok.Data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Data
@Entity
class ProductType {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id

    ProductType() {
    }

    Integer getId() {
        return id
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
    private String name
}
