package kotlin.jvm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;

/* compiled from: JvmFlagAnnotations.kt */
@Target({ElementType.METHOD})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Retention(AnnotationRetention.SOURCE)
@java.lang.annotation.Retention(RetentionPolicy.SOURCE)
@MustBeDocumented
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n��\b\u0002\u0018��2\u00020\u0001B��¨\u0006\u0002"}, m373d2 = {"Lkotlin/jvm/Synchronized;", "", "kotlin-stdlib"})
@Documented
/* loaded from: grasscutter.jar:kotlin/jvm/Synchronized.class */
public @interface Synchronized {
}
