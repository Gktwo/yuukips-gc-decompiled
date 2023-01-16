package p013io.netty.util;

import java.util.Arrays;

@Deprecated
/* renamed from: io.netty.util.ResourceLeakException */
/* loaded from: grasscutter.jar:io/netty/util/ResourceLeakException.class */
public class ResourceLeakException extends RuntimeException {
    private static final long serialVersionUID = 7186453858343358280L;
    private final StackTraceElement[] cachedStackTrace = getStackTrace();

    public ResourceLeakException() {
    }

    public ResourceLeakException(String message) {
        super(message);
    }

    public ResourceLeakException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceLeakException(Throwable cause) {
        super(cause);
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = 0;
        for (StackTraceElement e : this.cachedStackTrace) {
            hashCode = (hashCode * 31) + e.hashCode();
        }
        return hashCode;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (!(o instanceof ResourceLeakException)) {
            return false;
        }
        if (o == this) {
            return true;
        }
        return Arrays.equals(this.cachedStackTrace, ((ResourceLeakException) o).cachedStackTrace);
    }
}
