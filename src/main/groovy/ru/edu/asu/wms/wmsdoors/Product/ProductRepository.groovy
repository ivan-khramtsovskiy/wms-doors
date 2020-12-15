package ru.edu.asu.wms.wmsdoors.Product

import org.springframework.data.jpa.repository.JpaRepository
import ru.edu.asu.wms.wmsdoors.ProductType.ProductType

interface ProductRepository extends JpaRepository<Product, Integer>{
    List<Product> findByProductType(ProductType productType)
}