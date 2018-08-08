package pl.coderslab.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope(value = AnnotationConfigWebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {
	private  List<CartItem> cartItems = new ArrayList<>();
	
	
	public void addToCart(CartItem cartItem) {
		cartItems.add(cartItem);
	}


	public List<CartItem> getCartItems() {
		return cartItems;
	}
	
	
}
