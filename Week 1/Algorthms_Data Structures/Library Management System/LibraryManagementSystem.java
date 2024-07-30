public class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    // Linear search to find books by title
    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    // Binary search to find books by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem(5);

        Book book1 = new Book("1", "Java Programming", "John Doe");
        Book book2 = new Book("2", "Data Structures", "Jane Smith");
        Book book3 = new Book("3", "Algorithms", "Alice Johnson");

        lms.addBook(book1);
        lms.addBook(book2);
        lms.addBook(book3);

        System.out.println("Searching for 'Data Structures' using Linear Search:");
        Book foundBook = lms.linearSearchByTitle("Data Structures");
        System.out.println(foundBook != null ? foundBook : "Book not found");

        System.out.println("Searching for 'Algorithms' using Binary Search:");
        foundBook = lms.binarySearchByTitle("Algorithms");
        System.out.println(foundBook != null ? foundBook : "Book not found");
    }
}
