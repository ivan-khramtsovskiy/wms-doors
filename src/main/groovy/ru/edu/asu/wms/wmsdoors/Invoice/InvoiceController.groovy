package ru.edu.asu.wms.wmsdoors.Invoice

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
import ru.edu.asu.wms.wmsdoors.Сontractor.ContractorService

@Controller
class InvoiceController {
    private final Logger logger = LoggerFactory.getLogger(InvoiceController.class)

    @Autowired
    private InvoiceService invoiceService

    @Autowired
    private ContractorService contractorService

    @Autowired
    private InvoiceRepository invoiceRepository

    @GetMapping("/invoice")
    String getAllInvoices(Model model) {
        model.addAttribute("invoice", invoiceService.getAllInvoices())
        model.addAttribute("dictionaryHeader", "Накладные")
        return "invoice/list"
    }

    @GetMapping("/invoice/create")
    String createInvoicePage(Model model) {
        Invoice invoice = new Invoice()

        List<invoiceType> invoiceTypes = invoiceTypeService.getAllinvoiceTypes()

        model.addAttribute("invoice", invoice)
        model.addAttribute("types", invoiceTypes)
        model.addAttribute("isUpdate", false)

        return "invoice/create-update"
    }

    @PostMapping("/invoice/create")
    String createinvoice(@ModelAttribute("invoice") invoice invoice) {
        invoiceService.createinvoice(invoice)
        return "redirect:/invoice"
    }

    @GetMapping("/invoice/update/{id}")
    String updateinvoicePage(Model model, @PathVariable("id") Integer id) {
        invoice invoice = invoiceService.getinvoice(id)
        List<invoiceType> invoiceTypes = invoiceTypeService.getAllinvoiceTypes()

        model.addAttribute("types", invoiceTypes)
        model.addAttribute("selected", invoice.invoiceType)
        model.addAttribute("invoice", invoice)
        model.addAttribute("isUpdate", true)
        return "invoice/create-update"
    }

    @PostMapping("/invoice/update/{id}")
    String createinvoice(@ModelAttribute("invoice") invoice invoice, @PathVariable("id") Integer id, @RequestParam("invoiceType") Integer typeId) {
        invoiceType invoiceType = invoiceTypeService.getinvoiceType(typeId)
        invoice.setinvoiceType(invoiceType)

        invoiceService.updateinvoice(invoice, id)
        return "redirect:/invoice"
    }


    @GetMapping("/invoice/delete/{id}")
    String deleteinvoice(@PathVariable("id") Integer id) {
        invoiceService.deleteinvoice(id)
        return "redirect:/invoice"
    }
}