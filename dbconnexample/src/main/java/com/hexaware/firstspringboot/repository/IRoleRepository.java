package com.hexaware.firstspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.firstspringboot.authentities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role , Long>{

}
