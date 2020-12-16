package ru.edu.asu.wms.wmsdoors.Store

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import ru.edu.asu.wms.wmsdoors.Warehouse.Warehouse

interface StoreRepository extends JpaRepository<Store, Integer> {

}