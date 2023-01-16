package kotlin;

import org.jetbrains.annotations.Nullable;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* compiled from: NoWhenBranchMatchedException.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0016\u0018��2\u00060\u0001j\u0002`\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB\u0011\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\n¨\u0006\u000b"}, m373d2 = {"Lkotlin/NoWhenBranchMatchedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", SendMailJob.PROP_MESSAGE, "", "(Ljava/lang/String;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/NoWhenBranchMatchedException.class */
public class NoWhenBranchMatchedException extends RuntimeException {
    public NoWhenBranchMatchedException() {
    }

    public NoWhenBranchMatchedException(@Nullable String message) {
        super(message);
    }

    public NoWhenBranchMatchedException(@Nullable String message, @Nullable Throwable cause) {
        super(message, cause);
    }

    public NoWhenBranchMatchedException(@Nullable Throwable cause) {
        super(cause);
    }
}
