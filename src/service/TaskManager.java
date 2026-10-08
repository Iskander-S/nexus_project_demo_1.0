package service;

import model.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> filterTasks(boolean completedStatus) {
        List<Task> filtered = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted() == completedStatus) {
                filtered.add(task);
            }
        }
        return filtered;
    }

    public void getProgress() {
        System.out.println("Total Tasks: " + tasks.size());
    }
}
