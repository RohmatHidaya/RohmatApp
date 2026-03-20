package com.shop.rohmat.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.rohmat.dtos.UserDto;
import com.shop.rohmat.mappers.UserMapper;
import com.shop.rohmat.model.User;
import com.shop.rohmat.repository.UserRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public @ResponseBody Iterable<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(user -> userMapper.toDto(user))
                .toList();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email,
            @RequestParam String password) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        n.setPassword(password);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> GetUserById(@PathVariable Integer id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        userRepository.delete(user);
        return ResponseEntity.ok("Deleted");
    }
}
