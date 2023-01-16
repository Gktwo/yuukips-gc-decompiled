package okhttp3;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Tuples;
import kotlin.collections.CollectionsKt;
import kotlin.internal.progressionUtil;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.dates;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: Headers.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��f\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010��\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\"\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\u0018�� '2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002&'B\u0015\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010\u0017\u001a\u00020\tH\u0016J\u001b\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0019H\u0002J\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u001fJ\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!J\b\u0010#\u001a\u00020\u0003H\u0016J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\"2\u0006\u0010\u0012\u001a\u00020\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006("}, m373d2 = {"Lokhttp3/Headers;", "", "Lkotlin/Pair;", "", "namesAndValues", "", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "size", "", "()I", "byteCount", "", "equals", "", "other", "", BeanUtil.PREFIX_GETTER_GET, "name", "getDate", "Ljava/util/Date;", "getInstant", "Ljava/time/Instant;", "hashCode", "iterator", "", "index", "names", "", "newBuilder", "Lokhttp3/Headers$Builder;", "-deprecated_size", "toMultimap", "", "", Printer.TO_STRING, "value", "values", "Builder", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/Headers.class */
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String[] namesAndValues;

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    /* renamed from: of */
    public static final Headers m56of(@NotNull String... namesAndValues) {
        return Companion.m54of(namesAndValues);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    /* renamed from: of */
    public static final Headers m57of(@NotNull Map<String, String> map) {
        return Companion.m55of(map);
    }

    public /* synthetic */ Headers(String[] namesAndValues, DefaultConstructorMarker $constructor_marker) {
        this(namesAndValues);
    }

    private Headers(String[] namesAndValues) {
        this.namesAndValues = namesAndValues;
    }

    @Nullable
    public final String get(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return Companion.get(this.namesAndValues, name);
    }

    @Nullable
    public final Date getDate(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String str = get(name);
        if (str == null) {
            return null;
        }
        return dates.toHttpDateOrNull(str);
    }

    @IgnoreJRERequirement
    @Nullable
    public final Instant getInstant(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Date value = getDate(name);
        if (value == null) {
            return null;
        }
        return value.toInstant();
    }

    @JvmName(name = "size")
    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m9203deprecated_size() {
        return size();
    }

    @NotNull
    public final String name(int index) {
        return this.namesAndValues[index * 2];
    }

    @NotNull
    public final String value(int index) {
        return this.namesAndValues[(index * 2) + 1];
    }

    @NotNull
    public final Set<String> names() {
        TreeSet result = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int i = 0;
        int size = size();
        while (i < size) {
            i++;
            result.add(name(i));
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(result);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(result)");
        return unmodifiableSet;
    }

    @NotNull
    public final List<String> values(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List result = null;
        int i = 0;
        int size = size();
        while (i < size) {
            i++;
            if (StringsKt.equals(name, name(i), true)) {
                if (result == null) {
                    result = new ArrayList(2);
                }
                result.add(value(i));
            }
        }
        if (result == null) {
            return CollectionsKt.emptyList();
        }
        List<String> unmodifiableList = Collections.unmodifiableList(result);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return unmodifiableList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v13, types: [long] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long byteCount() {
        /*
            r5 = this;
            r0 = r5
            java.lang.String[] r0 = r0.namesAndValues
            int r0 = r0.length
            r1 = 2
            int r0 = r0 * r1
            long r0 = (long) r0
            r6 = r0
            r0 = 0
            r8 = r0
            r0 = r5
            java.lang.String[] r0 = r0.namesAndValues
            int r0 = r0.length
            r9 = r0
        L_0x0012:
            r0 = r8
            r1 = r9
            if (r0 >= r1) goto L_0x002f
            r0 = r8
            r10 = r0
            int r8 = r8 + 1
            r0 = r6
            r1 = r5
            java.lang.String[] r1 = r1.namesAndValues
            r2 = r10
            r1 = r1[r2]
            int r1 = r1.length()
            long r1 = (long) r1
            long r0 = r0 + r1
            r6 = r0
            goto L_0x0012
        L_0x002f:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Headers.byteCount():long");
    }

    /* Return type fixed from 'java.util.Iterator<kotlin.Pair<java.lang.String, java.lang.String>>' to match base method */
    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = Tuples.m366to(name(i), value(i));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    @NotNull
    public final Builder newBuilder() {
        Builder result = new Builder();
        CollectionsKt.addAll(result.getNamesAndValues$okhttp(), this.namesAndValues);
        return result;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object other) {
        return (other instanceof Headers) && Arrays.equals(this.namesAndValues, ((Headers) other).namesAndValues);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder $this$toString_u24lambda_u2d0 = new StringBuilder();
        int i = 0;
        int size = size();
        while (i < size) {
            i++;
            String name = name(i);
            String value = value(i);
            $this$toString_u24lambda_u2d0.append(name);
            $this$toString_u24lambda_u2d0.append(": ");
            $this$toString_u24lambda_u2d0.append(Util.isSensitiveHeader(name) ? "██" : value);
            $this$toString_u24lambda_u2d0.append("\n");
        }
        String sb = $this$toString_u24lambda_u2d0.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    @NotNull
    public final Map<String, List<String>> toMultimap() {
        TreeMap result = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int i = 0;
        int size = size();
        while (i < size) {
            i++;
            String name = name(i);
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String name2 = name.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(name2, "this as java.lang.String).toLowerCase(locale)");
            ArrayList values = (List) result.get(name2);
            if (values == null) {
                values = new ArrayList(2);
                result.put(name2, values);
            }
            values.add(value(i));
        }
        return result;
    }

    /* compiled from: Headers.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��,\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0005J\u0018\u0010\b\u001a\u00020��2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\b\u001a\u00020��2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rJ\u0016\u0010\b\u001a\u00020��2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020��2\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010\u0011\u001a\u00020��2\u0006\u0010\t\u001a\u00020\u0005H��¢\u0006\u0002\b\u0012J\u001d\u0010\u0011\u001a\u00020��2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H��¢\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001a\u00020��2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0010J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u000e\u0010\u0016\u001a\u00020��2\u0006\u0010\n\u001a\u00020\u0005J\u0019\u0010\u0017\u001a\u00020��2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0019\u0010\u0017\u001a\u00020��2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rH\u0002J\u0019\u0010\u0017\u001a\u00020��2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, m373d2 = {"Lokhttp3/Headers$Builder;", "", "()V", "namesAndValues", "", "", "getNamesAndValues$okhttp", "()Ljava/util/List;", BeanUtil.PREFIX_ADDER, "line", "name", "value", "Ljava/time/Instant;", "Ljava/util/Date;", "addAll", "headers", "Lokhttp3/Headers;", "addLenient", "addLenient$okhttp", "addUnsafeNonAscii", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, BeanUtil.PREFIX_GETTER_GET, "removeAll", "set", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/Headers$Builder.class */
    public static final class Builder {
        @NotNull
        private final List<String> namesAndValues = new ArrayList(20);

        @NotNull
        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String line) {
            Intrinsics.checkNotNullParameter(line, "line");
            Builder $this$addLenient_u24lambda_u2d0 = this;
            int index = StringsKt.indexOf$default((CharSequence) line, ':', 1, false, 4, (Object) null);
            if (index != -1) {
                String substring = line.substring(0, index);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring2 = line.substring(index + 1);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                $this$addLenient_u24lambda_u2d0.addLenient$okhttp(substring, substring2);
            } else if (line.charAt(0) == ':') {
                String substring3 = line.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                $this$addLenient_u24lambda_u2d0.addLenient$okhttp("", substring3);
            } else {
                $this$addLenient_u24lambda_u2d0.addLenient$okhttp("", line);
            }
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String line) {
            Intrinsics.checkNotNullParameter(line, "line");
            Builder $this$add_u24lambda_u2d2 = this;
            int index = StringsKt.indexOf$default((CharSequence) line, ':', 0, false, 6, (Object) null);
            if (!(index != -1)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected header: ", line).toString());
            }
            String substring = line.substring(0, index);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String obj = StringsKt.trim((CharSequence) substring).toString();
            String substring2 = line.substring(index + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            $this$add_u24lambda_u2d2.add(obj, substring2);
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Headers.Companion.checkName(name);
            Headers.Companion.checkValue(value, name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Builder addUnsafeNonAscii(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Headers.Companion.checkName(name);
            addLenient$okhttp(name, value);
            return this;
        }

        @NotNull
        public final Builder addAll(@NotNull Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            Builder $this$addAll_u24lambda_u2d5 = this;
            int i = 0;
            int size = headers.size();
            while (i < size) {
                i++;
                $this$addAll_u24lambda_u2d5.addLenient$okhttp(headers.name(i), headers.value(i));
            }
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String name, @NotNull Date value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            add(name, dates.toHttpDateString(value));
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder add(@NotNull String name, @NotNull Instant value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            add(name, new Date(value.toEpochMilli()));
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull Date value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            set(name, dates.toHttpDateString(value));
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder set(@NotNull String name, @NotNull Instant value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return set(name, new Date(value.toEpochMilli()));
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Builder $this$addLenient_u24lambda_u2d10 = this;
            $this$addLenient_u24lambda_u2d10.getNamesAndValues$okhttp().add(name);
            $this$addLenient_u24lambda_u2d10.getNamesAndValues$okhttp().add(StringsKt.trim((CharSequence) value).toString());
            return this;
        }

        @NotNull
        public final Builder removeAll(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            Builder $this$removeAll_u24lambda_u2d11 = this;
            int i = 0;
            while (i < $this$removeAll_u24lambda_u2d11.getNamesAndValues$okhttp().size()) {
                if (StringsKt.equals(name, $this$removeAll_u24lambda_u2d11.getNamesAndValues$okhttp().get(i), true)) {
                    $this$removeAll_u24lambda_u2d11.getNamesAndValues$okhttp().remove(i);
                    $this$removeAll_u24lambda_u2d11.getNamesAndValues$okhttp().remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String name, @NotNull String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Builder $this$set_u24lambda_u2d12 = this;
            Headers.Companion.checkName(name);
            Headers.Companion.checkValue(value, name);
            $this$set_u24lambda_u2d12.removeAll(name);
            $this$set_u24lambda_u2d12.addLenient$okhttp(name, value);
            return this;
        }

        @Nullable
        public final String get(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            int size = this.namesAndValues.size() - 2;
            int i = size;
            int progressionLastElement = progressionUtil.getProgressionLastElement(size, 0, -2);
            if (progressionLastElement > i) {
                return null;
            }
            do {
                i -= 2;
                if (StringsKt.equals(name, this.namesAndValues.get(i), true)) {
                    return this.namesAndValues.get(i + 1);
                }
            } while (i != progressionLastElement);
            return null;
        }

        @NotNull
        public final Headers build() {
            Object[] array = this.namesAndValues.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    /* compiled from: Headers.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J%\u0010\t\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007¢\u0006\u0002\b\u0011J\u001d\u0010\u0014\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007¢\u0006\u0002\b\u000f¨\u0006\u0015"}, m373d2 = {"Lokhttp3/Headers$Companion;", "", "()V", "checkName", "", "name", "", "checkValue", "value", BeanUtil.PREFIX_GETTER_GET, "namesAndValues", "", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "headersOf", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "-deprecated_of", "headers", "", "toHeaders", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/Headers$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final String get(String[] namesAndValues, String name) {
            int length = namesAndValues.length - 2;
            int i = length;
            int progressionLastElement = progressionUtil.getProgressionLastElement(length, 0, -2);
            if (progressionLastElement > i) {
                return null;
            }
            do {
                i -= 2;
                if (StringsKt.equals(name, namesAndValues[i], true)) {
                    return namesAndValues[i + 1];
                }
            } while (i != progressionLastElement);
            return null;
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        /* renamed from: of */
        public final Headers m54of(@NotNull String... namesAndValues) {
            Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
            if (!(namesAndValues.length % 2 == 0)) {
                throw new IllegalArgumentException("Expected alternating header names and values".toString());
            }
            String[] namesAndValues2 = (String[]) namesAndValues.clone();
            int i = 0;
            int length = namesAndValues2.length;
            while (i < length) {
                i++;
                if (!(namesAndValues2[i] != null)) {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
                namesAndValues2[i] = StringsKt.trim((CharSequence) namesAndValues2[i]).toString();
            }
            int i2 = 0;
            int progressionLastElement = progressionUtil.getProgressionLastElement(0, namesAndValues2.length - 1, 2);
            if (0 > progressionLastElement) {
                return new Headers(namesAndValues2, null);
            }
            do {
                i2 += 2;
                String name = namesAndValues2[i2];
                String value = namesAndValues2[i2 + 1];
                checkName(name);
                checkValue(value, name);
            } while (i2 != progressionLastElement);
            return new Headers(namesAndValues2, null);
        }

        @Deprecated(message = "function name changed", replaceWith = @ReplaceWith(expression = "headersOf(*namesAndValues)", imports = {}), level = DeprecationLevel.ERROR)
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m9205deprecated_of(@NotNull String... namesAndValues) {
            Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
            return m54of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        /* renamed from: of */
        public final Headers m55of(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "<this>");
            String[] namesAndValues = new String[map.size() * 2];
            int i = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String k = entry.getKey();
                String v = entry.getValue();
                String name = StringsKt.trim((CharSequence) k).toString();
                String value = StringsKt.trim((CharSequence) v).toString();
                checkName(name);
                checkValue(value, name);
                namesAndValues[i] = name;
                namesAndValues[i + 1] = value;
                i += 2;
            }
            return new Headers(namesAndValues, null);
        }

        @Deprecated(message = "function moved to extension", replaceWith = @ReplaceWith(expression = "headers.toHeaders()", imports = {}), level = DeprecationLevel.ERROR)
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of  reason: not valid java name */
        public final Headers m9206deprecated_of(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "headers");
            return m55of(map);
        }

        /* access modifiers changed from: private */
        public final void checkName(String name) {
            boolean z;
            if (!(name.length() > 0)) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            int i = 0;
            int length = name.length();
            while (i < length) {
                i++;
                char c = name.charAt(i);
                if ('!' > c) {
                    z = false;
                    continue;
                } else if (c < 127) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(c), Integer.valueOf(i), name).toString());
                }
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void checkValue(java.lang.String r6, java.lang.String r7) {
            /*
                r5 = this;
                r0 = 0
                r8 = r0
                r0 = r6
                int r0 = r0.length()
                r9 = r0
            L_0x0008:
                r0 = r8
                r1 = r9
                if (r0 >= r1) goto L_0x0090
                r0 = r8
                r10 = r0
                int r8 = r8 + 1
                r0 = r6
                r1 = r10
                char r0 = r0.charAt(r1)
                r11 = r0
                r0 = r11
                r1 = 9
                if (r0 == r1) goto L_0x003d
                r0 = 32
                r1 = r11
                if (r0 > r1) goto L_0x0039
                r0 = r11
                r1 = 127(0x7f, float:1.78E-43)
                if (r0 >= r1) goto L_0x0035
                r0 = 1
                goto L_0x003a
            L_0x0035:
                r0 = 0
                goto L_0x003a
            L_0x0039:
                r0 = 0
            L_0x003a:
                if (r0 == 0) goto L_0x0041
            L_0x003d:
                r0 = 1
                goto L_0x0042
            L_0x0041:
                r0 = 0
            L_0x0042:
                if (r0 != 0) goto L_0x0008
                r0 = 0
                r12 = r0
                java.lang.String r0 = "Unexpected char %#04x at %d in %s value"
                r1 = 3
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r13 = r1
                r1 = r13
                r2 = 0
                r3 = r11
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r1[r2] = r3
                r1 = r13
                r2 = 1
                r3 = r10
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r1[r2] = r3
                r1 = r13
                r2 = 2
                r3 = r7
                r1[r2] = r3
                r1 = r13
                java.lang.String r0 = okhttp3.internal.Util.format(r0, r1)
                r1 = r7
                boolean r1 = okhttp3.internal.Util.isSensitiveHeader(r1)
                if (r1 == 0) goto L_0x0078
                java.lang.String r1 = ""
                goto L_0x007e
            L_0x0078:
                java.lang.String r1 = ": "
                r2 = r6
                java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r2)
            L_0x007e:
                java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r1)
                r12 = r0
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r1 = r0
                r2 = r12
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r0
            L_0x0090:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Headers.Companion.checkValue(java.lang.String, java.lang.String):void");
        }
    }
}
