package ru.edu.asu.wms.wmsdoors.store

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StoreService {
    private static final Logger logger = LoggerFactory.getLogger(StoreService.class)

    @Autowired
    private StoreRepository storeRepository

    List<Store> getAllProducts() {
        return storeRepository.findAll()
    }

    Store updateProduct(Store val, Integer id) {
        Store store = storeRepository.getOne(id)
        store.setContractor(val.getContractor())
        store.setProduct(val.getProduct())
        store.setWarehouse(val.getWarehouse())
        store.setContractor(val.getContractor())
        store.setQuantity(val.getQuantity())
        store.setPrice(val.getPrice())
        return storeRepository.save(store)
    }

    Store createProduct(Store product) {
        return storeRepository.save(product)
    }

    String deleteProduct(Integer id) {
        storeRepository.deleteById(id)
        return "Сведения удалены"
    }

    Store getProduct(Integer id) {
        return storeRepository.getOne(id)
    }

}
