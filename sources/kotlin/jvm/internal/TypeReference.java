package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMapping;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;

/* compiled from: TypeReference.kt */
@SinceKotlin(version = "1.4")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010��\n\u0002\b\u0004\b\u0007\u0018�� )2\u00020\u0001:\u0001)B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\bH\u0002J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010'\u001a\u00020\fH\u0016J\b\u0010(\u001a\u00020\u001eH\u0016J\f\u0010\"\u001a\u00020\u001e*\u00020\u0006H\u0002R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n��\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n��\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u00020\f8��X\u0004¢\u0006\u000e\n��\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00018��X\u0004¢\u0006\u000e\n��\u0012\u0004\b\u001a\u0010\u0016\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\b\u00030\u001f8BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006*"}, m373d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "platformTypeUpperBound", "flags", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "annotations", "", "getAnnotations", "()Ljava/util/List;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getFlags$kotlin_stdlib$annotations", "()V", "getFlags$kotlin_stdlib", "()I", "()Z", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "arrayClassName", "", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "asString", "convertPrimitiveToWrapper", "equals", "other", "", "hashCode", Printer.TO_STRING, "Companion", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/jvm/internal/TypeReference.class */
public final class TypeReference implements KType {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final KClassifier classifier;
    @NotNull
    private final List<KTypeProjection> arguments;
    @Nullable
    private final KType platformTypeUpperBound;
    private final int flags;
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;

    /* compiled from: TypeReference.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48)
    /* loaded from: grasscutter.jar:kotlin/jvm/internal/TypeReference$WhenMappings.class */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void getFlags$kotlin_stdlib$annotations() {
    }

    @SinceKotlin(version = "1.6")
    public TypeReference(@NotNull KClassifier classifier, @NotNull List<KTypeProjection> list, @Nullable KType platformTypeUpperBound, int flags) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(list, "arguments");
        this.classifier = classifier;
        this.arguments = list;
        this.platformTypeUpperBound = platformTypeUpperBound;
        this.flags = flags;
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public KClassifier getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.KType
    @NotNull
    public List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    @Nullable
    public final KType getPlatformTypeUpperBound$kotlin_stdlib() {
        return this.platformTypeUpperBound;
    }

    public final int getFlags$kotlin_stdlib() {
        return this.flags;
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    public TypeReference(@NotNull KClassifier classifier, @NotNull List<KTypeProjection> list, boolean isMarkedNullable) {
        this(classifier, list, null, isMarkedNullable ? 1 : 0);
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(list, "arguments");
    }

    @Override // kotlin.reflect.KAnnotatedElement
    @NotNull
    public List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return (this.flags & 1) != 0;
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof TypeReference) && Intrinsics.areEqual(getClassifier(), ((TypeReference) other).getClassifier()) && Intrinsics.areEqual(getArguments(), ((TypeReference) other).getArguments()) && Intrinsics.areEqual(this.platformTypeUpperBound, ((TypeReference) other).platformTypeUpperBound) && this.flags == ((TypeReference) other).flags;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + Integer.valueOf(this.flags).hashCode();
    }

    @NotNull
    public String toString() {
        return asString(false) + " (Kotlin reflection is not available)";
    }

    private final String asString(boolean convertPrimitiveToWrapper) {
        String klass;
        KClassifier classifier = getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        Class javaClass = kClass != null ? JvmClassMapping.getJavaClass(kClass) : null;
        if (javaClass == null) {
            klass = getClassifier().toString();
        } else if ((this.flags & 4) != 0) {
            klass = "kotlin.Nothing";
        } else if (javaClass.isArray()) {
            klass = getArrayClassName(javaClass);
        } else {
            klass = (!convertPrimitiveToWrapper || !javaClass.isPrimitive()) ? javaClass.getName() : JvmClassMapping.getJavaObjectType((KClass) getClassifier()).getName();
        }
        String result = klass + (getArguments().isEmpty() ? "" : CollectionsKt.joinToString$default(getArguments(), ", ", "<", ">", 0, null, new Function1<KTypeProjection, CharSequence>(this) { // from class: kotlin.jvm.internal.TypeReference$asString$args$1
            final /* synthetic */ TypeReference this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            @NotNull
            public final CharSequence invoke(@NotNull KTypeProjection it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return TypeReference.access$asString(this.this$0, it);
            }
        }, 24, null)) + (isMarkedNullable() ? "?" : "");
        KType upper = this.platformTypeUpperBound;
        if (!(upper instanceof TypeReference)) {
            return result;
        }
        String renderedUpper = ((TypeReference) upper).asString(true);
        if (Intrinsics.areEqual(renderedUpper, result)) {
            return result;
        }
        return Intrinsics.areEqual(renderedUpper, new StringBuilder().append(result).append('?').toString()) ? result + '!' : '(' + result + CallerDataConverter.DEFAULT_RANGE_DELIMITER + renderedUpper + ')';
    }

    private final String getArrayClassName(Class<?> cls) {
        return Intrinsics.areEqual(cls, boolean[].class) ? "kotlin.BooleanArray" : Intrinsics.areEqual(cls, char[].class) ? "kotlin.CharArray" : Intrinsics.areEqual(cls, byte[].class) ? "kotlin.ByteArray" : Intrinsics.areEqual(cls, short[].class) ? "kotlin.ShortArray" : Intrinsics.areEqual(cls, int[].class) ? "kotlin.IntArray" : Intrinsics.areEqual(cls, float[].class) ? "kotlin.FloatArray" : Intrinsics.areEqual(cls, long[].class) ? "kotlin.LongArray" : Intrinsics.areEqual(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (r0 == null) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String asString(kotlin.reflect.KTypeProjection r4) {
        /*
            r3 = this;
            r0 = r4
            kotlin.reflect.KVariance r0 = r0.getVariance()
            if (r0 != 0) goto L_0x000a
            java.lang.String r0 = "*"
            return r0
        L_0x000a:
            r0 = r4
            kotlin.reflect.KType r0 = r0.getType()
            r6 = r0
            r0 = r6
            boolean r0 = r0 instanceof kotlin.jvm.internal.TypeReference
            if (r0 == 0) goto L_0x001d
            r0 = r6
            kotlin.jvm.internal.TypeReference r0 = (kotlin.jvm.internal.TypeReference) r0
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            r1 = r0
            if (r1 == 0) goto L_0x002a
            r1 = 1
            java.lang.String r0 = r0.asString(r1)
            r1 = r0
            if (r1 != 0) goto L_0x0032
        L_0x002a:
            r0 = r4
            kotlin.reflect.KType r0 = r0.getType()
            java.lang.String r0 = java.lang.String.valueOf(r0)
        L_0x0032:
            r5 = r0
            r0 = r4
            kotlin.reflect.KVariance r0 = r0.getVariance()
            int[] r1 = kotlin.jvm.internal.TypeReference.WhenMappings.$EnumSwitchMapping$0
            r2 = r0; r0 = r1; r1 = r2; 
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0058;
                case 2: goto L_0x005c;
                case 3: goto L_0x0072;
                default: goto L_0x0088;
            }
        L_0x0058:
            r0 = r5
            goto L_0x0090
        L_0x005c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            java.lang.String r1 = "in "
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0090
        L_0x0072:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            java.lang.String r1 = "out "
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x0090
        L_0x0088:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x0090:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.TypeReference.asString(kotlin.reflect.KTypeProjection):java.lang.String");
    }

    /* compiled from: TypeReference.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\u0007"}, m373d2 = {"Lkotlin/jvm/internal/TypeReference$Companion;", "", "()V", "IS_MARKED_NULLABLE", "", "IS_MUTABLE_COLLECTION_TYPE", "IS_NOTHING_TYPE", "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/jvm/internal/TypeReference$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }
}
