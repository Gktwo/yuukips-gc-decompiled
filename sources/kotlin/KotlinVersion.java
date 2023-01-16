package kotlin;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: KotlinVersion.kt */
@SinceKotlin(version = "1.1")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n��\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0010��\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018�� \u00172\b\u0012\u0004\u0012\u00020��0\u0001:\u0001\u0017B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020��H\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��¨\u0006\u0018"}, m373d2 = {"Lkotlin/KotlinVersion;", "", "major", "", "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", "other", "equals", "", "", "hashCode", "isAtLeast", Printer.TO_STRING, "", "versionOf", "Companion", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/KotlinVersion.class */
public final class KotlinVersion implements Comparable<KotlinVersion> {
    private final int major;
    private final int minor;
    private final int patch;
    private final int version;
    public static final int MAX_COMPONENT_VALUE = 255;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final KotlinVersion CURRENT = KotlinVersionCurrentValue.get();

    public KotlinVersion(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
        this.version = versionOf(this.major, this.minor, this.patch);
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public KotlinVersion(int major, int minor) {
        this(major, minor, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int versionOf(int r5, int r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            r1 = r5
            if (r0 > r1) goto L_0x0014
            r0 = r5
            r1 = 256(0x100, float:3.59E-43)
            if (r0 >= r1) goto L_0x0010
            r0 = 1
            goto L_0x0015
        L_0x0010:
            r0 = 0
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x004c
            r0 = 0
            r1 = r6
            if (r0 > r1) goto L_0x002c
            r0 = r6
            r1 = 256(0x100, float:3.59E-43)
            if (r0 >= r1) goto L_0x0028
            r0 = 1
            goto L_0x002d
        L_0x0028:
            r0 = 0
            goto L_0x002d
        L_0x002c:
            r0 = 0
        L_0x002d:
            if (r0 == 0) goto L_0x004c
            r0 = 0
            r1 = r7
            if (r0 > r1) goto L_0x0044
            r0 = r7
            r1 = 256(0x100, float:3.59E-43)
            if (r0 >= r1) goto L_0x0040
            r0 = 1
            goto L_0x0045
        L_0x0040:
            r0 = 0
            goto L_0x0045
        L_0x0044:
            r0 = 0
        L_0x0045:
            if (r0 == 0) goto L_0x004c
            r0 = 1
            goto L_0x004d
        L_0x004c:
            r0 = 0
        L_0x004d:
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L_0x008b
            r0 = 0
            r9 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            java.lang.String r1 = "Version components are out of range: "
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = 46
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = 46
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r9 = r0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r9
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x008b:
            r0 = r5
            r1 = 16
            int r0 = r0 << r1
            r1 = r6
            r2 = 8
            int r1 = r1 << r2
            int r0 = r0 + r1
            r1 = r7
            int r0 = r0 + r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.KotlinVersion.versionOf(int, int, int):int");
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: int : 0x0008: IGET  (r1v2 int A[REMOVE]) = (r3v0 'this' kotlin.KotlinVersion A[D('this' kotlin.KotlinVersion), IMMUTABLE_TYPE, THIS]) kotlin.KotlinVersion.major int), ('.' char), (wrap: int : 0x0014: IGET  (r1v5 int A[REMOVE]) = (r3v0 'this' kotlin.KotlinVersion A[D('this' kotlin.KotlinVersion), IMMUTABLE_TYPE, THIS]) kotlin.KotlinVersion.minor int), ('.' char), (wrap: int : 0x0020: IGET  (r1v8 int A[REMOVE]) = (r3v0 'this' kotlin.KotlinVersion A[D('this' kotlin.KotlinVersion), IMMUTABLE_TYPE, THIS]) kotlin.KotlinVersion.patch int)] */
    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return new StringBuilder().append(this.major).append('.').append(this.minor).append('.').append(this.patch).toString();
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        KotlinVersion otherVersion = other instanceof KotlinVersion ? (KotlinVersion) other : null;
        return otherVersion != null && this.version == otherVersion.version;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.version;
    }

    public int compareTo(@NotNull KotlinVersion other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.version - other.version;
    }

    public final boolean isAtLeast(int major, int minor) {
        return this.major > major || (this.major == major && this.minor >= minor);
    }

    public final boolean isAtLeast(int major, int minor, int patch) {
        return this.major > major || (this.major == major && (this.minor > minor || (this.minor == minor && this.patch >= patch)));
    }

    /* compiled from: KotlinVersion.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n��¨\u0006\u0007"}, m373d2 = {"Lkotlin/KotlinVersion$Companion;", "", "()V", "CURRENT", "Lkotlin/KotlinVersion;", "MAX_COMPONENT_VALUE", "", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/KotlinVersion$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }
}
