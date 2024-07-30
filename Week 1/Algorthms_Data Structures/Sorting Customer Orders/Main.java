import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("1", "Alice", 150.50),
            new Order("2", "Bob", 80.75),
            new Order("3", "Charlie", 200.00),
            new Order("4", "David", 50.25),
            new Order("5", "Eve", 100.00)
        };

        // Bubble Sort
        System.out.println("Before Bubble Sort:");
        Arrays.stream(orders).forEach(System.out::println);
        
        Sorting.bubbleSort(orders);

        System.out.println("\nAfter Bubble Sort:");
        Arrays.stream(orders).forEach(System.out::println);

        // Reset the order array
        orders = new Order[]{
            new Order("1", "Alice", 150.50),
            new Order("2", "Bob", 80.75),
            new Order("3", "Charlie", 200.00),
            new Order("4", "David", 50.25),
            new Order("5", "Eve", 100.00)
        };

        // Quick Sort
        System.out.println("\nBefore Quick Sort:");
        Arrays.stream(orders).forEach(System.out::println);

        Sorting.quickSort(orders, 0, orders.length - 1);

        System.out.println("\nAfter Quick Sort:");
        Arrays.stream(orders).forEach(System.out::println);
    }
}
