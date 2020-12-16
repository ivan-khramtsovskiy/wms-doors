package ru.edu.asu.wms.wmsdoors.ProductType

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository

    List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll()
    }

    ProductType updateProductType(ProductType productType, Integer id) {
        ProductType whs = productTypeRepository.getOne(id)
        whs.setName(productType.getName())
        return productTypeRepository.save(whs)
    }

    ProductType createProductType(ProductType productType) {
        return productTypeRepository.save(productType)
    }

    String deleteProductType(Integer id) {
        productTypeRepository.deleteById(id)
        return "Сведения удалены"
    }

    ProductType getProductType(Integer id) {
        return productTypeRepository.getOne(id)
    }
}
