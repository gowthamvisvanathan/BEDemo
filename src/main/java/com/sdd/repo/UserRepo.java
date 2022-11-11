package com.sdd.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdd.model.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

}
