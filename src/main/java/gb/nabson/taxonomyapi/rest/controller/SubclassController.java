package gb.nabson.taxonomyapi.rest.controller;


import gb.nabson.taxonomyapi.model.Subclass;
import gb.nabson.taxonomyapi.service.DivisionService;
import gb.nabson.taxonomyapi.service.SubclassService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * GET /divisions  = get all divisions GET /divisions/id = get specific division POST /divisions = create a new division
 * PUT /divisions/id = update the division DELETE /divisions/deleteById = deleteById the division
 */
@Api(tags = "Sub-classes")
@RestController
public class SubclassController {
    private final SubclassService subclassService;
    private final DivisionService divisionService;

    @Autowired
    public SubclassController(SubclassService subclassService,  DivisionService divisionService) {
        this.subclassService = subclassService;
        this.divisionService = divisionService;
    }

    @GetMapping("/divisions/{divisionId}/subclasses")
    public Iterable<Subclass> getAllSubclasses(@PathVariable String divisionId) {
        return subclassService.getAllSubclasses(divisionId);
    }

    @GetMapping("/divisions/{divisionId}/subclasses/{id}")
    public Subclass getSubclass(@PathVariable String id) {
        return subclassService.getSubclassById(id);

    }

    @PostMapping("/divisions/{divisionId}/subclasses/")
    public ResponseEntity addSubclass(@RequestBody Subclass subclass, @PathVariable String divisionId) {

        // TODO check division id is valid and not contradicted by body
        subclass.setDivision(divisionService.getDivisionById(divisionId));

        subclassService.saveSubclass(subclass);

        // return a 201 code
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(subclass.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("divisions/subclasses/{id}")
    public void deleteSubclass(@PathVariable String id) {
        subclassService.deleteSubclassById(id);
    }

    @PutMapping("/divisions/{divisionId}/subclasses/{id}")
    public void updateSubclass(@RequestBody Subclass subclass, @PathVariable String divisionId, @PathVariable String id) {
        // TODO check division id/subclass id is valid and not contradicted by body
        subclass.setId(id);

        subclass.setDivision(divisionService.getDivisionById(divisionId));

        subclassService.saveSubclass(subclass);
    }

}

