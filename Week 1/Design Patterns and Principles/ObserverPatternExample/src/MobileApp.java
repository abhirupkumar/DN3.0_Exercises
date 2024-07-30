public class MobileApp implements Observer {
    public void update(String stockName, double stockPrice) {
        System.out.println("Mobile App: Stock " + stockName + " is now $" + stockPrice);
    }
}