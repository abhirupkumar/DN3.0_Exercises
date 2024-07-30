public class ExcelDocument implements Document{
    
    public void open() {
        System.out.println("Opening Excel document.");
    }

    public void close() {
        System.out.println("Closing Excel document.");
    }

    public void save() {
        System.out.println("Saving Excel document.");
    }
}
