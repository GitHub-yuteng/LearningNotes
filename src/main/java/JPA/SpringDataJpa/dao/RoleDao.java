package JPA.SpringDataJpa.dao;

import JPA.SpringDataJpa.pojo.Role;
import JPA.SpringDataJpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Yu
 */
public interface RoleDao extends JpaRepository<Role,Long>, JpaSpecificationExecutor<Role> {
}
