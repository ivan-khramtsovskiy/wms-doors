package ru.edu.asu.wms.wmsdoors.Invoice

import org.springframework.data.jpa.repository.JpaRepository

interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}