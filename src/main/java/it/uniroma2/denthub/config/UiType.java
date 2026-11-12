package it.uniroma2.denthub.config;

import java.util.Arrays;
import java.util.Optional;

/** The two user interfaces of DentHub. */
public enum UiType {
    GUI("gui"),
    CLI("cli");

    private final String token;

    UiType(String token) {
        this.token = token;
    }

    public String token() {
        return token;
    }

    public static Optional<UiType> fromToken(String token) {
        return Arrays.stream(values()).filter(value -> value.token.equals(token)).findFirst();
    }
}
