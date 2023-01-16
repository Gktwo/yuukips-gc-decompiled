package kotlin.time.jdk8;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ExperimentalTime;

@Metadata(m371mv = {1, 5, 1}, m372k = 2, m374d1 = {"��\u000e\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010��\u001a\u00020\u0001*\u00020\u0002H\bø\u0001��ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\bø\u0001��¢\u0006\u0002\u0010\u0006\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0007"}, m373d2 = {"toJavaDuration", "Ljava/time/Duration;", "Lkotlin/time/Duration;", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "toKotlinDuration", "(Ljava/time/Duration;)J", "kotlin-stdlib-jdk8"}, m370pn = "kotlin.time")
@JvmName(name = "DurationConversionsJDK8Kt")
/* renamed from: kotlin.time.jdk8.DurationConversionsJDK8Kt */
/* loaded from: grasscutter.jar:kotlin/time/jdk8/DurationConversionsJDK8Kt.class */
public final class DurationConversions {
    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    @InlineOnly
    private static final long toKotlinDuration(Duration $this$toKotlinDuration) {
        return kotlin.time.Duration.m8453plusLRDsOJo(kotlin.time.Duration.Companion.m8562secondsUwyO8pc($this$toKotlinDuration.getSeconds()), kotlin.time.Duration.Companion.m8552nanosecondsUwyO8pc($this$toKotlinDuration.getNano()));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalTime
    @InlineOnly
    /* renamed from: toJavaDuration-LRDsOJo  reason: not valid java name */
    private static final Duration m8594toJavaDurationLRDsOJo(long $this$toJavaDuration) {
        Duration ofSeconds = Duration.ofSeconds(kotlin.time.Duration.m8489getInWholeSecondsimpl($this$toJavaDuration), (long) kotlin.time.Duration.m8475getNanosecondsComponentimpl($this$toJavaDuration));
        Intrinsics.checkNotNullExpressionValue(ofSeconds, "toComponents { seconds, …, nanoseconds.toLong()) }");
        return ofSeconds;
    }
}
