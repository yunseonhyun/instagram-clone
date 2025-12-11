package com.instagram.user.model.service;

import com.instagram.user.model.dto.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {

    void signUp(User user);
    User login(String userEmail, String userPassword);
    User getUserByEmail(String userEmail);
    User getUserByUsername(String userName);
    User getUserById(int userId);

    User updateUser(User user, MultipartFile file) throws IOException;
}
