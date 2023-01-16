package p001ch.qos.logback.core.util;

/* renamed from: ch.qos.logback.core.util.InvocationGate */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/InvocationGate.class */
public interface InvocationGate {
    public static final long TIME_UNAVAILABLE = -1;

    boolean isTooSoon(long j);
}
