package com.emerald.api.user;

import java.util.List;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {

        this.repository = repository;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {

        repository.deleteById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {

        return repository.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getSpecificUser(@PathVariable Long id) {

        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        return EntityModel.of(user,
            linkTo(methodOn(UserController.class).getSpecificUser(id)).withSelfRel(),
            linkTo(methodOn(UserController.class).getAllUsers()).withRel("user"));
    }

    @PostMapping("/users")
    public User createNewUser(@RequestBody User newUser) {

        return repository.save(newUser);
    }

    @PutMapping("/users/{id}")
    public User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

        return repository.findById(id).map(user -> {
            user.setEmailAddress(newUser.getEmailAddress());
            user.setName(newUser.getName());
            return repository.save(user);
        }).orElseGet(() -> {
            return repository.save(newUser);
        });
    }
}
