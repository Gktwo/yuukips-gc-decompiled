package org.bson.diagnostics;

import dev.morphia.mapping.Mapper;
import java.util.logging.Logger;
import org.bson.assertions.Assertions;

/* loaded from: grasscutter.jar:org/bson/diagnostics/Loggers.class */
public final class Loggers {
    private static final String PREFIX = "org.bson";
    private static final boolean USE_SLF4J = shouldUseSLF4J();

    public static Logger getLogger(String suffix) {
        Assertions.notNull("suffix", suffix);
        if (suffix.startsWith(Mapper.IGNORED_FIELDNAME) || suffix.endsWith(Mapper.IGNORED_FIELDNAME)) {
            throw new IllegalArgumentException("The suffix can not start or end with a '.'");
        }
        String name = "org.bson." + suffix;
        if (USE_SLF4J) {
            return new SLF4JLogger(name);
        }
        return new NoOpLogger(name);
    }

    private static boolean shouldUseSLF4J() {
        try {
            Class.forName("org.slf4j.Logger");
            return true;
        } catch (ClassNotFoundException e) {
            Logger.getLogger(PREFIX).warning(String.format("SLF4J not found on the classpath. Logging is disabled for the '%s' component", PREFIX));
            return false;
        }
    }

    private Loggers() {
    }
}
