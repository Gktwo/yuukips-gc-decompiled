package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: XorWowRandom.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u000e\b��\u0018�� \u00122\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0012B\u0017\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007B7\b��\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016R\u000e\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u0002\n��R\u000e\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u0002\n��¨\u0006\u0013"}, m373d2 = {"Lkotlin/random/XorWowRandom;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "seed1", "", "seed2", "(II)V", "x", "y", "z", "w", "v", "addend", "(IIIIII)V", "nextBits", "bitCount", "nextInt", "Companion", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/random/XorWowRandom.class */
public final class XorWowRandom extends Random implements Serializable {
    @NotNull
    private static final Companion Companion = new Companion(null);

    /* renamed from: x */
    private int f3054x;

    /* renamed from: y */
    private int f3055y;

    /* renamed from: z */
    private int f3056z;

    /* renamed from: w */
    private int f3057w;

    /* renamed from: v */
    private int f3058v;
    private int addend;
    @Deprecated
    private static final long serialVersionUID = 0;

    public XorWowRandom(int x, int y, int z, int w, int v, int addend) {
        this.f3054x = x;
        this.f3055y = y;
        this.f3056z = z;
        this.f3057w = w;
        this.f3058v = v;
        this.addend = addend;
        if (!(((((this.f3054x | this.f3055y) | this.f3056z) | this.f3057w) | this.f3058v) != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i = 0; i < 64; i++) {
            nextInt();
        }
    }

    public XorWowRandom(int seed1, int seed2) {
        this(seed1, seed2, 0, 0, seed1 ^ -1, (seed1 << 10) ^ (seed2 >>> 4));
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int t = this.f3054x;
        int t2 = t ^ (t >>> 2);
        this.f3054x = this.f3055y;
        this.f3055y = this.f3056z;
        this.f3056z = this.f3057w;
        int v0 = this.f3058v;
        this.f3057w = v0;
        int t3 = ((t2 ^ (t2 << 1)) ^ v0) ^ (v0 << 4);
        this.f3058v = t3;
        this.addend += 362437;
        return t3 + this.addend;
    }

    @Override // kotlin.random.Random
    public int nextBits(int bitCount) {
        return RandomKt.takeUpperBits(nextInt(), bitCount);
    }

    /* compiled from: XorWowRandom.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\t\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\u0005"}, m373d2 = {"Lkotlin/random/XorWowRandom$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/random/XorWowRandom$Companion.class */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }
}
