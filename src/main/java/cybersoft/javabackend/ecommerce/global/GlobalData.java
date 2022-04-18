package cybersoft.javabackend.ecommerce.global;


import java.util.ArrayList;
import java.util.List;

import cybersoft.javabackend.ecommerce.product.model.Product;

public class GlobalData {
    //tao bien toan cuc
    public static List<Product> cart;

    static {
        cart = new ArrayList<>();
    }

}
