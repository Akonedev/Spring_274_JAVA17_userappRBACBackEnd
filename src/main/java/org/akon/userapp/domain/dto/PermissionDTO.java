package org.akon.userapp.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.akon.userapp.domain.Permission;

@NoArgsConstructor
@Data
public class PermissionDTO implements java.io.Serializable {

    private Long id;
    private String permission;
    private boolean enabled;
    private String note;

    public PermissionDTO(Permission permission) {
        this.id = permission.getId();
        this.permission = permission.getPermission();
        this.enabled = permission.isEnabled();
        this.note = permission.getNote();
    }

}
