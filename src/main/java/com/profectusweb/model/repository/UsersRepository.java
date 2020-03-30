package com.profectusweb.model.repository;

import com.profectusweb.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface UsersRepository extends CrudRepository<UserEntity, BigInteger> {
}
