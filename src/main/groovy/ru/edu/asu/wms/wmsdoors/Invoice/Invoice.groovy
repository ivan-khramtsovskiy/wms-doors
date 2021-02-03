package ru.edu.asu.wms.wmsdoors.Invoice

import lombok.Data
import ru.edu.asu.wms.wmsdoors.Сontractor.Contractor

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
@Table(name = "invoice")
class Invoice {
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

    Date getDate() {
        return date
    }

    void setDate(Date date) {
        this.date = date
    }

    Contractor getContractor() {
        return contractor
    }

    void setContractor(Contractor contractor) {
        this.contractor = contractor
    }
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id
    private String name
    private Date date

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contractor_id", nullable = false)
    private Contractor contractor

}
