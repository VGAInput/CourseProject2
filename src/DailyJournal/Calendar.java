package DailyJournal;

import java.time.LocalDate;
import java.util.*;

public class Calendar {
    private final Map<Integer, Task> tasksMap;

    public Calendar() {
        tasksMap = new HashMap<>();
    }

    public void addTask(Task task) {
        tasksMap.put(task.getId(), task);
    }

    public void removeTask(int id){
        tasksMap.remove(id);
    }

    public List<Task> getOneDayTasks(LocalDate date) {
        List<Task> result = new ArrayList<>();
        for (Map.Entry<Integer, Task> entry : tasksMap.entrySet()) {
            if (entry.getValue() instanceof Repeatable && ((Repeatable) entry.getValue()).checkIfApplies(date)
                    || entry.getValue().getDate().toLocalDate().equals(date)) {
                result.add(entry.getValue());
            }
        }
        result.sort(Comparator.comparing(Task::getDate));
        return result;
    }
}
