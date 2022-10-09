package org.akon.userapp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.akon.userapp.enumeration.EGender;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String userId;

    @Enumerated
    @Column(columnDefinition = "tinyint")
    private EGender gender;
    private String firstName;
    private String lastName;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;
    @Column(name = "birth_date")
    private java.time.LocalDate birthDate;
    private String profileImageUrl;
    @Column(name="note")
    private String note;

    private java.time.LocalDateTime creationDt;

    private java.time.LocalDateTime updatedDt;

    private java.time.LocalDateTime fristloginDt;

    @Basic
    private java.time.LocalDateTime loginDt;

    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
//    private String role;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private final Set<Role> roles = new HashSet<>();

    private String[] authorities;
    private boolean isActive;
    private boolean isNotLocked;

    @Column(name="enabled")
    private boolean enabled;

    @Column(name="secured")
    private boolean secured;


    @OneToOne(mappedBy = "User", cascade = CascadeType.ALL)
    private Contact contact;

    @OneToOne(mappedBy = "User", cascade = CascadeType.ALL)
    private Address address;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }


//    public User(Long id,
//                String userId,
//                String firstName,
//                String lastName,
//                String username,
//                String password,
//                String email,
//                String profileImageUrl,
//                Date lastLoginDate,
//                Date lastLoginDateDisplay,
//                Date joinDate,
////                String role,
//                String[] authorities,
//                boolean isActive,
//                boolean isNotLocked) {
//        this.id = id;
//        this.userId = userId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.profileImageUrl = profileImageUrl;
//        this.lastLoginDate = lastLoginDate;
//        this.lastLoginDateDisplay = lastLoginDateDisplay;
//        this.joinDate = joinDate;
////        this.role = role;
//        this.authorities = authorities;
//        this.isActive = isActive;
//        this.isNotLocked = isNotLocked;
//    }

//    public User(String email) {
//        this.email = email;
//    }
//
//    public User() {
//    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getProfileImageUrl() {
//        return profileImageUrl;
//    }
//
//    public void setProfileImageUrl(String profileImageUrl) {
//        this.profileImageUrl = profileImageUrl;
//    }
//
//    public Date getLastLoginDate() {
//        return lastLoginDate;
//    }
//
//    public void setLastLoginDate(Date lastLoginDate) {
//        this.lastLoginDate = lastLoginDate;
//    }
//
//    public Date getLastLoginDateDisplay() {
//        return lastLoginDateDisplay;
//    }
//
//    public void setLastLoginDateDisplay(Date lastLoginDateDisplay) {
//        this.lastLoginDateDisplay = lastLoginDateDisplay;
//    }
//
//    public Date getJoinDate() {
//        return joinDate;
//    }
//
//    public void setJoinDate(Date joinDate) {
//        this.joinDate = joinDate;
//    }
//
//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }
//
//    public String[] getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(String[] authorities) {
//        this.authorities = authorities;
//    }
}
