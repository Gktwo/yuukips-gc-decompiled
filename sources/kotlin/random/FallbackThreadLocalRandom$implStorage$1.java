package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformRandom.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0011\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001��\b\n\u0018��2\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, m373d2 = {"kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Ljava/lang/ThreadLocal;", "Ljava/util/Random;", "initialValue", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/random/FallbackThreadLocalRandom$implStorage$1.class */
public final class FallbackThreadLocalRandom$implStorage$1 extends ThreadLocal<Random> {
    /* access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    @NotNull
    public Random initialValue() {
        return new Random();
    }
}
