package gb.nabson.taxonomy.api.rest.controller.v1;

import gb.nabson.taxonomy.api.dto.model.v1.model.DivisionDTO;
import gb.nabson.taxonomy.api.dto.model.v1.model.DivisionListDTO;
import gb.nabson.taxonomy.api.service.DivisionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * GET /divisions  = get all divisions GET /divisions/id = get specific division POST /divisions = create a new division PUT /divisions/id =
 * update the division DELETE /divisions/deleteById = deleteById the division
 */
@Api(tags = "Divisions")
@RestController
public class DivisionController {
    private DivisionService divisionService;

    @Autowired
    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @ApiOperation(value = "Get all divisions", notes = "all divisions")
    @GetMapping("/divisions")
    public DivisionListDTO getAllDivisions() {
        return new DivisionListDTO(divisionService.getAllDivisions());
    }

    @GetMapping("/divisions/{id}")
    public DivisionDTO getDivisionById(@PathVariable String id) {
        return divisionService.getDivisionById(id);
    }

    @PostMapping("/divisions")
    public ResponseEntity<Void>  addDivision(@RequestBody DivisionDTO divisionDTO) {
        divisionService.saveDivision(divisionDTO);

        // static method to construct a uri for the the newly created resource
        // .path appends to the current request uri - substituting a template variable for the param supplied in buildAndExpand
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(divisionDTO.getId()).toUri();
        // return a 201 code
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("divisions/{id}")
    public void deleteDivision(@PathVariable String id) {
       divisionService.deleteDivisionById(id);
    }

    @PutMapping("/divisions/{id}")
    public void updateDivision(@RequestBody DivisionDTO divisionDTO, @PathVariable String id) {
        // replace the resource at this specified uri
        // TODO check body to confirm that no (inconsistent) divisionDTO id was supplied

        divisionDTO.setId(id);
        divisionService.saveDivision(divisionDTO);
    }


}

