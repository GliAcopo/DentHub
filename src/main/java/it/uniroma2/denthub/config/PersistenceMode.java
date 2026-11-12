package it.uniroma2.denthub.config;

import java.util.Arrays;
import java.util.Optional;

/** Where the data live: nowhere on disk (demo), on the file system, or on the DBMS. */
public enum PersistenceMode {
    DEMO("demo"),
    FILE("file"),
    DB("db");

    private final String token;

    PersistenceMode(String token) {
        this.token = token;
    }

    public String token() {
        return token;
    }

    public static Optional<PersistenceMode> fromToken(String token) {
        return Arrays.stream(values()).filter(value -> value.token.equals(token)).findFirst();
    }
}
