package com.cheise_proj.authservice.domain.service;

import com.cheise_proj.authservice.domain.model.Role;
import com.cheise_proj.authservice.domain.model.User;
import com.cheise_proj.authservice.domain.repository.RoleRepository;
import com.cheise_proj.authservice.domain.repository.UserRepository;
import com.cheise_proj.authservice.dto.CreateUserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void createUser(CreateUserDto input) {
        Role role = roleRepository.findByName(input.getRole())
                .orElseThrow(() -> new IllegalArgumentException("role not found"));
        User user = User.builder().build();
        BeanUtils.copyProperties(input, user);
        user.setRole(role);
        userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("user not found"));
    }
}
