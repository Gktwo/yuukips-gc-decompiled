package kotlin.jvm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.annotation.AnnotationTarget;

/* compiled from: JvmDefault.kt */
@Target({ElementType.METHOD})
@SinceKotlin(version = "1.2")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n��\b\u0002\u0018��2\u00020\u0001B��ø\u0001��\u0002\u0007\n\u0005\b(0\u0001¨\u0006\u0002"}, m373d2 = {"Lkotlin/jvm/JvmDefault;", "", "kotlin-stdlib"})
@Deprecated(message = "Switch to new -Xjvm-default modes: `all` or `all-compatibility`")
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:kotlin/jvm/JvmDefault.class */
public @interface JvmDefault {
}
