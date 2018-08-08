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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
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
