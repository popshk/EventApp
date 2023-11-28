package com.event.app.service;

import com.event.app.model.User;
import com.event.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo repository, PasswordEncoder passwordEncoder) {
        this.userRepo = repository;
        this.passwordEncoder = passwordEncoder;
    }

    private Supplier<UsernameNotFoundException> usernameNotFoundExceptionSupplier(String id) {
        return () -> new UsernameNotFoundException("User: " + id + " not found");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username).orElseThrow(usernameNotFoundExceptionSupplier(username));
    }

    public void createUser(final User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
    }

    public User getUserById(String userId) {
        return userRepo.findById(userId).orElseThrow(usernameNotFoundExceptionSupplier(userId));
    }

    public void deleteUserById(String userId) {
        userRepo.deleteById(userId);
    }

    public void updateUserProfile(User user, String username, String email, String firstName, String lastName) {
        user.setUsername(username);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public List<User> getUserFriends(String userId) {
        return userRepo.findById(userId).orElseThrow(usernameNotFoundExceptionSupplier(userId)).getFriendList();
    }

    public void addFriendToUser(String userId, String friendId) {
        User user = userRepo.findById(userId).orElseThrow(usernameNotFoundExceptionSupplier(userId));
        User friend = userRepo.findById(friendId).orElseThrow(usernameNotFoundExceptionSupplier(friendId));
        user.getFriendList().add(friend);
        userRepo.save(user);
    }

    public void removeFriendFromUser(String userId, String friendId) {
        User user = userRepo.findById(userId).orElseThrow(usernameNotFoundExceptionSupplier(userId));
        user.getFriendList().removeIf(friend -> friend.getId().equals(friendId));
        userRepo.save(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepo.findUserByEmail(email);
    }

    public void changePassword(String oldPassword, String newPassword, String confirmPassword, User user) {
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        if (!newPassword.equals(confirmPassword)) {
            throw new IllegalStateException("Password are not the same");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepo.save(user);
    }
}