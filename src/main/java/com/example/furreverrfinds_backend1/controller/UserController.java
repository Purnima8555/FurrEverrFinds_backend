package com.example.furreverrfinds_backend1.controller;

import com.example.furreverrfinds_backend1.dto.UserDto;
import com.example.furreverrfinds_backend1.entity.User;
import com.example.furreverrfinds_backend1.service.AuthenticateService;
import com.example.furreverrfinds_backend1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor

public class UserController {

    private final UserService userService;
    private final AuthenticateService authenticateService;

    @GetMapping("/data")
    public  String getData(){
        return "data retrieved";
    }

    @PostMapping("/save")
    public String createData(@RequestBody UserDto userDto){
        userService.save(userDto);
        return "created data";
    }

    @GetMapping("/getAll")
    public List<User> getAllData() {
        return userService.getAll();
    }

    @CrossOrigin
    @GetMapping("/getById/{id}")
    public Optional<User> getById(@PathVariable("id") Integer id) {
        return userService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public  void deleteById(@PathVariable("id") Integer id) {
        userService.deleteById(id);
    }

    @GetMapping("/count")
    public long getTotalCount() {
        return userService.getTotalCount();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @Valid @RequestBody UserDto userDto) {
        try {
            userService.updateUser(id, userDto);
            return ResponseEntity.ok("User updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update user: " + e.getMessage());
        }
    }
}
