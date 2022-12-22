package projectsolid.project10.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import projectsolid.project10.ServiceExceptions.UserNotFoundException;
import projectsolid.project10.entities.Barber;
import org.springframework.data.domain.Pageable;
import projectsolid.project10.repositories.BarberRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BarberServices {

    @Autowired
    private BarberRepository barberRepository;

    public Barber addBarber(Barber barber) {
        return barberRepository.save(barber);
    }

    public Barber getById(long id) {
        Optional<Barber> barber = barberRepository.findById(id);
        return barber.orElseThrow(() -> new UserNotFoundException(id));
    }

    public Page<Barber> findAll(Pageable pageable, String flag) {
        if (flag != null && flag.equals("next")) {
            return barberRepository.findAllByCreatedDateIsAfterOrderByCreatedDate(LocalDateTime.now(), pageable);
        } else if (flag != null && flag.equals("previous")) {
            return barberRepository.findAllByCreatedDateIsBeforeOrderByCreatedDate(LocalDateTime.now(), pageable);
        } else {
            return barberRepository.findAll(pageable);
        }
    }
}
