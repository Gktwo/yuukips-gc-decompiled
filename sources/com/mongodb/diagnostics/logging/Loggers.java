package com.mongodb.diagnostics.logging;

import com.mongodb.assertions.Assertions;
import dev.morphia.mapping.Mapper;
import java.util.logging.Logger;

/* loaded from: grasscutter.jar:com/mongodb/diagnostics/logging/Loggers.class */
public final class Loggers {
    private static final String PREFIX = "org.mongodb.driver";
    private static final boolean USE_SLF4J = shouldUseSLF4J();

    public static Logger getLogger(String suffix) {
        Assertions.notNull("suffix", suffix);
        if (suffix.startsWith(Mapper.IGNORED_FIELDNAME) || suffix.endsWith(Mapper.IGNORED_FIELDNAME)) {
            throw new IllegalArgumentException("The suffix can not start or end with a '.'");
        }
        String name = "org.mongodb.driver." + suffix;
        if (USE_SLF4J) {
            return new SLF4JLogger(name);
        }
        return new NoOpLogger(name);
    }

    private Loggers() {
    }

    private static boolean shouldUseSLF4J() {
        try {
            Class.forName("org.slf4j.Logger");
            return true;
        } catch (ClassNotFoundException e) {
            Logger.getLogger(PREFIX).warning(String.format("SLF4J not found on the classpath.  Logging is disabled for the '%s' component", PREFIX));
            return false;
        }
    }
}
