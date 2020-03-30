package com.profectusweb.service;

import com.profectusweb.exception.UserNotFoundException;
import com.profectusweb.model.entity.UserEntity;
import com.profectusweb.model.repository.UsersRepository;
import com.profectusweb.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;

@Service("UsersService")
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UserEntity create(UserRequest incommingUser) {
        UserEntity userEntity = new UserEntity();
        userEntity.username = incommingUser.username;
        userEntity.password = incommingUser.password;
        userEntity.createdAt = new Date();
        return this.usersRepository
                .save(userEntity);
    }

    public UserEntity update(BigInteger id, UserRequest incommingUser) throws UserNotFoundException {

        UserEntity userEntity = this.usersRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userEntity.username = incommingUser.username;
        userEntity.password = incommingUser.password;
        userEntity.updatedAt = new Date();
        return this.usersRepository
                .save(userEntity);
    }

}
