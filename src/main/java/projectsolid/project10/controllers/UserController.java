package projectsolid.project10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import projectsolid.project10.Services.UserServices;
import projectsolid.project10.entities.Role;
import projectsolid.project10.entities.UserModel;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserModel> findById(@PathVariable Long id) {
        UserModel usr = userServices.findById(id);
        return ResponseEntity.ok().body(usr);
    }

    @PostMapping
    public ResponseEntity<UserModel> create(@RequestBody UserModel obj) {
        obj = userServices.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
