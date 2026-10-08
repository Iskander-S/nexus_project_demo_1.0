package service;

import model.User;

public class FileHandler {
    public void save(User user) {
        System.out.println("[SAVE] Progress saved successfully.");
    }

    public User load() {
        return new User("LoadedUser");
    }
}
