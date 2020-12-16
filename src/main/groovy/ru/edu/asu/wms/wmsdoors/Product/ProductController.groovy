package ru.edu.asu.wms.wmsdoors.Product

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import ru.edu.asu.wms.wmsdoors.ProductType.ProductType
import ru.edu.asu.wms.wmsdoors.ProductType.ProductTypeService
import ru.edu.asu.wms.wmsdoors.Warehouse.Warehouse

@Controller
class ProductController {
    private final Logger logger = LoggerFactory.getLogger(ProductController.class)

    @Autowired
    private ProductService productService

    @Autowired
    private ProductTypeService productTypeService

    @Autowired
    private ProductRepository productRepository

    @GetMapping("/product")
    String getAllProducts(Model model) {
        model.addAttribute("product", productService.getAllProducts())
        model.addAttribute("dictionaryHeader", "Номенклатура")
        return "product/list"
    }

    @GetMapping("/product/create")
    String createProductPage(Model model) {
        Product product = new Product()

        List<ProductType> productTypes = productTypeService.getAllProductTypes()

        model.addAttribute("product", product)
        model.addAttribute("types", productTypes)
        model.addAttribute("isUpdate", false)

        return "product/create-update"
    }

    @PostMapping("/product/create")
    String createProduct(@ModelAttribute("product") Product product) {
        productService.createProduct(product)
        return "redirect:/product"
    }

    @GetMapping("/product/update/{id}")
    String updateProductPage(Model model, @PathVariable("id") Integer id) {
        Product product = productService.getProduct(id)
        List<ProductType> productTypes = productTypeService.getAllProductTypes()

        model.addAttribute("types", productTypes)
        model.addAttribute("selected", product.productType)
        model.addAttribute("product", product)
        model.addAttribute("isUpdate", true)
        return "product/create-update"
    }
    
    @PostMapping("/product/update/{id}")
    String createProduct(@ModelAttribute("product") Product product, @PathVariable("id") Integer id, @RequestParam("productType") Integer typeId) {
        ProductType productType = productTypeService.getProductType(typeId)
        product.setProductType(productType)

        productService.updateProduct(product, id)
        return "redirect:/product"
    }


    @GetMapping("/product/delete/{id}")
    String deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteProduct(id)
        return "redirect:/product"
    }
}