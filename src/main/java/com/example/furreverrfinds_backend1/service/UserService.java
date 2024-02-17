package com.example.furreverrfinds_backend1.service;

import com.example.furreverrfinds_backend1.dto.UserDto;
import com.example.furreverrfinds_backend1.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String save(UserDto userDto);

    List<User> getAll();

    Optional<User> getById(Integer id);

    void deleteById(Integer id);

    long getTotalCount();

    void updateUser(Integer id, UserDto userDto);
}
