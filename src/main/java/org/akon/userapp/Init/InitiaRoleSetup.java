package org.akon.userapp.Init;

import lombok.AllArgsConstructor;
import org.akon.userapp.domain.Permission;
import org.akon.userapp.domain.Role;
import org.akon.userapp.repository.PermissionRepository;
import org.akon.userapp.repository.RoleRepository;
import org.akon.userapp.service.RoleService;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Component
public class InitiaRoleSetup {

    private PermissionRepository authorityRepository;
    private RoleRepository roleRepository;
    private RoleService roleService;

    @EventListener
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent event) {

        String roleUser = "USER";
        String roleManager = "MANAGER";
        String roleAdmin = "ADMINISTRATOR";

        String strreadAuthority = "READ_AUTHORITY";
        String strwriteAuthority = "WRITE_AUTHORITY";
        String strdeleteAuthority = "DELETE_AUTHORITY";

        Permission readPermission;
        readPermission = new Permission();
        readPermission.setPermission(strreadAuthority);
        authorityRepository.save(readPermission);

        Permission writePermission;
        writePermission = new Permission();
        writePermission.setPermission(strwriteAuthority);
        authorityRepository.save(writePermission);

        Permission deletePermission;
        deletePermission = new Permission();
        deletePermission.setPermission(strdeleteAuthority);
        authorityRepository.save(deletePermission);

       if (roleRepository.findByRole(roleUser).isEmpty()) {
          Role newUserRole= roleService.createRole(roleUser);
           newUserRole.getPermissions().add(readPermission);
           roleRepository.save(newUserRole);

        }
        if (roleRepository.findByRole(roleManager).isEmpty()) {
            Role newManagerRole= roleService.createRole(roleManager);
            newManagerRole.getPermissions().add(readPermission);
            newManagerRole.getPermissions().add(writePermission);
            roleRepository.save(newManagerRole);
        }
        if (roleRepository.findByRole(roleAdmin).isEmpty()) {
            Role newAdminRole= roleService.createRole(roleAdmin);
            newAdminRole.getPermissions().add(readPermission);
            newAdminRole.getPermissions().add(writePermission);
            newAdminRole.getPermissions().add(deletePermission);
            roleRepository.save(newAdminRole);
        }

    }


}
