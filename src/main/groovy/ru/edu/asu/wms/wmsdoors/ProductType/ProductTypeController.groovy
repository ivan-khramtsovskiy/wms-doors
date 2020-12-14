package ru.edu.asu.wms.wmsdoors.ProductType

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class ProductTypeController {
    @Autowired
    private ProductTypeService productTypeService

    @GetMapping("/product-type")
    String getAllProductTypes(Model model) {
        model.addAttribute("productType", productTypeService.getAllProductTypes())
        model.addAttribute("dictionaryHeader", "Типы номенклатуры")
        return "product-type/list"
    }

    @GetMapping("/product-type/create")
    String createProductTypePage(Model model) {
        model.addAttribute("productType", new ProductType())
        model.addAttribute("isUpdate", false)
        return "product-type/create-update"
    }

    @GetMapping("/product-type/update/{id}")
    String updateProductTypePage(Model model, @PathVariable("id") Integer id) {
        ProductType productType = productTypeService.getProductType(id)

        model.addAttribute("productType", productType)
        model.addAttribute("isUpdate", true)
        return "product-type/create-update"
    }
    
    @PostMapping("/product-type/update/{id}")
    String createProductType(@ModelAttribute("productType") ProductType productType, @PathVariable("id") Integer id) {
        productTypeService.updateProductType(productType, id)
        return "redirect:/product-type"
    }

    @PostMapping("/product-type/create")
    String createProductType(@ModelAttribute("productType") ProductType productType) {
        productTypeService.createProductType(productType)
        return "redirect:/product-type"
    }

    @GetMapping("/product-type/delete/{id}")
    String deleteProductType(@PathVariable("id") Integer id) {
        productTypeService.deleteProductType(id)
        return "redirect:/product-type"
    }
}
