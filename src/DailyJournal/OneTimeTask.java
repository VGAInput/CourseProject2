package DailyJournal;

import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask(String name, String description, LocalDateTime date, boolean isPrivate) {
        super(name, description, date, isPrivate);
    }
}
