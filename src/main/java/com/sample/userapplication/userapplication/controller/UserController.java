package com.sample.userapplication.userapplication.controller;

import com.sample.userapplication.userapplication.model.User;
import com.sample.userapplication.userapplication.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public final class UserController {

    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userRepository.findAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable final Long id) {
        return userRepository.findById(id).map(user -> new ResponseEntity<>(user, OK)).orElse(new ResponseEntity<>(NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody final User user) {
        return new ResponseEntity<>(userRepository.save(user), OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable final Long id, @RequestBody final User user) {
        final User existingUser = userRepository.findById(id).get();
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        return new ResponseEntity<>(userRepository.save(user), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            userRepository.findById(id).get();
            userRepository.deleteById(id);
            return new ResponseEntity<>("User deleted successfully", OK);
        } catch (Exception ex) {
            return new ResponseEntity<>("User Not found", NOT_FOUND);
        }
    }
}
