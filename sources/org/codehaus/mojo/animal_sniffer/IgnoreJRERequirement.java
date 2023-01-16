package org.codehaus.mojo.animal_sniffer;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@Documented
/* loaded from: grasscutter.jar:org/codehaus/mojo/animal_sniffer/IgnoreJRERequirement.class */
public @interface IgnoreJRERequirement {
}
