package org.eclipse.jetty.util;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ConstantThrowable.class */
public class ConstantThrowable extends Throwable {
    public ConstantThrowable() {
        this(null);
    }

    public ConstantThrowable(String name) {
        super(name, null, false, false);
    }

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        return String.valueOf(getMessage());
    }
}
