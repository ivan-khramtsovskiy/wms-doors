package ru.edu.asu.wms.wmsdoors.Store

import org.hibernate.criterion.CriteriaQuery
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import ru.edu.asu.wms.wmsdoors.Product.ProductService
import ru.edu.asu.wms.wmsdoors.Warehouse.WarehouseService

import javax.persistence.criteria.CriteriaBuilder

@Service
class StoreService {
    private static final Logger logger = LoggerFactory.getLogger(StoreService.class)

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StoreRepository storeRepository

    @Autowired
    ProductService productService

    @Autowired
    WarehouseService warehouseService

    List<Store> getAllStore() {
        return storeRepository.findAll()
    }

    Store updateStore(Store val, Integer id) {
        Store store = storeRepository.getOne(id)
        store.setContractor(val.getContractor())
        store.setProduct(val.getProduct())
        store.setWarehouse(val.getWarehouse())
        store.setContractor(val.getContractor())
        store.setQuantity(val.getQuantity())
        store.setPrice(val.getPrice())
        store.setCreatedAt(val.getCreatedAt())
        return storeRepository.save(store)
    }

    Store createStore(Store store) {
        return storeRepository.save(store)
    }

    String deleteStore(Integer id) {
        storeRepository.deleteById(id)
        return "Сведения удалены"
    }

    Store getStore(Integer id) {
        return storeRepository.getOne(id)
    }

    ArrayList<StoreRest> getStoreRest() {
        String sql = "SELECT warehouse_id, product_id, sum(quantity) as quantity FROM wms_doors.store group by warehouse_id, product_id"
        List<Map<String, Object>> queryResult = jdbcTemplate.queryForList(sql)

        ArrayList<StoreRest> storeRest = new ArrayList<StoreRest>()
        for(it in queryResult) {
            StoreRest st = new StoreRest()
            st.setWarehouse(warehouseService.getWarehouse(it.get("warehouse_id")))
            st.setProduct(productService.getProduct(it.get("product_id")))
            st.setQuantity((Integer)it.get("quantity"))
            storeRest.add(st)
        }

        return storeRest
    }

}
