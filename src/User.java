import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private int level;
    private int currentXp;
    private Rank rank;
    private final List<Task> tasks;

    public User(String name) {
        this.name = name;
        this.level = 1;
        this.currentXp = 0;
        this.rank = Rank.E_RANK;
        this.tasks = new ArrayList<>();
    }

    public void addXp(int amount) {
        this.currentXp += amount;
        checkLevelUp();
        updateRank();
    }

    private void checkLevelUp() {
        this.level = 1 + (this.currentXp / 200);
    }

    private void updateRank() {
        if (currentXp >= 2000) rank = Rank.S_RANK;
        else if (currentXp >= 1600) rank = Rank.A_RANK;
        else if (currentXp >= 1200) rank = Rank.B_RANK;
        else if (currentXp >= 600) rank = Rank.C_RANK;
        else if (currentXp >= 400) rank = Rank.D_RANK;
        else rank = Rank.E_RANK;
    }

    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getCurrentXp() { return currentXp; }
    public Rank getRank() { return rank; }
    public List<Task> getTasks() { return tasks; }
}