package coursework.sushi.controller;

import coursework.sushi.entity.UserEntity;
import coursework.sushi.exceptions.UserAlreadyExistException;
import coursework.sushi.exceptions.UserNotFoundException;
import coursework.sushi.repository.UserRepo;
import coursework.sushi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @CrossOrigin
    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("User saved");
        } catch (UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam String username, String password) {
        try {
            return ResponseEntity.ok(userService.login(username, password));
        } catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }
}
