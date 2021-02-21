package com.spring.rediscache.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.rediscache.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
