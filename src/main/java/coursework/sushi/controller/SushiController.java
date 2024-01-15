package coursework.sushi.controller;

import coursework.sushi.entity.SushiEntity;
import coursework.sushi.exceptions.SushiAlreadyExistException;
import coursework.sushi.exceptions.SushiNotFoundException;
import coursework.sushi.exceptions.UserAlreadyExistException;
import coursework.sushi.exceptions.UserNotFoundException;
import coursework.sushi.service.SushiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping ("/sushi")
public class SushiController {

    @Autowired
    private SushiService sushiService;

    @PostMapping

    public ResponseEntity addSushi(@RequestBody SushiEntity sushi) {
        try {
            sushiService.addSushi(sushi);
            return ResponseEntity.ok("Sushi saved");
        } catch (SushiAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @GetMapping
    public ResponseEntity search(@RequestParam String name) {
        try {
            return ResponseEntity.ok(sushiService.search(name));
        } catch (SushiNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllSushi() {
        try {
            return ResponseEntity.ok(sushiService.getAllSushi());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity deleteSushi(@PathVariable Long id) {
        try {

            return ResponseEntity.ok(sushiService.delete(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error occurred");
        }
    }

}
