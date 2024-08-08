package cg.codegym.module4.customermanagementthymeleaf.Repository;

import cg.codegym.module4.customermanagementthymeleaf.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}