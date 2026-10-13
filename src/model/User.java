package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private int level = 1;
    private int currentXp = 0;
    private Rank rank = Rank.E_RANK;
    private final List<Task> tasks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void addXp(int amount) {
        this.currentXp += amount;
        this.level = 1 + (this.currentXp / 200);
        this.rank = Rank.getRankByXp(this.currentXp);
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getCurrentXp() { return currentXp; }
    public Rank getRank() { return rank; }
    public List<Task> getTasks() { return tasks; }
}