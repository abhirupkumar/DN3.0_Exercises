import java.util.Arrays;

public class Search {
    public static Products linearSearch(Products[] products, String productId) {
        for (Products product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public static Products binarySearch(Products[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Products[] products = {
            new Products("1", "Laptop", "Electronics"),
            new Products("2", "Smartphone", "Electronics"),
            new Products("3", "Shoes", "Apparel"),
            new Products("4", "Watch", "Accessories"),
            new Products("5", "Bag", "Accessories")
        };

        // Ensure the array is sorted for binary search
        Arrays.sort(products, (a, b) -> a.getProductId().compareTo(b.getProductId()));

        // Linear search test
        System.out.println("Linear Search:");
        Products result = linearSearch(products, "3");
        System.out.println(result != null ? result : "Product not found");

        // Binary search test
        System.out.println("Binary Search:");
        result = binarySearch(products, "3");
        System.out.println(result != null ? result : "Product not found");
    }
}
