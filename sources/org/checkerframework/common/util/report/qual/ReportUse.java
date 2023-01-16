package org.checkerframework.common.util.report.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PACKAGE, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:org/checkerframework/common/util/report/qual/ReportUse.class */
public @interface ReportUse {
}