package p013io.javalin.plugin.json;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import kotlin.Metadata;
import p013io.javalin.core.util.Util;

/* compiled from: JavalinJackson.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\u001a\u0014\u0010��\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, m373d2 = {"registerOptionalModule", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "classString", "", "javalin"})
/* renamed from: io.javalin.plugin.json.JavalinJacksonKt */
/* loaded from: grasscutter.jar:io/javalin/plugin/json/JavalinJacksonKt.class */
public final class JavalinJacksonKt {
    public static final ObjectMapper registerOptionalModule(ObjectMapper $this$registerOptionalModule, String classString) {
        if (Util.INSTANCE.classExists(classString)) {
            Object newInstance = Class.forName(classString).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (newInstance == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.fasterxml.jackson.databind.Module");
            }
            $this$registerOptionalModule.registerModule((Module) newInstance);
        }
        return $this$registerOptionalModule;
    }
}
