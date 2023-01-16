package dev.morphia.mapping;

import dev.morphia.sofia.Sofia;
import java.util.Locale;

/* loaded from: grasscutter.jar:dev/morphia/mapping/NotMappableException.class */
public final class NotMappableException extends RuntimeException {
    public NotMappableException(Class type) {
        super(Sofia.notMappable(type.getName(), new Locale[0]));
    }
}
