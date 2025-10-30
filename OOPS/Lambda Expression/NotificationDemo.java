import java.util.*;
import java.util.function.Predicate;

public class NotificationDemo {
    public static void main(String[] args) {
        List<Alert> alerts = new ArrayList<>();
        alerts.add(new Alert("Appointment Reminder", "info"));
        alerts.add(new Alert("Lab Result Ready", "important"));
        alerts.add(new Alert("Flu Shot Available", "info"));
        alerts.add(new Alert("Critical Alert: Heart Rate", "critical"));

        Predicate<Alert> showImportant = alert -> alert.type.equals("important") || alert.type.equals("critical");

        System.out.println("Filtered Alerts:");
        alerts.stream().filter(showImportant).forEach(alert -> 
            System.out.println(alert.title + " | Type: " + alert.type)
        );
    }
}

class Alert {
    String title;
    String type;

    Alert(String title, String type) {
        this.title = title;
        this.type = type;
    }
}
