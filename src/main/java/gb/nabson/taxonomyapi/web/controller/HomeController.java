package gb.nabson.taxonomyapi.web.controller;


import gb.nabson.taxonomyapi.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    private DivisionService divisionService;

    @Autowired
    public HomeController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @RequestMapping({"/","" })
    public String home(Model model ) {
        model.addAttribute("divisions", divisionService.getAllDivisions());
        return "index";
    }
}