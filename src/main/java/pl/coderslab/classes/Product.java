package pl.coderslab.classes;


public class Product {
	private final String name;
	private final double price;
	private final long id;

	public Product(String name, double price, long id) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public long getId() {
		return id;
	}

}
// #### Zadanie 2 - rozwiązywane z wykładowcą
// 1. Utwórz klasę o nazwie `Product` - klasa ma zawierać właściwości:
// - typu String o nazwie `name`.
// - typu decimal o nazwie `price`.
// 2. Utwórz klasę o nazwie `CartItem` - klasa ma zawierać właściwości:
// - typu Integer o nazwie `quantity`.
// - typu Product o nazwie `product`.
// 3. Utwórz klasę o nazwie `Cart` - klasa ma zawierać właściwość:
// `private List<CartItem> cartItems;`
// 4. Ustal dla klasy `Cart` zasięg typu sesyjnego:
// ```java
// @Component
// @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode =
// ScopedProxyMode.TARGET_CLASS)
// ```
// 5. Utwórz kontroler `CartController`, wstrzyknij komponent typu `Cart`.
// 6. Utwórz akcję dostępną pod adresem `/addtocart` :
// ````java
// @RequestMapping("/addtocart")
// @ResponseBody
// public String addtocart(Model model, HttpSession ses) {
// Random rand = new Random();
// cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10),
// rand.nextDouble())));
// return "addtocart";
// }
// ````
// Utwórz w klasach odpowiednie konstruktory - tak by kod działał poprawnie.
//
// 7. Utwórz akcję dostępną pod adresem `/cart` w której wyświetlisz wszystkie
// produkty z koszyka.
