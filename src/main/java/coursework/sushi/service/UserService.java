package coursework.sushi.service;

import coursework.sushi.entity.UserEntity;
import coursework.sushi.exceptions.UserAlreadyExistException;
import coursework.sushi.exceptions.UserNotFoundException;
import coursework.sushi.model.User;
import coursework.sushi.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("User with this name already exists");
        }
        return userRepo.save(user);
    }

    public User login(String username, String password) throws UserNotFoundException {
        UserEntity user;
        if(userRepo.findByUsername(username) != null) {
            user = userRepo.findByUsername(username);
            if(user.getPassword().equals(password)) {
                return User.toModel(user);
            } else {
                throw new UserNotFoundException("Incorrect password");
            }
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
