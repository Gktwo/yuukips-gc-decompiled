package kotlin.coroutines.jvm.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.JvmName;
import p001ch.qos.logback.core.pattern.color.ANSIConstants;
import p001ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

/* compiled from: DebugMetadata.kt */
@Target({ElementType.TYPE})
@SinceKotlin(version = "1.3")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n��\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\u0015\n��\n\u0002\u0010\u0011\n\u0002\b\u0011\b\u0002\u0018��2\u00020\u0001B\\\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005R\u0011\u0010\r\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u00078\u0007¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0007¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000fR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0007¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, m373d2 = {"Lkotlin/coroutines/jvm/internal/DebugMetadata;", "", "version", "", "sourceFile", "", "lineNumbers", "", "localNames", "", "spilled", "indexToLabel", "methodName", "className", "c", "()Ljava/lang/String;", IntegerTokenConverter.CONVERTER_KEY, "()[I", "l", "n", "()[Ljava/lang/String;", ANSIConstants.ESC_END, "f", "s", "v", "()I", "kotlin-stdlib"})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:kotlin/coroutines/jvm/internal/DebugMetadata.class */
public @interface DebugMetadata {
    @JvmName(name = "v")
    /* renamed from: v */
    int m358v() default 1;

    @JvmName(name = "f")
    /* renamed from: f */
    String m364f() default "";

    @JvmName(name = "l")
    /* renamed from: l */
    int[] m362l() default {};

    @JvmName(name = "n")
    /* renamed from: n */
    String[] m360n() default {};

    @JvmName(name = "s")
    /* renamed from: s */
    String[] m359s() default {};

    @JvmName(name = IntegerTokenConverter.CONVERTER_KEY)
    /* renamed from: i */
    int[] m363i() default {};

    @JvmName(name = ANSIConstants.ESC_END)
    /* renamed from: m */
    String m361m() default "";

    @JvmName(name = "c")
    /* renamed from: c */
    String m365c() default "";
}
