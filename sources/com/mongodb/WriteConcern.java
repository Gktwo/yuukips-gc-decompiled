package com.mongodb;

import com.mongodb.annotations.Immutable;
import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.BsonValue;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/WriteConcern.class */
public class WriteConcern implements Serializable {
    private static final long serialVersionUID = 1884671104750417011L;

    /* renamed from: w */
    private final Object f434w;
    private final Integer wTimeoutMS;
    private final Boolean journal;
    public static final WriteConcern ACKNOWLEDGED = new WriteConcern(null, null, null);

    /* renamed from: W1 */
    public static final WriteConcern f435W1 = new WriteConcern(1);

    /* renamed from: W2 */
    public static final WriteConcern f436W2 = new WriteConcern(2);

    /* renamed from: W3 */
    public static final WriteConcern f437W3 = new WriteConcern(3);
    public static final WriteConcern UNACKNOWLEDGED = new WriteConcern(0);
    public static final WriteConcern JOURNALED = ACKNOWLEDGED.withJournal(true);
    public static final WriteConcern MAJORITY = new WriteConcern("majority");
    private static final Map<String, WriteConcern> NAMED_CONCERNS = new HashMap();

    static {
        Field[] fields = WriteConcern.class.getFields();
        for (Field f : fields) {
            if (Modifier.isStatic(f.getModifiers()) && f.getType().equals(WriteConcern.class)) {
                try {
                    NAMED_CONCERNS.put(f.getName().toLowerCase(), (WriteConcern) f.get(null));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public WriteConcern(int w) {
        this(Integer.valueOf(w), null, null);
    }

    public WriteConcern(String w) {
        this(w, null, null);
        Assertions.notNull("w", w);
    }

    public WriteConcern(int w, int wTimeoutMS) {
        this(Integer.valueOf(w), Integer.valueOf(wTimeoutMS), null);
    }

    private WriteConcern(@Nullable Object w, @Nullable Integer wTimeoutMS, @Nullable Boolean journal) {
        if (w instanceof Integer) {
            Assertions.isTrueArgument("w >= 0", ((Integer) w).intValue() >= 0);
            if (((Integer) w).intValue() == 0) {
                Assertions.isTrueArgument("journal is false when w is 0", journal == null || !journal.booleanValue());
            }
        } else if (w != null) {
            Assertions.isTrueArgument("w must be String or int", w instanceof String);
        }
        Assertions.isTrueArgument("wtimeout >= 0", wTimeoutMS == null || wTimeoutMS.intValue() >= 0);
        this.f434w = w;
        this.wTimeoutMS = wTimeoutMS;
        this.journal = journal;
    }

    @Nullable
    public Object getWObject() {
        return this.f434w;
    }

    public int getW() {
        Assertions.isTrue("w is an Integer", this.f434w != null && (this.f434w instanceof Integer));
        return ((Integer) this.f434w).intValue();
    }

    public String getWString() {
        Assertions.isTrue("w is a String", this.f434w != null && (this.f434w instanceof String));
        return (String) this.f434w;
    }

    @Nullable
    public Integer getWTimeout(TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        if (this.wTimeoutMS == null) {
            return null;
        }
        return Integer.valueOf((int) timeUnit.convert((long) this.wTimeoutMS.intValue(), TimeUnit.MILLISECONDS));
    }

    @Nullable
    public Boolean getJournal() {
        return this.journal;
    }

    public boolean isServerDefault() {
        return equals(ACKNOWLEDGED);
    }

    public BsonDocument asDocument() {
        BsonDocument document = new BsonDocument();
        addW(document);
        addWTimeout(document);
        addJ(document);
        return document;
    }

    public boolean isAcknowledged() {
        return !(this.f434w instanceof Integer) || ((Integer) this.f434w).intValue() > 0 || (this.journal != null && this.journal.booleanValue());
    }

    public static WriteConcern valueOf(String name) {
        return NAMED_CONCERNS.get(name.toLowerCase());
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WriteConcern that = (WriteConcern) o;
        if (this.f434w != null) {
            if (!this.f434w.equals(that.f434w)) {
                return false;
            }
        } else if (that.f434w != null) {
            return false;
        }
        if (this.wTimeoutMS != null) {
            if (!this.wTimeoutMS.equals(that.wTimeoutMS)) {
                return false;
            }
        } else if (that.wTimeoutMS != null) {
            return false;
        }
        if (this.journal != null) {
            if (!this.journal.equals(that.journal)) {
                return false;
            }
            return true;
        } else if (that.journal != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * ((31 * (this.f434w != null ? this.f434w.hashCode() : 0)) + (this.wTimeoutMS != null ? this.wTimeoutMS.hashCode() : 0))) + (this.journal != null ? this.journal.hashCode() : 0);
    }

    @Override // java.lang.Object
    public String toString() {
        return "WriteConcern{w=" + this.f434w + ", wTimeout=" + this.wTimeoutMS + " ms, journal=" + this.journal;
    }

    public WriteConcern withW(int w) {
        return new WriteConcern(Integer.valueOf(w), this.wTimeoutMS, this.journal);
    }

    public WriteConcern withW(String w) {
        Assertions.notNull("w", w);
        return new WriteConcern(w, this.wTimeoutMS, this.journal);
    }

    public WriteConcern withJournal(@Nullable Boolean journal) {
        return new WriteConcern(this.f434w, this.wTimeoutMS, journal);
    }

    public WriteConcern withWTimeout(long wTimeout, TimeUnit timeUnit) {
        Assertions.notNull("timeUnit", timeUnit);
        long newWTimeOutMS = TimeUnit.MILLISECONDS.convert(wTimeout, timeUnit);
        Assertions.isTrueArgument("wTimeout >= 0", wTimeout >= 0);
        Assertions.isTrueArgument("wTimeout <= 2147483647 ms", newWTimeOutMS <= 2147483647L);
        return new WriteConcern(this.f434w, Integer.valueOf((int) newWTimeOutMS), this.journal);
    }

    private void addW(BsonDocument document) {
        if (this.f434w instanceof String) {
            document.put("w", (BsonValue) new BsonString((String) this.f434w));
        } else if (this.f434w instanceof Integer) {
            document.put("w", (BsonValue) new BsonInt32(((Integer) this.f434w).intValue()));
        }
    }

    private void addJ(BsonDocument document) {
        if (this.journal != null) {
            document.put("j", (BsonValue) BsonBoolean.valueOf(this.journal.booleanValue()));
        }
    }

    private void addWTimeout(BsonDocument document) {
        if (this.wTimeoutMS != null) {
            document.put("wtimeout", (BsonValue) new BsonInt32(this.wTimeoutMS.intValue()));
        }
    }
}
