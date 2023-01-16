package org.jline.style;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: grasscutter.jar:org/jline/style/StyleBundle.class */
public interface StyleBundle {

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    /* loaded from: grasscutter.jar:org/jline/style/StyleBundle$DefaultStyle.class */
    public @interface DefaultStyle {
        String value();
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    /* loaded from: grasscutter.jar:org/jline/style/StyleBundle$StyleGroup.class */
    public @interface StyleGroup {
        String value();
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    /* loaded from: grasscutter.jar:org/jline/style/StyleBundle$StyleName.class */
    public @interface StyleName {
        String value();
    }
}
