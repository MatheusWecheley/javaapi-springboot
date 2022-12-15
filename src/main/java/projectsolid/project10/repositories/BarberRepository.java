package projectsolid.project10.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import projectsolid.project10.entities.Barber;
import projectsolid.project10.entities.UserModel;

import java.time.LocalDateTime;

public interface BarberRepository extends PagingAndSortingRepository<Barber, Long> {
    Page<Barber> findAllByCreatedDateIsAfterOrderByCreatedDate(LocalDateTime date, Pageable pageable);
    Page<Barber> findAllByCreatedDateIsBeforeOrderByCreatedDate(LocalDateTime date, Pageable pageable);
}
