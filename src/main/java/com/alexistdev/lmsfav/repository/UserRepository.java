package com.alexistdev.lmsfav.repository;

import com.alexistdev.lmsfav.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {

}
