package ru.edu.asu.wms.wmsdoors.Store

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface StoreRepository extends JpaRepository<Store, Integer> {
//    @Query("SELECT warehouse_id, product_id, sum(quantity) as quantity FROM wms_doors.store group by warehouse_id, product_id")
//    Optional<List<Object[]>> getStoreRest()

}