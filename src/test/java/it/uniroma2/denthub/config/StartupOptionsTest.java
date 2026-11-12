// Responsabile: Jacopo Rizzuto
package it.uniroma2.denthub.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StartupOptionsTest {

    @Test
    void testParseWithoutArgumentsGivesDefaults() {
        assertEquals(new StartupOptions(UiType.GUI, PersistenceMode.DEMO), StartupOptions.parse());
    }

    @Test
    void testParseReadsArgumentsInAnyOrder() {
        assertEquals(new StartupOptions(UiType.CLI, PersistenceMode.FILE), StartupOptions.parse("file", "CLI"));
    }

    @Test
    void testParseRejectsUnknownOption() {
        assertThrows(IllegalArgumentException.class, () -> StartupOptions.parse("web"));
    }
}
