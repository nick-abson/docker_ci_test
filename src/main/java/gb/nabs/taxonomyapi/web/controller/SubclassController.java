package gb.nabs.taxonomyapi.web.controller;


import gb.nabs.taxonomyapi.db.model.Subclass;
import gb.nabs.taxonomyapi.service.SubclassService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * GET /divisions  = get all divisions GET /divisions/id = get specific division POST /divisions = create a new division PUT /divisions/id =
 * update the division DELETE /divisions/delete = delete the division
 */
@Api(tags = "Sub-classes")
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

    @GetMapping("/divisions/{divisionId}/subclasses")
    public List<Subclass> getAllSubclasses(@PathVariable String divisionId) {
        return subclassService.getAllSubclasses(divisionId);
    }

    @GetMapping("/divisions/{divisionId}/subclasses/{id}")
    public Subclass getSubclass(@PathVariable String id) {
        return subclassService.getSubclass(id);

}
    @PostMapping("/divisions/{divisionId}/subclasses/")
    public ResponseEntity addSubclass(@RequestBody Subclass subclass, @PathVariable String divisionId) {
        subclassService.addSubclass(divisionId, subclass);
        // use this static method to construct a uri for the the newly created resource
        // .path appends to the current request uri - substituting a template variable for the param supplied in buildAndExpand
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(subclass.getId()).toUri();
        // return a 201 code
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("divisions/subclasses/{id}")
    public void deleteSubclass(@PathVariable String id) {
       subclassService.deleteSubclass(id);
    }

    @PutMapping("/divisions/{divisionId}/subclasses/{id}")
    public void updateSubclass(@RequestBody Subclass subclass, @PathVariable String divisionId, @PathVariable String id) {
        subclassService.updateSubclass(id, divisionId, subclass);
    }

}

