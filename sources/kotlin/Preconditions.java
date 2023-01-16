package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.quartz.jobs.p027ee.mail.SendMailJob;

@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��\"\n��\n\u0002\u0010\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0004\u001a\u001c\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u0002\b\n\u0006\b��\u001a\u0002\u0010\u0001\u001a-\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001��\u0002\b\n\u0006\b��\u001a\u0002\u0010\u0001\u001a/\u0010\u0007\u001a\u0002H\b\"\b\b��\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\bH\b\u0002\n\n\b\b��\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\t\u001a@\u0010\u0007\u001a\u0002H\b\"\b\b��\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001��\u0002\n\n\b\b��\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006H\b\u001a\u001c\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u0002\b\n\u0006\b��\u001a\u0002\u0010\u0001\u001a-\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001��\u0002\b\n\u0006\b��\u001a\u0002\u0010\u0001\u001a/\u0010\u000f\u001a\u0002H\b\"\b\b��\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\bH\b\u0002\n\n\b\b��\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\t\u001a@\u0010\u000f\u001a\u0002H\b\"\b\b��\u0010\b*\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u0001H\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001��\u0002\n\n\b\b��\u001a\u0004\b\u0003\u0010\u0001¢\u0006\u0002\u0010\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0010"}, m373d2 = {"check", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "checkNotNull", "T", "(Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "error", "", SendMailJob.PROP_MESSAGE, "require", "requireNotNull", "kotlin-stdlib"}, m368xs = "kotlin/PreconditionsKt")
/* renamed from: kotlin.PreconditionsKt__PreconditionsKt */
/* loaded from: grasscutter.jar:kotlin/PreconditionsKt__PreconditionsKt.class */
class Preconditions extends AssertionsJVM {
    @InlineOnly
    private static final void require(boolean value) {
        if (!value) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    @InlineOnly
    private static final void require(boolean value, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (!value) {
            throw new IllegalArgumentException(function0.invoke().toString());
        }
    }

    @InlineOnly
    private static final <T> T requireNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @InlineOnly
    private static final <T> T requireNotNull(T t, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(function0.invoke().toString());
    }

    @InlineOnly
    private static final void check(boolean value) {
        if (!value) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @InlineOnly
    private static final void check(boolean value, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (!value) {
            throw new IllegalStateException(function0.invoke().toString());
        }
    }

    @InlineOnly
    private static final <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @InlineOnly
    private static final <T> T checkNotNull(T t, Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (t != null) {
            return t;
        }
        throw new IllegalStateException(function0.invoke().toString());
    }

    @InlineOnly
    private static final Void error(Object message) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        throw new IllegalStateException(message.toString());
    }
}
