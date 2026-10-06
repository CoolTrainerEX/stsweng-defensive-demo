import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Event> events =
                EventImporter.importEvents("events.csv");

        System.out.println("Imported Events");

        for (Event event : events) {
            System.out.println(event);
        }
    }
}