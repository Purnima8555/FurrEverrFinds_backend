package com.example.furreverrfinds_backend1.service.impl;

import com.example.furreverrfinds_backend1.config.PasswordEncoderUtil;
import com.example.furreverrfinds_backend1.dto.UserDto;
import com.example.furreverrfinds_backend1.entity.User;
import com.example.furreverrfinds_backend1.repository.UserRepo;
import com.example.furreverrfinds_backend1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public String save(UserDto userDto) {

        User user = new User();

        if(userDto.getId()!=null) {
            user= userRepo.findById((userDto.getId())).orElseThrow(() ->new NullPointerException("data not found"));
        }

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setMobileNo(userDto.getMobileNo());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userDto.getPassword()));
        user.setCpassword(userDto.getCpassword());

        userRepo.save(user);


        return "created";
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepo.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

    @Override
    public long getTotalCount() {
        return userRepo.count();
    }

    @Override
    public void updateUser(Integer id, UserDto userDto) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Update userEntity fields
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setMobileNo(userDto.getMobileNo());

        // Save the updated userEntity
        userRepo.save(user);
    }
}
