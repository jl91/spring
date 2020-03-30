package com.profectusweb.controller;

import com.profectusweb.exception.UserNotFoundException;
import com.profectusweb.model.entity.UserEntity;
import com.profectusweb.model.repository.UsersRepository;
import com.profectusweb.request.UserRequest;
import com.profectusweb.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<UserEntity> all() {
        return usersRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserEntity byId(@PathVariable(name = "id") BigInteger id) throws UserNotFoundException {
        return this.usersRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity create(@Valid @RequestBody UserRequest incommingUser) {
        return this.usersService
                .create(incommingUser);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserEntity updateAll(
            @PathVariable(name = "id") BigInteger id,
            @Valid @RequestBody UserRequest incommingUser
    ) throws UserNotFoundException {
        return this.usersService
                .update(id, incommingUser);
    }
}
