package projectsolid.project10.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import projectsolid.project10.ServiceExceptions.UserNotFoundException;
import projectsolid.project10.entities.UserModel;
import projectsolid.project10.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder securityConfig;

    public UserModel findById(Long id) {
        Optional<UserModel> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel create(UserModel obj) {
        return userRepository.save(obj);
    }
}
