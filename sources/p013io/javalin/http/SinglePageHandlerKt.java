package p013io.javalin.http;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SinglePageHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u0010\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a-\u0010��\u001a\u0004\u0018\u0001H\u0001\"\u0004\b��\u0010\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, m373d2 = {"findByPath", "T", "", "", "requestPath", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", "javalin"})
/* renamed from: io.javalin.http.SinglePageHandlerKt */
/* loaded from: grasscutter.jar:io/javalin/http/SinglePageHandlerKt.class */
public final class SinglePageHandlerKt {
    public static final <T> T findByPath(Map<String, ? extends T> map, String requestPath) {
        Object obj;
        Iterator<T> it = map.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            Object next = it.next();
            if (StringsKt.startsWith$default(requestPath, (String) next, false, 2, (Object) null)) {
                obj = next;
                break;
            }
        }
        String it2 = (String) obj;
        if (it2 == null) {
            return null;
        }
        T t = (T) map.get(it2);
        Intrinsics.checkNotNull(t);
        return t;
    }
}
