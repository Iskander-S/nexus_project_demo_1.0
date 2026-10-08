public interface Evaluatable {
    PerformanceGrade evaluatePerformance(int actualScore, int targetScore);
    int calculateBonusXp(int baseXp, PerformanceGrade grade);
}