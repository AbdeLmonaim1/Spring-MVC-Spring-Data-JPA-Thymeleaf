package ma.enset.springmvcspringdatajpathymeleaf.security.repository;

import ma.enset.springmvcspringdatajpathymeleaf.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
}
