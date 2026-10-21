package io.eventuate.common.database.testcontainers;

public class DatabaseCredentials {
    public final String userName;
    public final String password;

    public DatabaseCredentials(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
