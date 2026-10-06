import java.time.LocalDate;

public class Event {

    private LocalDate date;
    private String title;
    private String color;

    public Event(LocalDate date, String title, String color) {
        this.date = date;
        this.title = title;
        this.color = color;
    }

    @Override
    public String toString() {
        return date + " | " + title + " | " + color;
    }
}