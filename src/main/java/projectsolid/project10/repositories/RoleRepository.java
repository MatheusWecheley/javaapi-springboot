package projectsolid.project10.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projectsolid.project10.entities.Role;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
