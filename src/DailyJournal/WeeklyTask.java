package DailyJournal;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task implements Repeatable {
    public WeeklyTask(String name, String description, LocalDateTime date, boolean isPrivate) {
        super(name, description, date, isPrivate);
    }

    public boolean checkIfApplies(LocalDate date) {
        return date.getDayOfWeek() == date.getDayOfWeek();
    }
}
