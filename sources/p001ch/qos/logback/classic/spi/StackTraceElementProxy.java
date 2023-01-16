package p001ch.qos.logback.classic.spi;

import java.io.Serializable;

/* renamed from: ch.qos.logback.classic.spi.StackTraceElementProxy */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/StackTraceElementProxy.class */
public class StackTraceElementProxy implements Serializable {
    private static final long serialVersionUID = -2374374378980555982L;
    final StackTraceElement ste;
    private transient String steAsString;
    private ClassPackagingData cpd;

    public StackTraceElementProxy(StackTraceElement ste) {
        if (ste == null) {
            throw new IllegalArgumentException("ste cannot be null");
        }
        this.ste = ste;
    }

    public String getSTEAsString() {
        if (this.steAsString == null) {
            this.steAsString = "at " + this.ste.toString();
        }
        return this.steAsString;
    }

    public StackTraceElement getStackTraceElement() {
        return this.ste;
    }

    public void setClassPackagingData(ClassPackagingData cpd) {
        if (this.cpd != null) {
            throw new IllegalStateException("Packaging data has been already set");
        }
        this.cpd = cpd;
    }

    public ClassPackagingData getClassPackagingData() {
        return this.cpd;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.ste.hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StackTraceElementProxy other = (StackTraceElementProxy) obj;
        if (!this.ste.equals(other.ste)) {
            return false;
        }
        if (this.cpd == null) {
            if (other.cpd != null) {
                return false;
            }
            return true;
        } else if (!this.cpd.equals(other.cpd)) {
            return false;
        } else {
            return true;
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return getSTEAsString();
    }
}
