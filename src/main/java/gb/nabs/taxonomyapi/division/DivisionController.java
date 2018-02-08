package gb.nabs.taxonomyapi.division;


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
@RestController
public class DivisionController {

    // all controllers map a url(html/method) request to a controller object method
    // Spring can inspect incoming requests and if it find a controller in the class path that has a method mapped to it
    // Spring converts the response according to various sensible defaults (e.g because this is a Restfull service, it assumes
    // you want to send json).
    // the json key names are the object property names.

    //inject the divisionService
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

    // map a method to any request that is a POST on /divisions
    // the RequestBody annotation tells spring mvc that the body contains a json  represenation of a division instance and that it should
    // convert it to an instance of Subclass
    @PostMapping("/divisions")
    public ResponseEntity<Void>  addDivision(@RequestBody Division division) {
        divisionService.addDivision(division);

        // static method to construct a uri for the the newly created resource
        // .path appends to the current request uri - substituting a template variable for the param supplied in buildAndExpand
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(division.getId()).toUri();
        // return a 201 code
        return ResponseEntity.created(location).build();
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

