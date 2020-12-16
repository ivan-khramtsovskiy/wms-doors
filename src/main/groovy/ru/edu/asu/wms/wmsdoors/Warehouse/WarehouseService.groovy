package ru.edu.asu.wms.wmsdoors.Warehouse

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository

    List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll()
    }

    Warehouse updateWarehouse(Warehouse warehouse, Integer id) {
        Warehouse whs = warehouseRepository.getOne(id)
        whs.setAddress(warehouse.getAddress())
        whs.setDescription(warehouse.getDescription())
        return warehouseRepository.save(whs)
    }

    Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse)
    }

    String deleteWarehouse(Integer id) {
        warehouseRepository.deleteById(id)
        return "Сведения о складе удалены"
    }

    Warehouse getWarehouse(Integer id) {
        return warehouseRepository.getOne(id)
    }
}
