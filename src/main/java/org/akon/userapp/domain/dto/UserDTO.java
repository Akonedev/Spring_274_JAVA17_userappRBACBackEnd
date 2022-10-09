package org.akon.userapp.domain.dto;

import lombok.Data;
import org.akon.userapp.domain.User;
import org.akon.userapp.domain.Permission;
import org.akon.userapp.domain.Role;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO implements Serializable {
    private Long id;
    private String username;
    private String fistname;
    private String lastname;
    private String gender;
    private java.time.LocalDate birthDate;

    private boolean enabled;

    private String note;

    private LocalDateTime creationDt;
    private LocalDateTime updatedDt;
    private LocalDateTime loginDt;

    private boolean secured;

    private ContactDTO contactDTO;
    private AddressDTO addressDTO;

    // permissions and roles list
    private List<String> roles;
    private List<String> permissions;

    public UserDTO() {
        // empty constructor
        roles = new ArrayList<>();
        permissions = new ArrayList<>();
    }

    public UserDTO(User appUser) {
        if (appUser != null) {
            this.id = appUser.getId();
            this.username = appUser.getUsername();
            this.fistname = appUser.getFirstName();
            this.lastname = appUser.getLastName();
            this.gender = appUser.getGender().name();
            this.birthDate = appUser.getBirthDate();
            this.enabled = appUser.isEnabled();
            this.note = appUser.getNote();
            this.creationDt = appUser.getCreationDt();
            this.updatedDt = appUser.getUpdatedDt();
            this.loginDt = appUser.getLoginDt();
            this.secured = appUser.isSecured();

            // contact, if set
            if (appUser.getContact() != null) {
                this.contactDTO = new ContactDTO(appUser.getContact());
            }

            // address, if set
            if (appUser.getAddress() != null) {
                this.addressDTO = new AddressDTO(appUser.getAddress());
            }

            // Because the permissions can be associated to more than one roles i'm creating two String arrays
            // with the distinct keys of roles and permissions.
            roles = new ArrayList<>();
            permissions = new ArrayList<>();

            for (Role role : appUser.getRoles()) {
                roles.add(role.getRole());
                for (Permission p : role.getPermissions()) {
                    String key = p.getPermission();
                    if ((!permissions.contains(key)) && (p.isEnabled())) {
                        // add the permission only if enabled
                        permissions.add(key);
                    }
                }
            }

        }
    }



}
