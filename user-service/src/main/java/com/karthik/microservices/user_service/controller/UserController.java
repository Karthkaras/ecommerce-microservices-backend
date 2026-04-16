package com.karthik.microservices.user_service.controller;


import com.karthik.microservices.user_service.service.UserService;
import com.karthik.microservices.user_service.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(
                userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                userService.getUserById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getByEmail(
            @PathVariable String email) {
        return ResponseEntity.ok(
                userService.getUserByEmail(email));
    }

    @PostMapping
    public ResponseEntity<User> create(
            @RequestBody @Valid User user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(
            @PathVariable Long id,
            @RequestBody User user) {
        return ResponseEntity.ok(
                userService.updateUser(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(
                "User deleted successfully!");
    }
}