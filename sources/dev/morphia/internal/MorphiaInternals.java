package dev.morphia.internal;

import com.mongodb.lang.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:dev/morphia/internal/MorphiaInternals.class */
public final class MorphiaInternals {
    private static final Logger LOG = LoggerFactory.getLogger(MorphiaInternals.class);
    private static final Map<DriverVersion, Boolean> versions = new HashMap();
    private static Boolean proxyClassesPresent;

    /* loaded from: grasscutter.jar:dev/morphia/internal/MorphiaInternals$DriverVersion.class */
    public enum DriverVersion {
        v4_0_0,
        v4_1_0,
        v4_2_0
    }

    private MorphiaInternals() {
    }

    public static boolean proxyClassesPresent() {
        if (proxyClassesPresent == null) {
            try {
                Class.forName("net.bytebuddy.implementation.InvocationHandlerAdapter");
                proxyClassesPresent = true;
            } catch (ClassNotFoundException e) {
                LOG.warn("Lazy loading impossible due to missing dependencies.");
                proxyClassesPresent = false;
            }
        }
        return proxyClassesPresent.booleanValue();
    }

    @Nullable
    public static <V> V tryInvoke(DriverVersion version, Supplier<V> block) {
        if (versions.get(version) != null) {
            return null;
        }
        try {
            return block.get();
        } catch (NoSuchMethodError e) {
            versions.put(version, false);
            return null;
        }
    }

    public static <V> V tryInvoke(DriverVersion version, Supplier<V> block, Supplier<V> fallback) {
        if (versions.get(version) == null) {
            try {
                return block.get();
            } catch (NoSuchMethodError e) {
                versions.put(version, false);
            }
        }
        return fallback.get();
    }
}
