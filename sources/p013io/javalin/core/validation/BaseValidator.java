package p013io.javalin.core.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.reader.LineReader;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;
import p013io.javalin.plugin.json.JsonMapper;

/* compiled from: BaseValidator.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��b\n\u0002\u0018\u0002\n��\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018��*\u0004\b��\u0010\u00012\u00020\u0002B3\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028��0\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB'\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00018��\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028��\u0018\u00010\r¢\u0006\u0002\u0010\u000eJF\u0010%\u001a\b\u0012\u0004\u0012\u00028��0��2\u0006\u0010\u0007\u001a\u00020\u00042 \u0010&\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00018��\u0012\u0004\u0012\u00020(0'j\n\u0012\u0006\u0012\u0004\u0018\u00018��`)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028��0\u0012H\u0004J@\u0010%\u001a\b\u0012\u0004\u0012\u00028��0��2\u0006\u0010\u0007\u001a\u00020\u00042 \u0010&\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00018��\u0012\u0004\u0012\u00020(0'j\n\u0012\u0006\u0012\u0004\u0018\u00018��`)2\u0006\u0010*\u001a\u00020\u0004H\u0004J\u001e\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028��0\u00120\u00110\u0010J\u000f\u0010+\u001a\u0004\u0018\u00018��H\u0016¢\u0006\u0002\u0010!J?\u0010,\u001a\u0004\u0018\u00018��2.\u0010-\u001a*\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00120\u00110\u0010\u0012\b\u0012\u00060.j\u0002`/0'H\u0016¢\u0006\u0002\u00100R3\u0010\u000f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028��0\u00120\u00110\u00108BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028��0\u001b0\u001aX\u0004¢\u0006\b\n��\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00028��\u0018\u00010\rX\u0004¢\u0006\b\n��\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u000b\u001a\u0004\u0018\u00018��X\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00061"}, m373d2 = {"Lio/javalin/core/validation/BaseValidator;", "T", "", "stringValue", "", "clazz", "Ljava/lang/Class;", "fieldName", "jsonMapper", "Lio/javalin/plugin/json/JsonMapper;", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Lio/javalin/plugin/json/JsonMapper;)V", "typedValue", "stringSource", "Lio/javalin/core/validation/StringSource;", "(Ljava/lang/String;Ljava/lang/Object;Lio/javalin/core/validation/StringSource;)V", LineReader.ERRORS, "", "", "Lio/javalin/core/validation/ValidationError;", "getErrors", "()Ljava/util/Map;", "errors$delegate", "Lkotlin/Lazy;", "getFieldName", "()Ljava/lang/String;", "rules", "", "Lio/javalin/core/validation/Rule;", "getRules$javalin", "()Ljava/util/List;", "getStringSource", "()Lio/javalin/core/validation/StringSource;", "getTypedValue", "()Ljava/lang/Object;", "setTypedValue", "(Ljava/lang/Object;)V", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_DESCRIPTOR, "addRule", "check", "Lkotlin/Function1;", "", "Lio/javalin/core/validation/Check;", "error", BeanUtil.PREFIX_GETTER_GET, "getOrThrow", "exceptionFunction", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "javalin"})
/* renamed from: io.javalin.core.validation.BaseValidator */
/* loaded from: grasscutter.jar:io/javalin/core/validation/BaseValidator.class */
public class BaseValidator<T> {
    @NotNull
    private final String fieldName;
    @Nullable
    private T typedValue;
    @Nullable
    private final StringSource<T> stringSource;
    @NotNull
    private final List<Rule<T>> rules;
    @NotNull
    private final Lazy errors$delegate;

    public BaseValidator(@NotNull String fieldName, @Nullable T t, @Nullable StringSource<T> stringSource) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        this.fieldName = fieldName;
        this.typedValue = t;
        this.stringSource = stringSource;
        this.rules = new ArrayList();
        this.errors$delegate = LazyKt.lazy(new Function0<Map<String, ? extends List<? extends ValidationError<T>>>>(this) { // from class: io.javalin.core.validation.BaseValidator$errors$2
            final /* synthetic */ BaseValidator<T> this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = r4;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
                jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:6:0x0014
                	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
                	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
                */
            @Override // kotlin.jvm.functions.Function0
            @org.jetbrains.annotations.NotNull
            public final java.util.Map<java.lang.String, java.util.List<p013io.javalin.core.validation.ValidationError<T>>> invoke() {
                /*
                // Method dump skipped, instructions count: 786
                */
                throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.core.validation.BaseValidator$errors$2.invoke():java.util.Map");
            }

            /* renamed from: invoke$lambda-3$lambda-1  reason: not valid java name */
            private static final List m5792invoke$lambda3$lambda1(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new ArrayList();
            }
        });
    }

    @NotNull
    public final String getFieldName() {
        return this.fieldName;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final T getTypedValue() {
        return this.typedValue;
    }

    /* access modifiers changed from: protected */
    public final void setTypedValue(@Nullable T t) {
        this.typedValue = t;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final StringSource<T> getStringSource() {
        return this.stringSource;
    }

    @NotNull
    public final List<Rule<T>> getRules$javalin() {
        return this.rules;
    }

    public /* synthetic */ BaseValidator(String str, Class cls, String str2, JsonMapper jsonMapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, cls, str2, (i & 8) != 0 ? null : jsonMapper);
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    public BaseValidator(@Nullable String stringValue, @NotNull Class<T> cls, @NotNull String fieldName, @Nullable JsonMapper jsonMapper) {
        this(fieldName, null, new StringSource(stringValue, cls, jsonMapper));
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    }

    private final Map<String, List<ValidationError<T>>> getErrors() {
        return (Map) this.errors$delegate.getValue();
    }

    @NotNull
    protected final BaseValidator<T> addRule(@NotNull String fieldName, @NotNull Function1<? super T, Boolean> function1, @NotNull String error) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(function1, "check");
        Intrinsics.checkNotNullParameter(error, "error");
        this.rules.add(new Rule<>(fieldName, function1, new ValidationError(error, null, null, 6, null)));
        return this;
    }

    @NotNull
    protected final BaseValidator<T> addRule(@NotNull String fieldName, @NotNull Function1<? super T, Boolean> function1, @NotNull ValidationError<T> validationError) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(function1, "check");
        Intrinsics.checkNotNullParameter(validationError, "error");
        this.rules.add(new Rule<>(fieldName, function1, validationError));
        return this;
    }

    @Nullable
    public T get() {
        return getOrThrow(BaseValidator$get$1.INSTANCE);
    }

    @Nullable
    public T getOrThrow(@NotNull Function1<? super Map<String, ? extends List<ValidationError<Object>>>, ? extends Exception> function1) {
        Intrinsics.checkNotNullParameter(function1, "exceptionFunction");
        if (getErrors().isEmpty()) {
            return this.typedValue;
        }
        throw ((Throwable) function1.invoke(getErrors()));
    }

    @NotNull
    public final Map<String, List<ValidationError<T>>> errors() {
        return getErrors();
    }
}
