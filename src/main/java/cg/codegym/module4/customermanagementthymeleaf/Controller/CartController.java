package cg.codegym.module4.customermanagementthymeleaf.Controller;

import cg.codegym.module4.customermanagementthymeleaf.Model.CartItem;
import cg.codegym.module4.customermanagementthymeleaf.Service.iml.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartItemService cartItemService;
    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @PostMapping
    public CartItem addCartItem(@RequestBody CartItem cartItem) {
        return cartItemService.saveCartItem(cartItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }
}