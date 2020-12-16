package ru.edu.asu.wms.wmsdoors.store

import org.springframework.data.jpa.repository.JpaRepository
import ru.edu.asu.wms.wmsdoors.ProductType.ProductType

interface StoreRepository extends JpaRepository<Store, Integer>{

}