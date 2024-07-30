public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("meena.jpg");
        Image image2 = new ProxyImage("meenakshi.jpg");

        image1.display();
        System.out.println("");

        image1.display();
        System.out.println("");

        image2.display();
    }
}
