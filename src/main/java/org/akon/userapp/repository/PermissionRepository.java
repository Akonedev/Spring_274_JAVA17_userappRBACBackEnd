package org.akon.userapp.repository;

import org.akon.userapp.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Optional<Permission> findByPermission(String permission);

    @Query(value = "select count(*) from permissions_roles where permission_id = ?1", nativeQuery = true)
    Long countPermissionUsage(Long permissionId);

    void deleteByPermission(String permission);

}
