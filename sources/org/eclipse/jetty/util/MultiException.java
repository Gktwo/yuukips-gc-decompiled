package org.eclipse.jetty.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.HttpUrl;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/MultiException.class */
public class MultiException extends Exception {
    private static final String DEFAULT_MESSAGE = "Multiple exceptions";
    private List<Throwable> nested;

    public MultiException() {
        super(DEFAULT_MESSAGE, null, false, false);
        this.nested = new ArrayList();
    }

    private MultiException(List<Throwable> nested) {
        super(DEFAULT_MESSAGE);
        this.nested = new ArrayList(nested);
        if (nested.size() > 0) {
            initCause(nested.get(0));
        }
        for (Throwable t : nested) {
            if (t != this) {
                addSuppressed(t);
            }
        }
    }

    public void add(Throwable e) {
        if (e instanceof MultiException) {
            this.nested.addAll(((MultiException) e).nested);
        } else {
            this.nested.add(e);
        }
    }

    public int size() {
        if (this.nested == null) {
            return 0;
        }
        return this.nested.size();
    }

    public List<Throwable> getThrowables() {
        if (this.nested == null) {
            return Collections.emptyList();
        }
        return this.nested;
    }

    public Throwable getThrowable(int i) {
        return this.nested.get(i);
    }

    public void ifExceptionThrow() throws Exception {
        if (this.nested != null) {
            switch (this.nested.size()) {
                case 0:
                    return;
                case 1:
                    Throwable th = this.nested.get(0);
                    if (th instanceof Error) {
                        throw ((Error) th);
                    } else if (th instanceof Exception) {
                        throw ((Exception) th);
                    } else {
                        throw new MultiException(this.nested);
                    }
                default:
                    throw new MultiException(this.nested);
            }
        }
    }

    public void ifExceptionThrowRuntime() throws Error {
        if (this.nested != null) {
            switch (this.nested.size()) {
                case 0:
                    return;
                case 1:
                    Throwable th = this.nested.get(0);
                    if (th instanceof Error) {
                        throw ((Error) th);
                    } else if (th instanceof RuntimeException) {
                        throw ((RuntimeException) th);
                    } else {
                        throw new RuntimeException(th);
                    }
                default:
                    throw new RuntimeException(new MultiException(this.nested));
            }
        }
    }

    public void ifExceptionThrowMulti() throws MultiException {
        if (this.nested != null && this.nested.size() > 0) {
            throw new MultiException(this.nested);
        }
    }

    public void ifExceptionThrowSuppressed() throws Exception {
        if (!(this.nested == null || this.nested.size() == 0)) {
            Throwable th = this.nested.get(0);
            if (!(th instanceof Error) && !(th instanceof Exception)) {
                th = new MultiException(Collections.emptyList());
            }
            for (Throwable s : this.nested) {
                if (s != th) {
                    th.addSuppressed(s);
                }
            }
            if (th instanceof Error) {
                throw ((Error) th);
            }
            throw ((Exception) th);
        }
    }

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(MultiException.class.getSimpleName());
        if (this.nested == null || this.nested.size() <= 0) {
            str.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        } else {
            str.append(this.nested);
        }
        return str.toString();
    }
}
