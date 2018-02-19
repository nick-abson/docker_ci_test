package gb.nabs.taxonomyapi.web.controller;


import gb.nabs.taxonomyapi.db.model.Subclass;
import gb.nabs.taxonomyapi.service.DivisionService;
import gb.nabs.taxonomyapi.service.SubclassService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * GET /divisions  = get all divisions GET /divisions/id = get specific division POST /divisions = create a new division
 * PUT /divisions/id = update the division DELETE /divisions/deleteById = deleteById the division
 */
@Api(tags = "Sub-classes")
@RestController
public class SubclassController {

    // all controllers map a url(html/method) request to a controller object method
    // we map the two together with annotation, as per the below.
    // map method to url (by default all HTTP methods are mapped).
    // Spring can inspect incoming requests and if it find a controller in the class path that has a method mapped to it
    // Spring converts the response according to various sensible defaults (e.g because this is a Restfull service, it assumes
    // you want to send json).
    // the json key names are the object property names.


    private final SubclassService subclassService;
    private final DivisionService divisionService;

    @Autowired
    public SubclassController(SubclassService subclassService, DivisionService divisionService) {
        this.subclassService = subclassService;
        this.divisionService = divisionService;
    }

    @GetMapping("/divisions/{divisionId}/subclasses")
    public List<Subclass> getAllSubclasses(@PathVariable String divisionId) {
        return subclassService.findAll(divisionId);
    }

    @GetMapping("/divisions/{divisionId}/subclasses/{id}")
    public Subclass getSubclass(@PathVariable String id) {
        return subclassService.findById(id);

    }

    @PostMapping("/divisions/{divisionId}/subclasses/")
    public ResponseEntity addSubclass(@RequestBody Subclass subclass, @PathVariable String divisionId) {

        // TODO check division id is valid and not contradicted by body
        subclass.setDivision(divisionService.findById(divisionId));

        subclassService.save(subclass);

        // return a 201 code
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(subclass.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("divisions/subclasses/{id}")
    public void deleteSubclass(@PathVariable String id) {
        subclassService.deleteById(id);
    }

    @PutMapping("/divisions/{divisionId}/subclasses/{id}")
    public void updateSubclass(@RequestBody Subclass subclass, @PathVariable String divisionId, @PathVariable String id) {
        // TODO check division id/subclass id is valid and not contradicted by body
        subclass.setId(id);

        subclass.setDivision(divisionService.findById(divisionId));

        subclassService.save(subclass);
    }

}

