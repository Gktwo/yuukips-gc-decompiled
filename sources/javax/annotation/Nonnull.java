package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@TypeQualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:javax/annotation/Nonnull.class */
public @interface Nonnull {
    When when() default When.ALWAYS;

    /* loaded from: grasscutter.jar:javax/annotation/Nonnull$Checker.class */
    public static class Checker implements TypeQualifierValidator<Nonnull> {
        public When forConstantValue(Nonnull qualifierArgument, Object value) {
            if (value == null) {
                return When.NEVER;
            }
            return When.ALWAYS;
        }
    }
}
