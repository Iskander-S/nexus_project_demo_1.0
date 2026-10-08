package service;

import exception.InvalidGradeException;
import model.Evaluatable;
import model.Task;
import model.User;

public class EvaluationService {

    public void evaluateAndReward(User user, Task task, double grade) {
        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException("Invalid grade: " + grade);
        }

        user.completeTask(task);
        System.out.println("[TASK] " + task.getTitle() + " — COMPLETED");
        System.out.println("[GRADE] " + (int)grade + "%");

        int baseXp = 50; // Базовая награда
        int bonusXp = 0;

        if (task instanceof Evaluatable) {
            Evaluatable evalTask = (Evaluatable) task;
            evalTask.evaluate(grade);
            bonusXp = evalTask.calculateBonus(grade);
        }

        int totalXp = baseXp + bonusXp;
        System.out.println("[REWARD] Base XP: " + baseXp + " | Bonus XP: " + bonusXp + " | Total: " + totalXp);

        user.addXP(totalXp);
        System.out.println("[PROFILE] Level: " + user.getLevel() + " | XP: " + user.getXp() + " | Rank: " + user.getRank());
    }
}