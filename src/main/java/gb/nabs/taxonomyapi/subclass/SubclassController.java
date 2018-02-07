package gb.nabs.taxonomyapi.subclass;


import gb.nabs.taxonomyapi.division.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * GET /divisions  = get all divisions GET /divisions/id = get specific division POST /divisions = create a new division PUT /divisions/id =
 * update the division DELETE /divisions/delete = delete the division
 */
@RestController
public class SubclassController {

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
    private SubclassService subclassService;

    @Autowired
    private DivisionService divisionService;

    @GetMapping("/divisions/{divisionId}/subclasses")
    public List<Subclass> getAllSubclasses(@PathVariable String divisionId) {
        return subclassService.getAllSubclasses(divisionId);
    }

    @GetMapping("/divisions/{divisionId}/subclasses/{id}")
    public Subclass getSubclass(@PathVariable String id) {
        return subclassService.getSubclass(id);
    }

    @PostMapping("/divisions/{divisionId}/subclasses/")
    public void addSubclass(@RequestBody Subclass subclass, @PathVariable String divisionId) {
        subclassService.addSubclass(divisionId, subclass);
    }

    @DeleteMapping("divisions/subclasses/{id}")
    public void deleteSubclass(@PathVariable String id) {
       subclassService.deleteSubclass(id);
    }

    @PutMapping("/divisions/{divisionId}/subclasses/{id}")
    public void updateSubclass(@RequestBody Subclass subclass, @RequestBody String divisionId, @RequestBody String id) {
        subclassService.updateSubclass(id, divisionId, subclass);
    }

}
