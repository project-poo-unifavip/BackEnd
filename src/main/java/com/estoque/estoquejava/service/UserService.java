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

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(userDTO.getUsername());
            user.setPassword(userDTO.getPassword());
            user = userRepository.save(user);
            return new UserDTO(user.getId(), user.getUsername(), user.getPassword());
        }
        return null;
    }

    public boolean deleteUser(Long id) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User foundUser = user.get();
            return new UserDTO(foundUser.getId(), foundUser.getUsername(), foundUser.getPassword());
        }
        return null;
    }
}
