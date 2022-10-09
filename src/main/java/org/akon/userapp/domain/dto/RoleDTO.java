package org.akon.userapp.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.akon.userapp.domain.Role;
//import org.akon.userapp.security.user.Role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class RoleDTO implements Serializable {

    private Long id;
    private String role;

    private List<PermissionDTO> permissions = new ArrayList<>();

    public RoleDTO(Role role) {
        this.id = role.getId();
        this.role = role.getRole();

        // permissions
        role.getPermissions().stream().forEach(e -> permissions.add(new PermissionDTO()));
    }

    public RoleDTO(Long id, String role) {
        this.id = id;
        this.role = role;
    }

//    public RoleDTO(Role e) {
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleDTO)) return false;
        return id != null && id.equals(((RoleDTO) o).getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

}
