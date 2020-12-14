package ru.edu.asu.wms.wmsdoors.Warehouse
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
class Warehouse {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id

    Warehouse() {
    }

    Integer getId() {
        return id
    }

    void setId(Integer id) {
        this.id = id
    }

    String getAddress() {
        return address
    }

    void setAddress(String address) {
        this.address = address
    }

    String getDescription() {
        return description
    }

    void setDescription(String description) {
        this.description = description
    }
    private String address
    private String description
}
