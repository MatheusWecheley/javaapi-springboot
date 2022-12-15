package projectsolid.project10.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import projectsolid.project10.entities.Barber;
import org.springframework.data.domain.Pageable;
import projectsolid.project10.repositories.BarberRepository;

import java.time.LocalDateTime;
import java.util.List;
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
        return barber.orElseThrow();
    }

    public Page<Barber> findAll(Pageable pageable, String flag) {
        if (flag != null && flag.equals("next")) {
            return barberRepository.findAllByRegistrationDateIsAfterOrderByRegistrationDate(LocalDateTime.now(), pageable);
        } else if (flag != null && flag.equals("previous")) {
            return barberRepository.findAllByRegistrationDateIsBeforeOrderByRegistrationDate(LocalDateTime.now(), pageable);
        } else {
            return barberRepository.findAll(pageable);
        }
    }
}