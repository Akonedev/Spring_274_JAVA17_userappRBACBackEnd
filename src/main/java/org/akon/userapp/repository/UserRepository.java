package org.akon.userapp.repository;

import org.akon.userapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User findByEmail(String email);

    User findByUsername(String username);

    User findOneByEmail(String email);

}
