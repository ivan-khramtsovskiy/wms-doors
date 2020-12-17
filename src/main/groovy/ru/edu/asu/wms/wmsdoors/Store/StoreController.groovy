package ru.edu.asu.wms.wmsdoors.Store

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import ru.edu.asu.wms.wmsdoors.Product.Product
import ru.edu.asu.wms.wmsdoors.Product.ProductService
import ru.edu.asu.wms.wmsdoors.Warehouse.Warehouse
import ru.edu.asu.wms.wmsdoors.Warehouse.WarehouseService
import ru.edu.asu.wms.wmsdoors.Сontractor.Contractor
import ru.edu.asu.wms.wmsdoors.Сontractor.ContractorService

@Controller
class StoreController {
    private final Logger logger = LoggerFactory.getLogger(StoreController.class)

    @Autowired
    StoreService storeService
    @Autowired
    ProductService productService
    @Autowired
    WarehouseService warehouseService
    @Autowired
    ContractorService contractorService


    @GetMapping("/store/debit")
    String createStorePage(Model model) {
        Store store = new Store()

        List<Warehouse> warehouses = warehouseService.getAllWarehouses()
        List<Product> products = productService.getAllProducts()
        List<Contractor> contractors = contractorService.getAllContractors()

        model.addAttribute("store", store)

        model.addAttribute("warehouse", warehouses)
        model.addAttribute("contractor", contractorService.getAllContractors())
        model.addAttribute("product", products)
        model.addAttribute("isUpdate", false)
        return "store/debit-credit"
    }

    @PostMapping("/store/debit")
    String createProduct(@ModelAttribute("store") Store store) {
        storeService.createStore(store)
        return "redirect:/store/debit"
    }

    @GetMapping("/store/rest")
    String getStoreRest(Model model) {
        ArrayList<StoreRest> storeRest = storeService.getStoreRest()

        model.addAttribute("storeRest", storeRest)
        model.addAttribute("dictionaryHeader", "Остатки на складе")
        return "store/store-rest"
    }
}