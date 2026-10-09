import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class EventImporter {

  private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("MM/dd/yyyy");

  public static List<Event> importEvents(String filename) throws IOException {

    List<Event> events = new ArrayList<>();

    List<String> lines = Files.readAllLines(Path.of(filename));

    boolean empty;

    for (String line : lines) {

      String[] values = line.split(",");

      empty = false;

      for (String value : values) if (value.trim().isEmpty()) empty = true;

      if (empty) {
        System.err.println("Invalid empty value.");
        continue;
      }

      try {
        LocalDate date = LocalDate.parse(values[0].trim(), FORMAT);

        String title = values[1].trim();
        String color = values[2].trim();

        events.add(new Event(date, title, color));
      } catch (DateTimeParseException e) {
        System.err.println(e.getMessage());
      }
    }

    return events;
  }
}
