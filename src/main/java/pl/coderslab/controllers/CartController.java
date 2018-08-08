package pl.coderslab.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.coderslab.classes.Cart;
import pl.coderslab.classes.CartItem;
import pl.coderslab.classes.Product;

@Controller
@SessionAttributes({ "cart", "cartSize", "totalPrice", "productQuantity" })
public class CartController {
	private final Cart cart;

	@Autowired
	public CartController(Cart cart) {
		this.cart = cart;
	}

	@GetMapping("/addtocart")
	public String showAddToCartForm() {
		return "addtocart";
	}

	@PostMapping("/addtocart")
	public String addtocart(@RequestParam("quantity") int quantity, @RequestParam("name") String name,
			@RequestParam("price") double price, @RequestParam("id")long id, Model model) {
		Product product = new Product(name, price, id);
		System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice() + " " + quantity);
		CartItem cartItemToAdd = new CartItem(quantity, product);
		List<CartItem> cartItems = cart.getCartItems();
		if (checkIfProductIsInCart(cartItemToAdd, cartItems)) {
			cart.addToCart(cartItemToAdd);
		} else {
			for (CartItem cartItem : cartItems) {
				if (cartItem.getProduct().getId() == cartItemToAdd.getProduct().getId()) {
					cartItem.setQuantity(quantity + cartItem.getQuantity());
				}
			}
		}
		model.addAttribute("cart", cart);
		return "redirect:cart";
	}

	@RequestMapping("/cart")
	public String showCart(HttpSession session, Model model) {
		List<CartItem> cartItems = cart.getCartItems();
		int cartSize = cartItems.size();
		int productQuantity = 0;
		double totalPrice = 0;
		for (CartItem cartItem : cartItems) {
			productQuantity += cartItem.getQuantity();
			totalPrice += (cartItem.getQuantity() * cartItem.getProduct().getPrice());
		}
		model.addAttribute("cart",cartItems);
		model.addAttribute("cartSize", cartSize);
		model.addAttribute("productQuantity", productQuantity);
		model.addAttribute("totalPrice", totalPrice);
		return "cart";
	}

	public boolean checkIfProductIsInCart(CartItem item, List<CartItem> list) {
		for (CartItem cartItem : list) {
			if (cartItem.getProduct().getId() == item.getProduct().getId()) {
				return false;
			}
		}
		return true;
	}
}
