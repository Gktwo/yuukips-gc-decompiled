package javax.servlet.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.servlet.annotation.ServletSecurity;

@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:javax/servlet/annotation/HttpMethodConstraint.class */
public @interface HttpMethodConstraint {
    String value();

    ServletSecurity.EmptyRoleSemantic emptyRoleSemantic() default ServletSecurity.EmptyRoleSemantic.PERMIT;

    ServletSecurity.TransportGuarantee transportGuarantee() default ServletSecurity.TransportGuarantee.NONE;

    String[] rolesAllowed() default {};
}
