import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("[NEXUS SYSTEM INITIALIZED]");

        User user = new User("Iskander");
        System.out.printf("[USER CREATED] Hunter: %s | Initial Level: %d | Rank: %s | XP: %d\n\n",
                user.getName(), user.getLevel(), user.getRank().getDisplayName(), user.getCurrentXp());

        GlobalQuest quest = new GlobalQuest("Q1", "CTEC2710K OO Design Exam", "Final Assessment", 300, 80);
        user.getTasks().add(quest);
        System.out.printf("[QUEST ADDED] GlobalQuest: \"%s\" (Target: %d%%)\n", quest.getTitle(), quest.getTargetScore());

        int submittedScore = 92;
        System.out.printf("[EXECUTING QUEST] Result Submitted: %d%%\n\n", submittedScore);
        quest.complete();

        System.out.println("[EVALUATION] Evaluatable Interface Triggered...");
        PerformanceGrade grade = quest.evaluatePerformance(submittedScore, quest.getTargetScore());
        int baseXp = quest.getBaseXp();
        int bonusXp = quest.calculateBonusXp(baseXp, grade);
        int totalXp = baseXp + bonusXp;

        System.out.printf("[PERFORMANCE] Grade: %s (EXCEEDED TARGET)\n", grade.name());
        System.out.printf("[REWARD] Base XP: %d | Bonus XP: %d (Rank %s Multiplier %.1fx) | Total Earned: %d XP\n\n",
                baseXp, bonusXp, grade.name(), (1.0 + grade.getBonusMultiplier()), totalXp);

        int oldLevel = user.getLevel();
        Rank oldRank = user.getRank();
        user.addXp(totalXp);

        System.out.println("[PROFILE UPDATE]");
        System.out.printf(" -> XP Added: %d\n", totalXp);
        System.out.printf(" -> LEVEL UP! Level %d -> Level %d\n", oldLevel, user.getLevel());
        System.out.printf(" -> RANK UP PROMOTION! %s -> %s\n\n", oldRank.getDisplayName(), user.getRank().getDisplayName());

        saveProgress(user, "user_profile.dat");
    }

    private static void saveProgress(User user, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("User:" + user.getName());
            writer.println("Level:" + user.getLevel());
            writer.println("XP:" + user.getCurrentXp());
            writer.println("Rank:" + user.getRank().getDisplayName());
            System.out.printf("[PERSISTENCE] Progress saved to '%s' successfully.\n", filename);
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to save progress: " + e.getMessage());
        }
    }
}