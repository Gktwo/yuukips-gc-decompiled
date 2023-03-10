package org.checkerframework.checker.guieffect.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.PolymorphicQualifier;

@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@PolymorphicQualifier(AbstractC5554UI.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:org/checkerframework/checker/guieffect/qual/PolyUI.class */
public @interface PolyUI {
}
