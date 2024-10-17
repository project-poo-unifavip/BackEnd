package com.estoque.estoquejava.service;

import com.estoque.estoquejava.dto.UserDTO;
import com.estoque.estoquejava.entity.User;
import com.estoque.estoquejava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), userDTO.getPassword());
        user = userRepository.save(user);
        return new UserDTO(user.getId(), user.getUsername(), user.getPassword());
    }

    public boolean validateLogin(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
}
