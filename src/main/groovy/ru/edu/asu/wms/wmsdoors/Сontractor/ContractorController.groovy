package ru.edu.asu.wms.wmsdoors.Сontractor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class ContractorController {
    @Autowired
    private ContractorService contractorService

    @GetMapping("/contractor")
    String getAllContractors(Model model) {
        List<Contractor> contractors = contractorService.getAllContractors()
        model.addAttribute("contractors", contractors)
        model.addAttribute("dictionaryHeader", "Контрагенты")
        return "contractor/list"
    }

    @GetMapping("/contractor/create")
    String createContractorPage(Model model) {
        Contractor contractor = new Contractor()
        model.addAttribute("contractor", contractor)
        model.addAttribute("isUpdate", false)
        return "contractor/create-update"
    }

    @GetMapping("/contractor/update/{id}")
    String updateContractorPage(Model model, @PathVariable("id") Integer id) {
        Contractor contractor = contractorService.getContractor(id)
        model.addAttribute("contractor", contractor)
        model.addAttribute("isUpdate", true)
        return "contractor/create-update"
    }

    @GetMapping("/contractor/{id}")
    String getContractor(Model model, @PathVariable("id") Integer id) {
        Contractor contractor = contractorService.getContractor(id)
        model.addAttribute("contractor", contractor)
        model.addAttribute("dictionaryHeader", "Сведения о контрагенте")
        return "contractor/item"
    }

    @PostMapping("/contractor/update/{id}")
    String createContractor(@ModelAttribute("contractor") Contractor contractor, @PathVariable("id") Integer id) {
        contractorService.updateContractor(contractor, id)
        return "redirect:/contractor"
    }

    @PostMapping("/contractor/create")
    String createContractor(@ModelAttribute("contractor") Contractor contractor) {
        contractorService.createContractor(contractor)
        return "redirect:/contractor"
    }

    @GetMapping("/contractor/delete/{id}")
    String deleteContractor(@PathVariable("id") Integer id) {
        contractorService.deleteContractor(id)
        return "redirect:/contractor"
    }
}
