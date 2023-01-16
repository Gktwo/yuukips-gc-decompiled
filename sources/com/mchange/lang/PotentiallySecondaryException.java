package com.mchange.lang;

import com.mchange.p009v2.lang.VersionUtils;
import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: grasscutter.jar:com/mchange/lang/PotentiallySecondaryException.class */
public class PotentiallySecondaryException extends Exception implements PotentiallySecondary {
    static final String NESTED_MSG = ">>>>>>>>>> NESTED EXCEPTION >>>>>>>>";
    Throwable nested;

    public PotentiallySecondaryException(String str, Throwable th) {
        super(str, th);
        this.nested = th;
    }

    public PotentiallySecondaryException(Throwable th) {
        this("", th);
    }

    public PotentiallySecondaryException(String str) {
        this(str, null);
    }

    public PotentiallySecondaryException() {
        this("", null);
    }

    @Override // com.mchange.lang.PotentiallySecondary
    public Throwable getNestedThrowable() {
        return this.nested;
    }

    private void setNested(Throwable th) {
        this.nested = th;
        if (VersionUtils.isAtLeastJavaVersion14()) {
            initCause(th);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace(printWriter);
        if (!VersionUtils.isAtLeastJavaVersion14() && this.nested != null) {
            printWriter.println(NESTED_MSG);
            this.nested.printStackTrace(printWriter);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStackTrace(printStream);
        if (!VersionUtils.isAtLeastJavaVersion14() && this.nested != null) {
            printStream.println("NESTED_MSG");
            this.nested.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (VersionUtils.isAtLeastJavaVersion14()) {
            printStackTrace();
        } else {
            printStackTrace(System.err);
        }
    }
}
