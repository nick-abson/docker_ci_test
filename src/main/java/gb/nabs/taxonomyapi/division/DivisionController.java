package gb.nabs.taxonomyapi.division;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * GET /divisions  = get all divisions GET /divisions/id = get specific division POST /divisions = create a new division PUT /divisions/id =
 * update the division DELETE /divisions/delete = delete the division
 */
@RestController
public class DivisionController {

    // Spring mvc is added to our app by @SpringApplicatioddn
    //
    // all controllers map a url(html/method) request to a controller object method
    // we map the two together with annotation, as per the below.
    // map method to url (by default all HTTP methods are mapped).
    // Spring can inspect incoming requests and if it find a controller in the class path that has a method mapped to it
    // Spring converts the response according to various sensible defaults (e.g because this is a Restfull service, it assumes
    // you want to send json).
    // the json key names are the object property names.


    //inject the SubclassService service
    @Autowired
    private DivisionService divisionService;

    @GetMapping("/divisions")
    public List<Division> getAllDivisions() {
        return divisionService.getAllDivisions();
    }

    // syntax for matching a variable in the request is {}
    // the @PathVariable annotation tells spring to pass in the variable as a parameter
    @GetMapping("/divisions/{id}")
    public Division getDivision(@PathVariable String id) {
        return divisionService.getDivision(id);
    }


    // use custom properties to map a method to any request that is a POST on /divisions
    // the above mappings are short cuts for GET
    // get the body of the request and convert it to a division
    // the RequestBody annotation tells spring mvc that the body contains a json  represenation of a division instance and that it should
    // convert it to an instance of Subclass
    //@RequestMapping(method = RequestMethod.POST , value = "/divisions")
    // new shorthand:
    @PostMapping("/divisions")
    public void addDivision(@RequestBody Division division) {
        divisionService.addDivision(division);

    }
    @DeleteMapping("divisions/{id}")
    public void deleteDivision(@PathVariable String id) {
       divisionService.deleteDivision(id);
    }

    @PutMapping("/divisions/{id}")
    public void updateDivision(@RequestBody Division division, @PathVariable String id) {
        divisionService.updateDivision(division, id);
    }

}
