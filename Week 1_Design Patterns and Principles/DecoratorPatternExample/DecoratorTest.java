public interface Notifier {
    void send(String message);
}

public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

public abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    
    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }
    
    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    
    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS notification: " + message);
    }
}

public class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    
    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack notification: " + message);
    }
}

public class DecoratorTest {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);
        
        slackNotifier.send("Hello, this is a notification!");
    }
}
