package DailyJournal;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task implements Repeatable {
    public MonthlyTask(String name, String description, LocalDateTime date, boolean isPrivate) {
        super(name, description, date, isPrivate);
    }

    public boolean checkIfApplies(LocalDate date) {
        return date.getDayOfMonth() == date.getDayOfMonth();
    }
}
