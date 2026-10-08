package service;

import exception.InvalidGradeException;
import model.DailyTask;
import model.GlobalQuest;
import model.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("Alex");
        System.out.println("[NEXUS] User: " + user.getName());

        TaskManager taskManager = new TaskManager();

        DailyTask javaAssignment = new DailyTask("Submit Java assignment", "Complete Checkpoint 1");
        GlobalQuest passExam = new GlobalQuest("Pass final exam", "Get an A grade");

        taskManager.addTask(javaAssignment);
        taskManager.addTask(passExam);

        EvaluationService evalService = new EvaluationService();
        try {
            evalService.evaluateAndReward(user, javaAssignment, 92);
        } catch (InvalidGradeException e) {
            System.err.println(e.getMessage());
        }

        FileHandler fileHandler = new FileHandler();
        fileHandler.save(user);
    }
}