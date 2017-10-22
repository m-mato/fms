package com.mmajdis.fms.repository;

import com.mmajdis.fms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByUsername(String username);
}
