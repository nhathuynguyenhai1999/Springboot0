package cg.codegym.module4.customermanagementthymeleaf.Repository;

import cg.codegym.module4.customermanagementthymeleaf.Model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartItemRepository extends JpaRepository<CartItem, Long> {
}