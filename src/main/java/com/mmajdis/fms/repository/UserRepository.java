package com.mmajdis.fms.repository;

import com.mmajdis.fms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for {@link User} entity.
 *
 * @author Matej Majdis [<a href="mailto:mato.majdis@gmail.com">mato.majdis@gmail.com</a>]
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds user by username.
     *
     * @param username unique username
     * @return found {@link User}
     */
    User findFirstByUsername(String username);
}
