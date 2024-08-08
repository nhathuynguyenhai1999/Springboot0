package cg.codegym.module4.customermanagementthymeleaf.Service.iml;


import cg.codegym.module4.customermanagementthymeleaf.Model.CartItem;
import cg.codegym.module4.customermanagementthymeleaf.Repository.ICartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private ICartItemRepository cartItemRepository;
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}