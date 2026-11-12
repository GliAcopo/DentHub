package it.uniroma2.denthub.config;

import java.util.Locale;
import java.util.Optional;

/** Interface and persistence mode chosen on the command line. */
public record StartupOptions(UiType ui, PersistenceMode persistence) {

    public static final UiType DEFAULT_UI = UiType.GUI;
    public static final PersistenceMode DEFAULT_PERSISTENCE = PersistenceMode.DEMO;

    /**
     * Reads the startup arguments in any order, e.g. {@code cli file}.
     *
     * @throws IllegalArgumentException if an argument is neither an interface nor a persistence mode
     */
    public static StartupOptions parse(String... args) {
        UiType ui = DEFAULT_UI;
        PersistenceMode persistence = DEFAULT_PERSISTENCE;
        for (String arg : args) {
            String token = arg.trim().toLowerCase(Locale.ROOT);
            Optional<UiType> uiType = UiType.fromToken(token);
            Optional<PersistenceMode> mode = PersistenceMode.fromToken(token);
            if (uiType.isPresent()) {
                ui = uiType.get();
            } else if (mode.isPresent()) {
                persistence = mode.get();
            } else {
                throw new IllegalArgumentException("Unknown startup option: " + arg);
            }
        }
        return new StartupOptions(ui, persistence);
    }
}
