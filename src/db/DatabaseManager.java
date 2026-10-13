package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:h2:./data/nexus_db;DB_CLOSE_DELAY=-1;AUTO_SERVER=TRUE";
    private static final String USER = "sa";
    private static final String PASS = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void initTables() {
        String schema = """
            CREATE TABLE IF NOT EXISTS users (
                id VARCHAR(50) PRIMARY KEY,
                name VARCHAR(100) NOT NULL,
                level INT DEFAULT 1,
                current_xp INT DEFAULT 0,
                rank VARCHAR(20) DEFAULT 'E_RANK'
            );

            CREATE TABLE IF NOT EXISTS tasks (
                id VARCHAR(50) PRIMARY KEY,
                user_id VARCHAR(50) NOT NULL,
                task_type VARCHAR(20) NOT NULL,
                title VARCHAR(255) NOT NULL,
                description TEXT,
                base_xp INT NOT NULL,
                completed BOOLEAN DEFAULT FALSE,
                target_score INT,
                FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
            );
        """;

        try (var conn = getConnection(); var stmt = conn.createStatement()) {
            stmt.execute(schema);
            System.out.println("[DATABASE] H2 Schema initialized successfully.");
        } catch (SQLException e) {
            System.err.println("[DATABASE ERROR] Initialization failed: " + e.getMessage());
        }
    }
}