package model;

public class DailyTask extends Task implements Evaluatable {

    public DailyTask(String title, String description) {
        super(title, description);
    }

    public void resetDaily() {
        this.reset();
    }

    @Override
    public void evaluate(double grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
    }

    @Override
    public int calculateBonus(double grade) {
        if (grade >= 90) return 30;
        if (grade >= 80) return 20;
        if (grade >= 70) return 10;
        return 0;
    }
}
