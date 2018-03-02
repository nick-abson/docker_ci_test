package gb.nabson.taxonomy.app.web.controller;


import gb.nabson.taxonomy.app.api.model.DivisionList;
import gb.nabson.taxonomy.app.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    private ApiService apiService;

    @Autowired
    public HomeController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping({"/","/divisions/display"})
    public String index(Model model) {
        model.addAttribute("divisions", apiService.getDivisions());
        return "divisions/display";
    }
}