package gb.nabson.taxonomy.api.rest.controller.v1;


import gb.nabson.taxonomy.api.dto.model.v1.mapper.DivisionMapper;
import gb.nabson.taxonomy.api.dto.model.v1.model.DivisionDTO;
import gb.nabson.taxonomy.api.dto.model.v1.model.SubclassDTO;
import gb.nabson.taxonomy.api.dto.model.v1.model.SubclassListDTO;
import gb.nabson.taxonomy.api.model.Division;
import gb.nabson.taxonomy.api.service.DivisionService;
import gb.nabson.taxonomy.api.service.SubclassService;
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

    private final SubclassService subclassService;
    private final DivisionService divisionService;


    @Autowired
    public SubclassController(SubclassService subclassService,  DivisionService divisionService) {
        this.subclassService = subclassService;
        this.divisionService = divisionService;
    }

    @GetMapping("/divisions/{divisionId}/subclasses")
    public SubclassListDTO getAllSubclasses(@PathVariable String divisionId) {
        return new  SubclassListDTO(subclassService.getAllSubclasses(divisionId));
    }

    @GetMapping("/divisions/{divisionId}/subclasses/{id}")
    public SubclassDTO getSubclass(@PathVariable String id) {
        return subclassService.getSubclassById(id);

    }

    @PostMapping("/divisions/{divisionId}/subclasses/")
    public ResponseEntity addSubclass(@RequestBody SubclassDTO subclassDTO, @PathVariable String divisionId) {

        // TODO check division id is valid and not contradicted by body
        subclassDTO.setDivision(divisionService.getDivisionById(divisionId));

        subclassService.saveSubclass(subclassDTO);

        // return a 201 code
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(subclassDTO.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("divisions/subclasses/{id}")
    public void deleteSubclass(@PathVariable String id) {
        subclassService.deleteSubclassById(id);
    }

    @PutMapping("/divisions/{divisionId}/subclasses/{id}")
    public void updateSubclass(@RequestBody SubclassDTO subclassDTO, @PathVariable String divisionId, @PathVariable String id) {
        // TODO check division id/subclassDTO id is valid and not contradicted by body
        subclassDTO.setId(id);

        subclassDTO.setDivision(divisionService.getDivisionById(divisionId));

        subclassService.saveSubclass(subclassDTO);
    }

}

