package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.jvm.JvmName;

/* compiled from: Metadata.kt */
@Target({ElementType.TYPE})
@SinceKotlin(version = "1.3")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n��\n\u0002\u0010\b\n��\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0002\u0018��2\u00020\u0001B\\\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003R\u0018\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\t8\u0007¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u0018\u0010\f\u001a\u00020\tX\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0019¨\u0006\u001e"}, m373d2 = {"Lkotlin/Metadata;", "", "kind", "", "metadataVersion", "", "bytecodeVersion", "data1", "", "", "data2", "extraString", "packageName", "extraInt", "bv$annotations", "()V", "bv", "()[I", "d1", "()[Ljava/lang/String;", "d2", "xi$annotations", "xi", "()I", "xs", "()Ljava/lang/String;", "k", "mv", "pn$annotations", "pn", "kotlin-stdlib"})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(AnnotationRetention.RUNTIME)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:kotlin/Metadata.class */
public @interface Metadata {

    /* compiled from: Metadata.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48)
    /* loaded from: grasscutter.jar:kotlin/Metadata$DefaultImpls.class */
    public static final class DefaultImpls {
        @Deprecated(message = "Bytecode version had no significant use in Kotlin metadata and it will be removed in a future version.", level = DeprecationLevel.WARNING)
        public static /* synthetic */ void bv$annotations() {
        }

        @SinceKotlin(version = "1.2")
        public static /* synthetic */ void pn$annotations() {
        }

        @SinceKotlin(version = "1.1")
        public static /* synthetic */ void xi$annotations() {
        }
    }

    @JvmName(name = "k")
    /* renamed from: k */
    int m372k() default 1;

    @JvmName(name = "mv")
    /* renamed from: mv */
    int[] m371mv() default {};

    @JvmName(name = "bv")
    /* renamed from: bv */
    int[] m375bv() default {1, 0, 3};

    @JvmName(name = "d1")
    /* renamed from: d1 */
    String[] m374d1() default {};

    @JvmName(name = "d2")
    /* renamed from: d2 */
    String[] m373d2() default {};

    @JvmName(name = "xs")
    /* renamed from: xs */
    String m368xs() default "";

    @JvmName(name = "pn")
    /* renamed from: pn */
    String m370pn() default "";

    @JvmName(name = "xi")
    /* renamed from: xi */
    int m369xi() default 0;
}
