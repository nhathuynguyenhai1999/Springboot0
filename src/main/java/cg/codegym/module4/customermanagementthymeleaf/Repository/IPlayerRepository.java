package cg.codegym.module4.customermanagementthymeleaf.Repository;

import cg.codegym.module4.customermanagementthymeleaf.Model.Player;
import cg.codegym.module4.customermanagementthymeleaf.Model.Positions;
import cg.codegym.module4.customermanagementthymeleaf.Model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

public interface IPlayerRepository extends CrudRepository<Player,Long> {
    Iterable<Player> findAllByProvince(Positions province);

    Page<Player> findAll(Pageable pageable);

    Page<Player> findAllByFirstNameContainingOrLastNameContaining(Pageable pageable, String firstName, String lastName);

    boolean existsById(Long id);

    Player findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT p FROM Player p WHERE p.firstName = :firstname")
    UserDetails loadUserByFirstName(@Param("firstname") String firstname);


    @Query("SELECT p FROM Player p WHERE p.firstName = :firstname")
    Player findByFirstName(@Param("firstname") String firstname);

    User findByUsername(String username);
}
