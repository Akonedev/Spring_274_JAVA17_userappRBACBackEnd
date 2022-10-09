package org.akon.userapp.service;

import org.akon.userapp.domain.User;
import org.akon.userapp.domain.dto.requests.RegisterUserAccountDTO;
import org.akon.userapp.exception.domain.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService {

    User register(String firstName, String lastName, String username, String email, String password)
            throws UserNotFoundException, EmailExistException, UsernameExistException, MessagingException;
//
//    User registerUserAccount(RegisterUserAccountDTO registerUserAccountDTO);
//
//        List<User> getUsers();
//
//    User findUserByUsername(String username);
//
//    User findUserByEmail(String email);

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User addNewUser(String firstName, String lastName, String username, String email, String role,
                    boolean isNonLocked, boolean isActive, MultipartFile profileImage)
            throws UserNotFoundException, EmailExistException, UsernameExistException, MessagingException, IOException, NotAnImageFileException;

    User updateUser(String currentUsername, String newFirstName, String newLastName, String newUsername,
                    String newEmail, String role, boolean isNonLocked, boolean isActive, MultipartFile profileImage)
            throws UserNotFoundException, EmailExistException, UsernameExistException, IOException, NotAnImageFileException;

    void deleteUser(String username) throws IOException;

    void resetPassword(String email) throws MessagingException, EmailNotFoundException;

    User updateProfileImage(String username, MultipartFile profileImage)
            throws UserNotFoundException, EmailExistException, UsernameExistException, IOException, NotAnImageFileException;

    User resetProfileImage(String username) throws UserNotFoundException, EmailExistException, UsernameExistException;

     void addUserRole(User user, long roleId);

}
