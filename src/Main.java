import db.DatabaseManager;
import db.TaskDao;
import exception.InvalidGradeException;
import model.*;
import service.EvaluationService;
import service.TaskManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== [NEXUS SYSTEM INITIALIZED - H2 DB INTEGRATION] ===\n");

        DatabaseManager.initTables();
        TaskDao taskDao = new TaskDao();

        String userId = "user_003";
        User user = new User("Iskander");
        EvaluationService evalService = new EvaluationService();
        TaskManager taskManager = new TaskManager(user.getTasks());

        DailyTask daily = new DailyTask("D3", "Read Java Docs", "Read Chapter 5 for 20 mins");
        WeeklyTask weekly = new WeeklyTask("W3", "Lab Assignment 2", "Implement OOP inheritance");
        GlobalQuest global = new GlobalQuest("Q3", "CTEC2710K 00 Design Exam", "Final Assessment", 300, 80);

        taskManager.addTask(daily);
        taskManager.addTask(weekly);
        taskManager.addTask(global);

        try {
            int earnedXp = evalService.processTaskEvaluation(global, 92);
            user.addXp(earnedXp);
        } catch (InvalidGradeException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println("--- [PERSISTENCE: SAVING TO H2 DATABASE] ---");
        taskDao.saveUser(user, userId);
        taskManager.getAllTasks().forEach(task -> taskDao.saveTask(task, userId));
        System.out.println("[PERSISTENCE] Saved to H2 DB successfully.");

        System.out.println("\n--- [PERSISTENCE: LOADING FROM H2 DATABASE] ---");
        var restoredTasks = taskDao.loadTasksByUserId(userId);
        System.out.printf("Loaded %d tasks from H2 Database for user '%s':\n", restoredTasks.size(), userId);
        restoredTasks.forEach(t -> System.out.println("  [H2 RECORD] " + t));
    }
}