package com.example.furreverrfinds_backend1.repository;

import com.example.furreverrfinds_backend1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "select * from users where username=?1", nativeQuery = true)
    Optional<User> getUserByUsername(String username);

    long count();
}
