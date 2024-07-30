public class WebApp implements Observer {
    public void update(String stockName, double stockPrice) {
        System.out.println("Web App: Stock " + stockName + " is now $" + stockPrice);
    }
}