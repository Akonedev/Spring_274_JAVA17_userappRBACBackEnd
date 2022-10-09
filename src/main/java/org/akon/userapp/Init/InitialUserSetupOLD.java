//package org.akon.userapp.load;
//
//import lombok.AllArgsConstructor;
//import org.akon.userapp.domain.dto.requests.RegisterUserAccountDTO;
//import org.akon.userapp.repository.PermissionRepository;
//import org.akon.userapp.repository.RoleRepository;
//import org.akon.userapp.repository.UserRepository;
//import org.akon.userapp.service.PermissionService;
//import org.akon.userapp.service.RoleService;
//import org.akon.userapp.service.V2.UserServiceV2;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//@AllArgsConstructor
//@Component
//public class InitialUserSetupOLD {
//
//    private PermissionRepository authorityRepository;
//    private PermissionService permissionService;
//    private RoleRepository roleRepository;
//    private RoleService roleService;
//    private UserRepository userRepository;
//    private UserServiceV2 userService;
//
//    @EventListener
//    @Transactional
//    public void onApplicationEvent(ApplicationReadyEvent event) {
//
//        Long readOnlyPermissionId = 0L;
//        Long writePermissionId=0L;
//        Long deletePermissionId=0L;
//
//        String roleUser = "USER";
//        String roleManager = "MANAGER";
//        String roleAdmin = "ADMINISTRATOR";
//
//        String strreadAuthority = "READ_AUTHORITY";
//        String strwriteAuthority = "WRITE_AUTHORITY";
//        String strdeleteAuthority = "DELETE_AUTHORITY";
//
//
////        PermissionDTO readAuthorityDto = new PermissionDTO();
////        Permission readPermission;
////        readPermission = new Permission();
////        readPermission.setPermission(strreadAuthority);
////        authorityRepository.save(readPermission);
////
////        Permission writePermission;
////        writePermission = new Permission();
////        writePermission.setPermission(strwriteAuthority);
////        authorityRepository.save(writePermission);
////
////        Permission deletePermission;
////        deletePermission = new Permission();
////        deletePermission.setPermission(strdeleteAuthority);
////        authorityRepository.save(deletePermission);
////
////       if (roleRepository.findByRole(roleUser).isEmpty()) {
////          Role newUserRole= roleService.createRole(roleUser);
////           newUserRole.getPermissions().add(readPermission);
////           roleRepository.save(newUserRole);
////
////        }
////        if (roleRepository.findByRole(roleManager).isEmpty()) {
////            Role newManagerRole= roleService.createRole(roleManager);
////            newManagerRole.getPermissions().add(readPermission);
////            newManagerRole.getPermissions().add(writePermission);
////            roleRepository.save(newManagerRole);
////        }
////        if (roleRepository.findByRole(roleAdmin).isEmpty()) {
////            Role newAdminRole= roleService.createRole(roleAdmin);
////            newAdminRole.getPermissions().add(readPermission);
////            newAdminRole.getPermissions().add(writePermission);
////            newAdminRole.getPermissions().add(deletePermission);
////            roleRepository.save(newAdminRole);
////        }
//
//        ---------------  AddUSer ------------
//
//        RegisterUserAccountDTO registerUserAccountDTO = new RegisterUserAccountDTO();
//        registerUserAccountDTO.setUsername("akone");
//        registerUserAccountDTO.setPassword("Test!1234");
//        registerUserAccountDTO.setFistname("Abd");
//        registerUserAccountDTO.setLastname("Laye");
//        registerUserAccountDTO.setEmail("admin@gmail.com");
//        registerUserAccountDTO.setGender("MALE");
//        registerUserAccountDTO.setGender("MALE");
//
//        userService.registerUserAccount(registerUserAccountDTO);
//
////
////        CreateOrUpdateUserDTO createOrUpdateUserDTO = new CreateOrUpdateUserDTO();
////        createOrUpdateUserDTO.setUsername("akone");
////        createOrUpdateUserDTO.setPassword("Test!1234");
////        createOrUpdateUserDTO.setFistname("Abd");
////        createOrUpdateUserDTO.setLastname("Laye");
////        createOrUpdateUserDTO.setEmail("admin@gmail.com");
////        createOrUpdateUserDTO.setGender("MALE");
////        createOrUpdateUserDTO.setGender("MALE");
////
////        createOrUpdateUserDTO.setEnabled(true);
////        createOrUpdateUserDTO.setSecured(true);
////
////        createOrUpdateUserDTO.setNote("note test");
////
////        // contact information
////        createOrUpdateUserDTO.setEmail("admin@gmail.com");
////        createOrUpdateUserDTO.setPhone("+34523432356");
////        createOrUpdateUserDTO.setSkype("lonk skype");
////        createOrUpdateUserDTO.setFacebook("link facebook");
////        createOrUpdateUserDTO.setLinkedin("link linkedin");
////        createOrUpdateUserDTO.setWebsite("website test");
////        createOrUpdateUserDTO.setContactNote("test contact note");
////
////
////        // address information
////        createOrUpdateUserDTO.setAddress("rue Riquet");
////        createOrUpdateUserDTO.setAddress2("");
////        createOrUpdateUserDTO.setCity("Paris");
////        createOrUpdateUserDTO.setCountry("France");
////        createOrUpdateUserDTO.setZipCode("75019");
////
////
////        userService.createUser(createOrUpdateUserDTO);
//
//        //---------------  Add Role To User ------------
////
////        User newappUserCreated = userService.getUserByEmail("admin@gmail.com");
////        Optional<Role> roleOpt = roleRepository.findByRole(roleAdmin);
////        if (!roleOpt.isPresent()) {
////            throw new RoleNotFoundException("Role cannot be null");
////        }
//////
////        userService.addUserRole(newappUserCreated, roleOpt.get().getId());
////        newappUserCreated.setCreationDt(LocalDateTime.now());
////        User savednewappUserCreated = userRepository.save(newappUserCreated);
//
//    }
//
//
//}
