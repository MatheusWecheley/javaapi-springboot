package projectsolid.project10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projectsolid.project10.Services.RoleServices;
import projectsolid.project10.entities.Role;

import java.net.URI;

@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    @Autowired
    RoleServices roleServices;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        role = roleServices.createRole(role);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(role.getId()).toUri();
        return ResponseEntity.created(uri).body(role);
    }
}
