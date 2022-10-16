package projectsolid.project10.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectsolid.project10.entities.Role;
import projectsolid.project10.repositories.RoleRepository;

@Service
public class RoleServices {

    @Autowired
    RoleRepository roleRepository;

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
}
