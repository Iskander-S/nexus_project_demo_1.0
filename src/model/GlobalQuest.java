package model;

public class GlobalQuest extends Task {

    public GlobalQuest(String title, String description) {
        super(title, description);
    }

    public boolean isGlobal() {
        return true;
    }
}