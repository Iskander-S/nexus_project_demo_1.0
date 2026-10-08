package model;

public class User {
    private String name;
    private int level;
    private int xp;
    private Rank rank;

    public User(String name) {
        this.name = name;
        this.level = 1;
        this.xp = 0;
        this.rank = Rank.E;
    }

    public void addXP(int gainedXp) {
        this.xp += gainedXp;
        this.level = (this.xp / 100) + 1; // Уровень каждые 100 XP
        calculateRank();
    }

    public void calculateRank() {
        if (this.xp >= 1000) this.rank = Rank.S;
        else if (this.xp >= 800) this.rank = Rank.A;
        else if (this.xp >= 600) this.rank = Rank.B;
        else if (this.xp >= 400) this.rank = Rank.C;
        else if (this.xp >= 200) this.rank = Rank.D;
        else this.rank = Rank.E;
    }

    public void completeTask(Task task) {
        task.complete();
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getXp() { return xp; }
    public Rank getRank() { return rank; }
}