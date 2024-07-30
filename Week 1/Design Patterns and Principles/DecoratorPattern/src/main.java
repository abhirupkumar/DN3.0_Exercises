public class main {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsAndEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackSmsAndEmailNotifier = new SlackNotifierDecorator(smsAndEmailNotifier);

        System.out.println("Sending notifications via Email:");
        emailNotifier.send("Hello via Email!");

        System.out.println("\nSending notifications via Email and SMS:");
        smsAndEmailNotifier.send("Hello via Email and SMS!");

        System.out.println("\nSending notifications via Email, SMS, and Slack:");
        slackSmsAndEmailNotifier.send("Hello via Email, SMS, and Slack!");
    }
}
