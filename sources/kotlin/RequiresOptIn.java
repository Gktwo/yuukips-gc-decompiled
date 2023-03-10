package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import org.quartz.impl.jdbcjobstore.Constants;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* compiled from: OptIn.kt */
@Target({ElementType.ANNOTATION_TYPE})
@SinceKotlin(version = "1.3")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018��2\u00020\u0001:\u0001\bB\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0007ø\u0001��\u0002\u0007\n\u0005\bF0\u0001¨\u0006\t"}, m373d2 = {"Lkotlin/RequiresOptIn;", "", SendMailJob.PROP_MESSAGE, "", "level", "Lkotlin/RequiresOptIn$Level;", "()Lkotlin/RequiresOptIn$Level;", "()Ljava/lang/String;", "Level", "kotlin-stdlib"})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Retention(AnnotationRetention.BINARY)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
/* loaded from: grasscutter.jar:kotlin/RequiresOptIn.class */
public @interface RequiresOptIn {

    /* compiled from: OptIn.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018��2\b\u0012\u0004\u0012\u00020��0\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, m373d2 = {"Lkotlin/RequiresOptIn$Level;", "", "(Ljava/lang/String;I)V", "WARNING", Constants.STATE_ERROR, "kotlin-stdlib"})
    /* loaded from: grasscutter.jar:kotlin/RequiresOptIn$Level.class */
    public enum Level {
        WARNING,
        ERROR
    }

    String message() default "";

    Level level() default Level.ERROR;
}
