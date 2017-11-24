package ankur.finalproject;

import android.content.res.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;


public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<Product> catalog;
    private static List<Product> cart;

    public static List<Product> getCatalog(Resources res) {
        if (catalog == null) {
            catalog = new Vector<Product>();
            catalog.add(new Product("Burger", res
                    .getDrawable(R.drawable.ic_burger),
                    "Dead or Alive by Tom Clancy with Grant Blackwood", 3.99));
            catalog.add(new Product("Pepperoni Pizza", res
                    .getDrawable(R.drawable.ic_pizza),
                    "Switch by Chip Heath and Dan Heath", 2.99));
            catalog.add(new Product("French Fries", res
                    .getDrawable(R.drawable.ic_fries),
                    "Watchmen by Alan Moore and Dave Gibbons", 1.99));
        }

        return catalog;
    }

    public static List<Product> getCart() {
        if (cart == null) {
            cart = new Vector<Product>();
        }

        return cart;
    }
}