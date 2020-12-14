package ru.edu.asu.wms.wmsdoors

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class DefaultController {
    @Value('${app.name}')
    private String appName

    @Value('${app.title}')
    private String appTitle

    @Value('${app.author}')
    private String appAuthor

    @GetMapping("/")
    String index(Model model) {
        model.addAttribute("name", appName)
        model.addAttribute("title", appTitle)
        model.addAttribute("author", appAuthor)

        model.addAttribute("warehouse", "/warehouse")
        return 'index'
    }
}
