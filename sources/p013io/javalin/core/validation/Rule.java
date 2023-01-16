package p013io.javalin.core.validation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: BaseValidator.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��0\n\u0002\u0018\u0002\n��\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018��*\u0004\b��\u0010\u00012\u00020\u0002B=\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012 \u0010\u0005\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00018��\u0012\u0004\u0012\u00020\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00018��`\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028��0\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0004HÆ\u0003J#\u0010\u0013\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00018��\u0012\u0004\u0012\u00020\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00018��`\bHÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028��0\nHÆ\u0003JM\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028��0��2\b\b\u0002\u0010\u0003\u001a\u00020\u00042\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00018��\u0012\u0004\u0012\u00020\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00018��`\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00028��0\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R+\u0010\u0005\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00018��\u0012\u0004\u0012\u00020\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00018��`\b¢\u0006\b\n��\u001a\u0004\b\f\u0010\rR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028��0\n¢\u0006\b\n��\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, m373d2 = {"Lio/javalin/core/validation/Rule;", "T", "", "fieldName", "", "check", "Lkotlin/Function1;", "", "Lio/javalin/core/validation/Check;", "error", "Lio/javalin/core/validation/ValidationError;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lio/javalin/core/validation/ValidationError;)V", "getCheck", "()Lkotlin/jvm/functions/Function1;", "getError", "()Lio/javalin/core/validation/ValidationError;", "getFieldName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", Printer.TO_STRING, "javalin"})
/* renamed from: io.javalin.core.validation.Rule */
/* loaded from: grasscutter.jar:io/javalin/core/validation/Rule.class */
public final class Rule<T> {
    @NotNull
    private final String fieldName;
    @NotNull
    private final Function1<T, Boolean> check;
    @NotNull
    private final ValidationError<T> error;

    @NotNull
    public final String component1() {
        return this.fieldName;
    }

    @NotNull
    public final Function1<T, Boolean> component2() {
        return this.check;
    }

    @NotNull
    public final ValidationError<T> component3() {
        return this.error;
    }

    @NotNull
    public final Rule<T> copy(@NotNull String fieldName, @NotNull Function1<? super T, Boolean> function1, @NotNull ValidationError<T> validationError) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(function1, "check");
        Intrinsics.checkNotNullParameter(validationError, "error");
        return new Rule<>(fieldName, function1, validationError);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.javalin.core.validation.Rule */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Rule copy$default(Rule rule, String str, Function1 function1, ValidationError validationError, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rule.fieldName;
        }
        if ((i & 2) != 0) {
            function1 = rule.check;
        }
        if ((i & 4) != 0) {
            validationError = rule.error;
        }
        return rule.copy(str, function1, validationError);
    }

    @NotNull
    public String toString() {
        return "Rule(fieldName=" + this.fieldName + ", check=" + this.check + ", error=" + this.error + ')';
    }

    public int hashCode() {
        return (((this.fieldName.hashCode() * 31) + this.check.hashCode()) * 31) + this.error.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Rule)) {
            return false;
        }
        Rule rule = (Rule) other;
        return Intrinsics.areEqual(this.fieldName, rule.fieldName) && Intrinsics.areEqual(this.check, rule.check) && Intrinsics.areEqual(this.error, rule.error);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public Rule(@NotNull String fieldName, @NotNull Function1<? super T, Boolean> function1, @NotNull ValidationError<T> validationError) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(function1, "check");
        Intrinsics.checkNotNullParameter(validationError, "error");
        this.fieldName = fieldName;
        this.check = function1;
        this.error = validationError;
    }

    @NotNull
    public final String getFieldName() {
        return this.fieldName;
    }

    @NotNull
    public final Function1<T, Boolean> getCheck() {
        return this.check;
    }

    @NotNull
    public final ValidationError<T> getError() {
        return this.error;
    }
}
