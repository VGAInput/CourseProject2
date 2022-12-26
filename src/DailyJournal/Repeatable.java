package DailyJournal;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface Repeatable {

    public boolean checkIfApplies(LocalDate date);

}
