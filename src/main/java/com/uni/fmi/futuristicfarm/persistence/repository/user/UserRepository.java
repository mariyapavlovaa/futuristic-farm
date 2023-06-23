package com.uni.fmi.futuristicfarm.persistence.repository.user;

import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.userrole.UserRole;
import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    List<User> findByRole(UserRole role);

    Optional<User> findByUsername(String username);
}
