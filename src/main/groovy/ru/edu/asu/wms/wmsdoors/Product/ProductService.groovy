package ru.edu.asu.wms.wmsdoors.Product

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.edu.asu.wms.wmsdoors.ProductType.ProductType
import ru.edu.asu.wms.wmsdoors.ProductType.ProductTypeRepository

@Service
class ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class)

    @Autowired
    private ProductRepository productRepository

    List<Product> getAllProducts() {
        return productRepository.findAll()
    }

    Product updateProduct(Product product, Integer id) {
        Product whs = productRepository.getOne(id)
        whs.setName(product.getName())
        whs.setProductType(product.getProductType())
        return productRepository.save(whs)
    }

    Product createProduct(Product product) {
        return productRepository.save(product)
    }

    String deleteProduct(Integer id) {
        productRepository.deleteById(id)
        return "Сведения удалены"
    }

    Product getProduct(Integer id) {
        return productRepository.getOne(id)
    }

    List<Product> getByProductType(ProductType productType) {
        productRepository.findByProductType(productType)
    }
}
