package dev.morphia;

import com.mongodb.lang.Nullable;
import dev.morphia.sofia.Sofia;
import java.util.ConcurrentModificationException;
import java.util.Locale;

/* loaded from: grasscutter.jar:dev/morphia/VersionMismatchException.class */
public class VersionMismatchException extends ConcurrentModificationException {
    public VersionMismatchException(Class<?> type, @Nullable Object idValue) {
        super(Sofia.concurrentModification(type.getName(), idValue, new Locale[0]));
    }
}
