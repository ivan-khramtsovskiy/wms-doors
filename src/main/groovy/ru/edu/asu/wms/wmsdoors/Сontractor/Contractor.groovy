package ru.edu.asu.wms.wmsdoors.Сontractor

import lombok.Data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Data
@Entity
class Contractor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id

    private String inn
    private String ogrn
    private String name
    private String person
    private String phone
    private String address
    private String email

    Contractor() {
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

    String getInn() {
        return inn
    }

    void setInn(String inn) {
        this.inn = inn
    }

    String getOgrn() {
        return ogrn
    }

    void setOgrn(String ogrn) {
        this.ogrn = ogrn
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    String getPerson() {
        return person
    }

    void setPerson(String person) {
        this.person = person
    }

    String getPhone() {
        return phone
    }

    void setPhone(String phone) {
        this.phone = phone
    }
}
