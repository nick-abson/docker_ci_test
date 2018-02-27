package gb.nabson.taxonomyapi.web.controller;

import gb.nabson.taxonomyapi.service.DivisionService;
import gb.nabson.taxonomyapi.service.SubclassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SubclassDisplayController {
    private SubclassService subclassService;
    private DivisionService divisionService;

    @Autowired
    public SubclassDisplayController(SubclassService subclassService, DivisionService divisionService) {
        this.subclassService = subclassService;
        this.divisionService = divisionService;
    }

    // use thymeleaf template to show  all sublcasses for specified division
    @GetMapping("/divisions/{divisionId}/subclasses/display")
    public String displayAllSubclasses(@PathVariable String divisionId, Model model) {
        model.addAttribute("subclasses", subclassService.getAllSubclasses(divisionId));
        model.addAttribute("division", divisionService.getDivisionById(divisionId));
        return "subclasses/display";

    }

}


