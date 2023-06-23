package com.uni.fmi.futuristicfarm.persistence.repository.userrole;

import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.userrole.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
