package DailyJournal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Task {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private String name;
    private String description;
    private LocalDateTime date;
    private static int counter;
    private final Integer id;
    private boolean isPrivate;

    public Task(String name, String description, LocalDateTime date, boolean isPrivate) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.id = counter++;
        this.isPrivate = isPrivate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Integer getId() {
        return id;
    }

}
