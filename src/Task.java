public abstract class Task {
    private final String id;
    private final String title;
    private final String description;
    private final int baseXp;
    private boolean completed;

    public Task(String id, String title, String description, int baseXp) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.baseXp = baseXp;
        this.completed = false;
    }

    public abstract void complete();

    public String getId() { return id; }
    public String getTitle() { return title; }
    public int getBaseXp() { return baseXp; }
    public boolean isCompleted() { return completed; }
    protected void setCompleted(boolean completed) { this.completed = completed; }
}