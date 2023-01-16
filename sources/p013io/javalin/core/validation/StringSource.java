package p013io.javalin.core.validation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p013io.javalin.plugin.json.JsonMapper;

/* compiled from: BaseValidator.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��0\n\u0002\u0018\u0002\n��\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018��*\u0004\b��\u0010\u00012\u00020\u0002B)\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028��0\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028��0\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028��0��2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028��0\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028��0\u0006¢\u0006\b\n��\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n��\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n��\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, m373d2 = {"Lio/javalin/core/validation/StringSource;", "T", "", "stringValue", "", "clazz", "Ljava/lang/Class;", "jsonMapper", "Lio/javalin/plugin/json/JsonMapper;", "(Ljava/lang/String;Ljava/lang/Class;Lio/javalin/plugin/json/JsonMapper;)V", "getClazz", "()Ljava/lang/Class;", "getJsonMapper", "()Lio/javalin/plugin/json/JsonMapper;", "getStringValue", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", Printer.TO_STRING, "javalin"})
/* renamed from: io.javalin.core.validation.StringSource */
/* loaded from: grasscutter.jar:io/javalin/core/validation/StringSource.class */
public final class StringSource<T> {
    @Nullable
    private final String stringValue;
    @NotNull
    private final Class<T> clazz;
    @Nullable
    private final JsonMapper jsonMapper;

    @Nullable
    public final String component1() {
        return this.stringValue;
    }

    @NotNull
    public final Class<T> component2() {
        return this.clazz;
    }

    @Nullable
    public final JsonMapper component3() {
        return this.jsonMapper;
    }

    @NotNull
    public final StringSource<T> copy(@Nullable String stringValue, @NotNull Class<T> cls, @Nullable JsonMapper jsonMapper) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return new StringSource<>(stringValue, cls, jsonMapper);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.javalin.core.validation.StringSource */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StringSource copy$default(StringSource stringSource, String str, Class cls, JsonMapper jsonMapper, int i, Object obj) {
        if ((i & 1) != 0) {
            str = stringSource.stringValue;
        }
        if ((i & 2) != 0) {
            cls = stringSource.clazz;
        }
        if ((i & 4) != 0) {
            jsonMapper = stringSource.jsonMapper;
        }
        return stringSource.copy(str, cls, jsonMapper);
    }

    @NotNull
    public String toString() {
        return "StringSource(stringValue=" + ((Object) this.stringValue) + ", clazz=" + this.clazz + ", jsonMapper=" + this.jsonMapper + ')';
    }

    public int hashCode() {
        return ((((this.stringValue == null ? 0 : this.stringValue.hashCode()) * 31) + this.clazz.hashCode()) * 31) + (this.jsonMapper == null ? 0 : this.jsonMapper.hashCode());
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StringSource)) {
            return false;
        }
        StringSource stringSource = (StringSource) other;
        return Intrinsics.areEqual(this.stringValue, stringSource.stringValue) && Intrinsics.areEqual(this.clazz, stringSource.clazz) && Intrinsics.areEqual(this.jsonMapper, stringSource.jsonMapper);
    }

    public StringSource(@Nullable String stringValue, @NotNull Class<T> cls, @Nullable JsonMapper jsonMapper) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.stringValue = stringValue;
        this.clazz = cls;
        this.jsonMapper = jsonMapper;
    }

    public /* synthetic */ StringSource(String str, Class cls, JsonMapper jsonMapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, cls, (i & 4) != 0 ? null : jsonMapper);
    }

    @Nullable
    public final String getStringValue() {
        return this.stringValue;
    }

    @NotNull
    public final Class<T> getClazz() {
        return this.clazz;
    }

    @Nullable
    public final JsonMapper getJsonMapper() {
        return this.jsonMapper;
    }
}
