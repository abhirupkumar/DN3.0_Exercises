import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            products.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
        } else {
            System.out.println("Product not found!");
        }
    }

    public Product getProduct(String productId) {
        return products.get(productId);
    }
    
    public void displayAllProducts() {
        for (Product product : products.values()) {
            System.out.println("Product ID: " + product.getProductId() + 
                               ", Name: " + product.getProductName() + 
                               ", Quantity: " + product.getQuantity() + 
                               ", Price: " + product.getPrice());
        }
    }

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        
        Product p1 = new Product("1", "Product A1", 101, 101.99);
        Product p2 = new Product("2", "Product B1", 151, 121.99);
        
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        
        inventory.displayAllProducts();
        
        p1.setPrice(11.99);
        inventory.updateProduct(p1);
        
        inventory.displayAllProducts();
        
        inventory.deleteProduct("2");
        
        inventory.displayAllProducts();
    }
}
