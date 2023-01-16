package com.mchange.lang;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: grasscutter.jar:com/mchange/lang/PotentiallySecondaryRuntimeException.class */
public class PotentiallySecondaryRuntimeException extends RuntimeException implements PotentiallySecondary {
    static final String NESTED_MSG = ">>>>>>>>>> NESTED EXCEPTION >>>>>>>>";
    Throwable nested;

    public PotentiallySecondaryRuntimeException(String str, Throwable th) {
        super(str);
        this.nested = th;
    }

    public PotentiallySecondaryRuntimeException(Throwable th) {
        this("", th);
    }

    public PotentiallySecondaryRuntimeException(String str) {
        this(str, null);
    }

    public PotentiallySecondaryRuntimeException() {
        this("", null);
    }

    @Override // com.mchange.lang.PotentiallySecondary
    public Throwable getNestedThrowable() {
        return this.nested;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace(printWriter);
        if (this.nested != null) {
            printWriter.println(NESTED_MSG);
            this.nested.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStackTrace(printStream);
        if (this.nested != null) {
            printStream.println("NESTED_MSG");
            this.nested.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }
}
