package gb.nabson.taxonomy.app.web.controller;

import gb.nabson.taxonomy.app.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SubclassDisplayController {
    private ApiService apiService;

    @Autowired
    public SubclassDisplayController(ApiService apiService) {
        this.apiService = apiService;
    }

    // use thymeleaf template to show  all sublcasses for specified division
    @GetMapping("/divisions/{divisionId}/subclasses/display")
    public String displayAllSubclasses(@PathVariable String divisionId, Model model) {
        model.addAttribute("subclasses", apiService.getSubclasses(divisionId));

        model.addAttribute("division", apiService.getDivision(divisionId));
        return "subclasses/display";

    }

}


