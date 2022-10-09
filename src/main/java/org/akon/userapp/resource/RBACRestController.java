package org.akon.userapp.resource;


import org.akon.userapp.domain.dto.PermissionDTO;
import org.akon.userapp.domain.dto.RoleDTO;
import org.akon.userapp.domain.Permission;
import org.akon.userapp.domain.Role;
import org.akon.userapp.service.EncryptionService;
import org.akon.userapp.service.PermissionService;
import org.akon.userapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/users/rbac")
public class RBACRestController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    // roles
    @GetMapping("/roles")
    public ResponseEntity<List<RoleDTO>> getRolePresentationList() {
        Iterable<Role> roleList = roleService.getRoleList();
        ArrayList<RoleDTO> list = new ArrayList<>();
        roleList.forEach(e -> list.add(new RoleDTO(e)));
        return ResponseEntity.ok(list);
    }

    @PostMapping("/roles")
    public ResponseEntity<RoleDTO> createRole(@RequestBody String role) {
        return new ResponseEntity<>(new RoleDTO(roleService.createRole(role)), null, HttpStatus.CREATED);
    }

    @GetMapping("/roles/{roleId}")
    public RoleDTO getRoleById(@PathVariable("roleId") Long roleId) {
        return new RoleDTO(roleService.getRoleById(roleId));
    }

    @DeleteMapping("/roles/{roleId}")
    public ResponseEntity<?> deleteRoleById(@PathVariable("roleId") Long roleId) {
        roleService.deleteRole(roleId);
        return ResponseEntity.noContent().build();
    }

    // retrieve the permission's list
    @GetMapping("/permissions")
    public ResponseEntity<List<PermissionDTO>> getPermissionPresentationList() {
        Iterable<Permission> permissionList = permissionService.getPermissionList();
        ArrayList<PermissionDTO> list = new ArrayList<>();
        permissionList.forEach(e -> list.add(new PermissionDTO(e)));
        return ResponseEntity.ok(list);
    }

    // permissions

    @GetMapping("/permissions/{permissionKey}")
    public ResponseEntity<PermissionDTO> getPermissionByKey(@PathVariable("permissionKey") String permissionKey) {
        PermissionDTO permissionDTO = new PermissionDTO(permissionService.getPermissionByKey(permissionKey));
        return ResponseEntity.ok(permissionDTO);
    }

    @PostMapping("/permissions")
    public ResponseEntity<PermissionDTO> createPermission(@RequestBody PermissionDTO permissionDTO) {
        return new ResponseEntity(new PermissionDTO(permissionService.createPermission(permissionDTO)), HttpStatus.CREATED);
    }

    @PutMapping("/permissions")
    public ResponseEntity<PermissionDTO> updatePermission(@RequestBody PermissionDTO permissionDTO) {
        return new ResponseEntity(new PermissionDTO(permissionService.updatePermission(permissionDTO)), HttpStatus.CREATED);
    }

    @DeleteMapping("/permissions/{permissionKey}")
    public ResponseEntity<?> deletePermissionByKey(@PathVariable("permissionKey") String permissionKey) {
        permissionService.deletePermissionByKey(permissionKey);
        return ResponseEntity.noContent().build();
    }

    // add or remove a Permission on a Role

    @PostMapping("/roles/{roleId}/permissions/{permissionKey}")
    public ResponseEntity<RoleDTO> addPermissionOnRole(@PathVariable("roleId") Long roleId, @PathVariable("permissionKey") String permissionKey) {
        return new ResponseEntity(new RoleDTO(roleService.addPermissionOnRole(roleId, permissionKey)), null, HttpStatus.CREATED);
    }

    @DeleteMapping("/roles/{roleId}/permissions/{permissionKey}")
    public ResponseEntity<RoleDTO> removePermissionOnRole(@PathVariable("roleId") Long roleId, @PathVariable("permissionKey") String permissionKey) {
        return new ResponseEntity(new RoleDTO(roleService.removePermissionOnRole(roleId, permissionKey)), null, HttpStatus.OK);
    }

    // salt generation
    @GetMapping("/salt")
    public ResponseEntity<String> generateSalt() {
        return new ResponseEntity<String>(EncryptionService.generateSalt(32), HttpStatus.CREATED);
    }

}
