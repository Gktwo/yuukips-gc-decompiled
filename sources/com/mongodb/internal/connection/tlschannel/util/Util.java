package com.mongodb.internal.connection.tlschannel.util;

import dev.morphia.mapping.Mapper;
import javax.net.ssl.SSLEngineResult;
import net.bytebuddy.ClassFileVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/util/Util.class */
public class Util {
    private static final Logger logger = LoggerFactory.getLogger(Util.class);

    public static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError();
        }
    }

    public static String resultToString(SSLEngineResult result) {
        return String.format("status=%s,handshakeStatus=%s,bytesConsumed=%d,bytesConsumed=%d", result.getStatus(), result.getHandshakeStatus(), Integer.valueOf(result.bytesProduced()), Integer.valueOf(result.bytesConsumed()));
    }

    public static int getJavaMajorVersion() {
        String version = System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION);
        if (version.startsWith("1.")) {
            version = version.substring(2, 3);
        } else {
            int dot = version.indexOf(Mapper.IGNORED_FIELDNAME);
            if (dot != -1) {
                version = version.substring(0, dot);
            }
        }
        return Integer.parseInt(version);
    }
}
