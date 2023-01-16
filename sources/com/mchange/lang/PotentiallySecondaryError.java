package com.mchange.lang;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: grasscutter.jar:com/mchange/lang/PotentiallySecondaryError.class */
public class PotentiallySecondaryError extends Error implements PotentiallySecondary {
    static final String NESTED_MSG = ">>>>>>>>>> NESTED THROWABLE >>>>>>>>";
    Throwable nested;

    public PotentiallySecondaryError(String str, Throwable th) {
        super(str);
        this.nested = th;
    }

    public PotentiallySecondaryError(Throwable th) {
        this("", th);
    }

    public PotentiallySecondaryError(String str) {
        this(str, null);
    }

    public PotentiallySecondaryError() {
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
