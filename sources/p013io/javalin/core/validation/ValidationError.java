package p013io.javalin.core.validation;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import org.quartz.jobs.p027ee.ejb.EJBInvokerJob;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* compiled from: BaseValidator.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��*\n\u0002\u0018\u0002\n��\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018��*\u0004\b��\u0010\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003J=\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028��0��2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006¢\u0006\b\n��\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n��\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, m373d2 = {"Lio/javalin/core/validation/ValidationError;", "T", "", SendMailJob.PROP_MESSAGE, "", EJBInvokerJob.EJB_ARGS_KEY, "", "value", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Object;)V", "getArgs", "()Ljava/util/Map;", "getMessage", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", Printer.TO_STRING, "javalin"})
/* renamed from: io.javalin.core.validation.ValidationError */
/* loaded from: grasscutter.jar:io/javalin/core/validation/ValidationError.class */
public final class ValidationError<T> {
    @NotNull
    private final String message;
    @NotNull
    private final Map<String, Object> args;
    @Nullable
    private Object value;

    @NotNull
    public final String component1() {
        return this.message;
    }

    @NotNull
    public final Map<String, Object> component2() {
        return this.args;
    }

    @Nullable
    public final Object component3() {
        return this.value;
    }

    @NotNull
    public final ValidationError<T> copy(@NotNull String message, @NotNull Map<String, ? extends Object> map, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        Intrinsics.checkNotNullParameter(map, EJBInvokerJob.EJB_ARGS_KEY);
        return new ValidationError<>(message, map, value);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.javalin.core.validation.ValidationError */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ValidationError copy$default(ValidationError validationError, String str, Map map, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = validationError.message;
        }
        if ((i & 2) != 0) {
            map = validationError.args;
        }
        if ((i & 4) != 0) {
            obj = validationError.value;
        }
        return validationError.copy(str, map, obj);
    }

    @NotNull
    public String toString() {
        return "ValidationError(message=" + this.message + ", args=" + this.args + ", value=" + this.value + ')';
    }

    public int hashCode() {
        return (((this.message.hashCode() * 31) + this.args.hashCode()) * 31) + (this.value == null ? 0 : this.value.hashCode());
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ValidationError)) {
            return false;
        }
        ValidationError validationError = (ValidationError) other;
        return Intrinsics.areEqual(this.message, validationError.message) && Intrinsics.areEqual(this.args, validationError.args) && Intrinsics.areEqual(this.value, validationError.value);
    }

    public ValidationError(@NotNull String message, @NotNull Map<String, ? extends Object> map, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(message, SendMailJob.PROP_MESSAGE);
        Intrinsics.checkNotNullParameter(map, EJBInvokerJob.EJB_ARGS_KEY);
        this.message = message;
        this.args = map;
        this.value = value;
    }

    public /* synthetic */ ValidationError(String str, Map map, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? null : obj);
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final Map<String, Object> getArgs() {
        return this.args;
    }

    @Nullable
    public final Object getValue() {
        return this.value;
    }

    public final void setValue(@Nullable Object obj) {
        this.value = obj;
    }
}
