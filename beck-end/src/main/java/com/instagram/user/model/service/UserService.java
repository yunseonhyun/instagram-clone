package com.instagram.user.model.service;

import com.instagram.user.model.dto.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    void signUp(User user);
    User login(String userEmail, String userPassword);
    User getUserByEmail(String userEmail);
    User getUserById(int userId);

    User updateUser(User user, MultipartFile file) throws IOException;


    List<User> searchUsers(String query);


    User getUserByUsername(String userName);


}
