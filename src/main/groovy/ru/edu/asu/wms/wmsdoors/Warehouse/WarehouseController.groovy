package ru.edu.asu.wms.wmsdoors.Warehouse

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class WarehouseController {
    @Autowired
    private WarehouseService warehouseService

    @GetMapping("/warehouse")
    String getAllWarehouses(Model model) {
        List<Warehouse> warehouses = warehouseService.getAllWarehouses()
        model.addAttribute("warehouses", warehouses)
        model.addAttribute("dictionaryHeader", "Складские помещения")
        return "warehouse/list"
    }

    @GetMapping("/warehouse/create")
    String createWarehousePage(Model model) {
        Warehouse warehouse = new Warehouse()
        model.addAttribute("warehouse", warehouse)
        model.addAttribute("isUpdate", false)
        return "warehouse/create-update"
    }

    @PostMapping("/warehouse/create")
    String createWarehouse(@ModelAttribute("warehouse") Warehouse warehouse) {
        warehouseService.createWarehouse(warehouse)
        return "redirect:/warehouse"
    }

    @GetMapping("/warehouse/update/{id}")
    String updateWarehousePage(Model model, @PathVariable("id") Integer id) {
        Warehouse warehouse = warehouseService.getWarehouse(id)
        model.addAttribute("warehouse", warehouse)
        model.addAttribute("isUpdate", true)
        return "warehouse/create-update"
    }

    @PostMapping("/warehouse/update/{id}")
    String createWarehouse(@ModelAttribute("warehouse") Warehouse warehouse, @PathVariable("id") Integer id) {
        warehouseService.updateWarehouse(warehouse, id)
        return "redirect:/warehouse"
    }

    @GetMapping("/warehouse/delete/{id}")
    String deleteWarehouse(@PathVariable("id") Integer id) {
        warehouseService.deleteWarehouse(id)
        return "redirect:/warehouse"
    }
}
