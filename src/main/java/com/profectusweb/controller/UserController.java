package com.profectusweb.controller;

import com.profectusweb.exception.UserNotFoundException;
import com.profectusweb.model.entity.UserEntity;
import com.profectusweb.model.repository.UsersRepository;
import com.profectusweb.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.math.BigInteger;
import java.util.Date;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<UserEntity> all(@RequestParam(value = "name", defaultValue = "World") String name) {
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
        UserEntity userEntity = new UserEntity();
        userEntity.username = incommingUser.username;
        userEntity.password = incommingUser.password;
        userEntity.createdAt = new Date();
        return this.usersRepository.save(userEntity);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserEntity updateAll(
            @PathVariable(name = "id") BigInteger id,
            @Valid @RequestBody UserRequest incommingUser
    ) throws UserNotFoundException {

        UserEntity userEntity = this.usersRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userEntity.username = incommingUser.username;
        userEntity.password = incommingUser.password;
        userEntity.updatedAt = new Date();
        return this.usersRepository.save(userEntity);
    }
}
