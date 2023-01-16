package p013io.javalin.http;

import kotlin.Metadata;
import org.quartz.impl.jdbcjobstore.Constants;

/* compiled from: JavalinServletHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018��2\b\u0012\u0004\u0012\u00020��0\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m373d2 = {"Lio/javalin/http/DefaultName;", "", "Lio/javalin/http/StageName;", "(Ljava/lang/String;I)V", "BEFORE", "HTTP", Constants.STATE_ERROR, "AFTER", "javalin"})
/* renamed from: io.javalin.http.DefaultName */
/* loaded from: grasscutter.jar:io/javalin/http/DefaultName.class */
public enum DefaultName implements StageName {
    BEFORE,
    HTTP,
    ERROR,
    AFTER
}
