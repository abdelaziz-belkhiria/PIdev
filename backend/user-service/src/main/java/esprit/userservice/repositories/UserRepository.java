package esprit.userservice.repositories;


import esprit.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Used for login to find user by username
    Optional<User> findByUsername(String username);
    // Used for register to check duplicates
    Boolean existsByUsername(String username);
}