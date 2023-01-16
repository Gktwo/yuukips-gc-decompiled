package p013io.javalin.core.compression;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Gzip.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\b\n\u0002\b\u0004\u0018��2\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m373d2 = {"Lio/javalin/core/compression/Gzip;", "", "level", "", "(I)V", "getLevel", "()I", "javalin"})
/* renamed from: io.javalin.core.compression.Gzip */
/* loaded from: grasscutter.jar:io/javalin/core/compression/Gzip.class */
public final class Gzip {
    private final int level;

    public Gzip() {
        this(0, 1, null);
    }

    public Gzip(int level) {
        this.level = level;
        int i = this.level;
        if (!(0 <= i ? i <= 9 : false)) {
            throw new IllegalArgumentException("Valid range for parameter level is 0 to 9".toString());
        }
    }

    public /* synthetic */ Gzip(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public final int getLevel() {
        return this.level;
    }
}
