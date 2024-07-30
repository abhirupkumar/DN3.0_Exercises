class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

class Search {
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.productName.equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String productName, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productName.equals(productName)) {
                return products[mid];
            }
            if (products[mid].productName.compareTo(productName) > 0) {
                return binarySearch(products, productName, left, mid - 1);
            } else {
                return binarySearch(products, productName, mid + 1, right);
            }
        }
        return null;
    }
}

/*

Analysis
Linear Search: O(n)
Binary Search: O(log n)
Binary search is more suitable for large sorted datasets due to its logarithmic time complexity, compared to the linear time complexity of linear search.

 */