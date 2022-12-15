package projectsolid.project10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projectsolid.project10.Services.BarberServices;
import projectsolid.project10.entities.Barber;

import java.net.URI;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/barbers")
public class BarberController {

    @Autowired
    private BarberServices barberServices;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Barber> getById(@PathVariable long id) {
        Barber barber = barberServices.getById(id);
        return ResponseEntity.ok().body(barber);
    }

    @PostMapping
    public ResponseEntity<Barber> addBarber(@RequestBody Barber barber) {
        barber = barberServices.addBarber(barber);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(barber.getId()).toUri();
        return ResponseEntity.created(uri).body(barber);
    }

    @GetMapping
    public ResponseEntity<Page<Barber>> getAllBarbers(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
                                                          @RequestParam(required = false) String flag){
        Page<Barber> livePage = barberServices.findAll(pageable, flag);
        if(livePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Page<Barber>>(livePage, HttpStatus.OK);
        }
    }
}
