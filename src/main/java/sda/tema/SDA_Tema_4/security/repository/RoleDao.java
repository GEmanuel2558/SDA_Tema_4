package sda.tema.SDA_Tema_4.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.tema.SDA_Tema_4.security.entitys.Role;
import sda.tema.SDA_Tema_4.security.entitys.RoleName;

import java.util.Optional;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}