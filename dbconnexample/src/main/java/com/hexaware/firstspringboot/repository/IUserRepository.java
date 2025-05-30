package com.hexaware.firstspringboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.firstspringboot.authentities.UserData;

@Repository
public interface IUserRepository extends JpaRepository<UserData, Long> {
    Optional<UserData> findByUserName(String userName);
    boolean existsByEmail(String email);
    Optional<UserData> findByUserNameOrEmail(String userName, String email);
}
