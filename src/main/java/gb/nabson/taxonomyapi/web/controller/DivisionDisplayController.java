package gb.nabson.taxonomyapi.web.controller;

import gb.nabson.taxonomyapi.service.DivisionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DivisionDisplayController {
    private DivisionService divisionService;

    @Autowired
    public DivisionDisplayController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    // use thymeleaf template to show all divisions
    @GetMapping("/divisions/display")
    public String displayAllDivisions(Model model) {
        model.addAttribute("divisions", divisionService.getAllDivisions());

        return "divisions/display";
    }

}


