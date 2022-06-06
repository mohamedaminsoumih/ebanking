package ma.soumih.ebankingbackend.security.repositories;

import ma.soumih.ebankingbackend.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
