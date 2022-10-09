package org.akon.userapp.resource;

import org.akon.userapp.domain.dto.UserDTO;
import org.akon.userapp.domain.dto.UserListDTO;
import org.akon.userapp.domain.dto.requests.CreateOrUpdateUserDTO;
import org.akon.userapp.domain.dto.requests.RegisterUserAccountDTO;
import org.akon.userapp.service.UserService;
import org.akon.userapp.service.V2.UserServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user/v2")
public class UserRestController {

    @Autowired
    private UserServiceV2 userService;

    @GetMapping
    public ResponseEntity<UserListDTO> getUserPresentationList() {
        List<UserDTO> list = userService.getUserPresentationList();
        UserListDTO userListDTO = new UserListDTO();
        list.stream().forEach(e -> userListDTO.getUserList().add(e));
        return ResponseEntity.ok(userListDTO);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateOrUpdateUserDTO createOrUpdateUserDTO) {
        return new ResponseEntity(new UserDTO(userService.createUser(createOrUpdateUserDTO)), null, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return new UserDTO(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") Long id, @RequestBody CreateOrUpdateUserDTO updateUserDTO) {
        return new ResponseEntity(new UserDTO(userService.updateUser(id, updateUserDTO)), null, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    // add or remove a Role on a user
    @PostMapping("/{id}/roles/{roleId}")
    public ResponseEntity<UserDTO> addRole(@PathVariable("id") Long id, @PathVariable("roleId") Long roleId) {
        return new ResponseEntity(new UserDTO(userService.addRole(id, roleId)), null, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/roles/{roleId}")
    public ResponseEntity<UserDTO> removeRole(@PathVariable("id") Long id, @PathVariable("roleId") Long roleId) {
        return new ResponseEntity(new UserDTO(userService.removeRole(id, roleId)), null, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerNewUserAccount(@RequestBody RegisterUserAccountDTO registerUserAccountDTO) {
        return new ResponseEntity<>(new UserDTO(userService.registerUserAccount(registerUserAccountDTO)), null, HttpStatus.CREATED);
    }


}
