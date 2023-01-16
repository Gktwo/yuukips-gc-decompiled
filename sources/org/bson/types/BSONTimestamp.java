package org.bson.types;

import java.io.Serializable;
import java.util.Date;

/* loaded from: grasscutter.jar:org/bson/types/BSONTimestamp.class */
public final class BSONTimestamp implements Comparable<BSONTimestamp>, Serializable {
    private static final long serialVersionUID = -3268482672267936464L;
    private final int inc;
    private final Date time;

    public BSONTimestamp() {
        this.inc = 0;
        this.time = null;
    }

    public BSONTimestamp(int time, int increment) {
        this.time = new Date(((long) time) * 1000);
        this.inc = increment;
    }

    public int getTime() {
        if (this.time == null) {
            return 0;
        }
        return (int) (this.time.getTime() / 1000);
    }

    public int getInc() {
        return this.inc;
    }

    @Override // java.lang.Object
    public String toString() {
        return "TS time:" + this.time + " inc:" + this.inc;
    }

    public int compareTo(BSONTimestamp ts) {
        if (getTime() != ts.getTime()) {
            return getTime() - ts.getTime();
        }
        return getInc() - ts.getInc();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * ((31 * 1) + this.inc)) + getTime();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BSONTimestamp)) {
            return false;
        }
        BSONTimestamp t2 = (BSONTimestamp) obj;
        return getTime() == t2.getTime() && getInc() == t2.getInc();
    }
}
