package DailyJournal;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task implements Repeatable {
    public DailyTask(String name, String description, LocalDateTime date, boolean isPrivate) {
        super(name, description, date, isPrivate);
    }

    public boolean checkIfApplies(LocalDate date) {
        return date.isAfter(date);
    }
}
