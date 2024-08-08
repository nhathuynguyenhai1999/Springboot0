package cg.codegym.module4.customermanagementthymeleaf.Repository;
import cg.codegym.module4.customermanagementthymeleaf.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}