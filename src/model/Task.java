package model;

public abstract class Task {
    protected String title;
    protected String description;
    protected boolean completed;

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false; // По умолчанию задача не завершена
    }

    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }

    public void complete() { this.completed = true; }
    public void reset() { this.completed = false; }
}
