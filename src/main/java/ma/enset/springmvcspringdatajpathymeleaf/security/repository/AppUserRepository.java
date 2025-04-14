package ma.enset.springmvcspringdatajpathymeleaf.security.repository;


import ma.enset.springmvcspringdatajpathymeleaf.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
