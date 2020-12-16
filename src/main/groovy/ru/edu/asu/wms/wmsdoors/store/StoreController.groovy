package ru.edu.asu.wms.wmsdoors.store

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import ru.edu.asu.wms.wmsdoors.ProductType.ProductType
import ru.edu.asu.wms.wmsdoors.ProductType.ProductTypeService

@Controller
class StoreController {
    private final Logger logger = LoggerFactory.getLogger(StoreController.class)

    @Autowired
    private StoreService productService

    @Autowired
    private ProductTypeService productTypeService

    @Autowired
    private StoreRepository productRepository

    @GetMapping("/product")
    String getAllProducts(Model model) {
        model.addAttribute("product", productService.getAllProducts())
        model.addAttribute("dictionaryHeader", "Номенклатура")
        return "product/list"
    }

    @GetMapping("/product/create")
    String createProductPage(Model model) {
        Store product = new Store()

        List<ProductType> productTypes = productTypeService.getAllProductTypes()

        model.addAttribute("product", product)
        model.addAttribute("types", productTypes)
        model.addAttribute("isUpdate", false)

        return "product/create-update"
    }

    @GetMapping("/product/update/{id}")
    String updateProductPage(Model model, @PathVariable("id") Integer id) {
        Store product = productService.getProduct(id)
        List<ProductType> productTypes = productTypeService.getAllProductTypes()

        model.addAttribute("types", productTypes)
        model.addAttribute("selected", product.productType)
        model.addAttribute("product", product)
        model.addAttribute("isUpdate", true)
        return "product/create-update"
    }
    
    @PostMapping("/product/update/{id}")
    String createProduct(@ModelAttribute("product") Store product, @PathVariable("id") Integer id, @RequestParam("productType") Integer typeId) {
        ProductType productType = productTypeService.getProductType(typeId)
        product.setProductType(productType)

        productService.updateProduct(product, id)
        return "redirect:/product"
    }

    @PostMapping("/product/create")
    String createProduct(@ModelAttribute("product") Store product) {
        productService.createProduct(product)
        return "redirect:/product"
    }

    @GetMapping("/product/delete/{id}")
    String deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id)
        return "redirect:/product"
    }
}