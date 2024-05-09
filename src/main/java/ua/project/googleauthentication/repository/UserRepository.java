package ua.project.googleauthentication.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ua.project.googleauthentication.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query("SELECT u from UserEntity u WHERE u.username like :username")
    Optional<UserEntity> findByUsername(String username);
}
