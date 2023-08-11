package com.springmvc.crud.repository;

import com.springmvc.crud.model.entity.Role;
import com.springmvc.crud.model.enums.UserRolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(UserRolesEnum userRolesEnum);
}
