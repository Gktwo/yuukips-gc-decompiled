package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jline.reader.LineReader;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: Settings.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��*\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n��\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018�� \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u0011\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020��J\u0019\u0010\t\u001a\u00020��2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0006\u0010\u001a\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n��¨\u0006\u001c"}, m373d2 = {"Lokhttp3/internal/http2/Settings;", "", "()V", "headerTableSize", "", "getHeaderTableSize", "()I", "initialWindowSize", "getInitialWindowSize", "set", "values", "", LineReader.CLEAR, "", BeanUtil.PREFIX_GETTER_GET, "id", "getEnablePush", "", "defaultValue", "getMaxConcurrentStreams", "getMaxFrameSize", "getMaxHeaderListSize", "isSet", "merge", "other", "value", "size", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/http2/Settings.class */
public final class Settings {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private int set;
    @NotNull
    private final int[] values = new int[10];
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int ENABLE_PUSH = 2;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int COUNT = 10;

    public final int getHeaderTableSize() {
        if ((2 & this.set) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public final int getInitialWindowSize() {
        if ((128 & this.set) != 0) {
            return this.values[7];
        }
        return 65535;
    }

    public final void clear() {
        this.set = 0;
        ArraysKt.fill$default(this.values, 0, 0, 0, 6, (Object) null);
    }

    @NotNull
    public final Settings set(int id, int value) {
        if (id < 0 || id >= this.values.length) {
            return this;
        }
        this.set |= 1 << id;
        this.values[id] = value;
        return this;
    }

    public final boolean isSet(int id) {
        return (this.set & (1 << id)) != 0;
    }

    public final int get(int id) {
        return this.values[id];
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }

    public final boolean getEnablePush(boolean defaultValue) {
        return (4 & this.set) != 0 ? this.values[2] == 1 : defaultValue;
    }

    public final int getMaxConcurrentStreams() {
        if ((16 & this.set) != 0) {
            return this.values[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int getMaxFrameSize(int defaultValue) {
        return (32 & this.set) != 0 ? this.values[5] : defaultValue;
    }

    public final int getMaxHeaderListSize(int defaultValue) {
        return (64 & this.set) != 0 ? this.values[6] : defaultValue;
    }

    public final void merge(@NotNull Settings other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i = 0;
        while (i < 10) {
            i++;
            if (other.isSet(i)) {
                set(i, other.get(i));
            }
        }
    }

    /* compiled from: Settings.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\f"}, m373d2 = {"Lokhttp3/internal/http2/Settings$Companion;", "", "()V", "COUNT", "", "DEFAULT_INITIAL_WINDOW_SIZE", "ENABLE_PUSH", "HEADER_TABLE_SIZE", "INITIAL_WINDOW_SIZE", "MAX_CONCURRENT_STREAMS", "MAX_FRAME_SIZE", "MAX_HEADER_LIST_SIZE", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/http2/Settings$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }
}
