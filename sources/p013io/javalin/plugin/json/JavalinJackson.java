package p013io.javalin.plugin.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PipedOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.core.util.OptionalDependency;
import p013io.javalin.core.util.Util;

/* compiled from: JavalinJackson.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��8\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010��\n\u0002\b\u0003\u0018�� \u00152\u00020\u0001:\u0001\u0015B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0002J)\u0010\t\u001a\u0002H\n\"\u0004\b��\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\n0\bH\u0016¢\u0006\u0002\u0010\rJ)\u0010\u000e\u001a\u0002H\n\"\u0004\b��\u0010\n2\u0006\u0010\u000b\u001a\u00020\u000f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\n0\bH\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n��¨\u0006\u0016"}, m373d2 = {"Lio/javalin/plugin/json/JavalinJackson;", "Lio/javalin/plugin/json/JsonMapper;", "objectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;)V", "ensureDependenciesPresent", "", "targetClass", "Ljava/lang/Class;", "fromJsonStream", "T", "json", "Ljava/io/InputStream;", "(Ljava/io/InputStream;Ljava/lang/Class;)Ljava/lang/Object;", "fromJsonString", "", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "toJsonStream", "obj", "", "toJsonString", "Companion", "javalin"})
/* renamed from: io.javalin.plugin.json.JavalinJackson */
/* loaded from: grasscutter.jar:io/javalin/plugin/json/JavalinJackson.class */
public final class JavalinJackson implements JsonMapper {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private ObjectMapper objectMapper;

    public JavalinJackson() {
        this(null, 1, null);
    }

    public JavalinJackson(@Nullable ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public /* synthetic */ JavalinJackson(ObjectMapper objectMapper, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : objectMapper);
    }

    @Override // p013io.javalin.plugin.json.JsonMapper
    @NotNull
    public String toJsonString(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        ensureDependenciesPresent$default(this, null, 1, null);
        if (obj instanceof String) {
            return (String) obj;
        }
        ObjectMapper objectMapper = this.objectMapper;
        Intrinsics.checkNotNull(objectMapper);
        String writeValueAsString = objectMapper.writeValueAsString(obj);
        Intrinsics.checkNotNullExpressionValue(writeValueAsString, "objectMapper!!.writeValueAsString(obj)");
        return writeValueAsString;
    }

    @Override // p013io.javalin.plugin.json.JsonMapper
    @NotNull
    public InputStream toJsonStream(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        ensureDependenciesPresent$default(this, null, 1, null);
        if (!(obj instanceof String)) {
            return PipedStreamUtil.INSTANCE.getInputStream(new Function1<PipedOutputStream, Unit>(this, obj) { // from class: io.javalin.plugin.json.JavalinJackson$toJsonStream$1
                final /* synthetic */ JavalinJackson this$0;
                final /* synthetic */ Object $obj;

                /* access modifiers changed from: package-private */
                {
                    this.this$0 = $receiver;
                    this.$obj = $obj;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(PipedOutputStream pipedOutputStream) {
                    invoke(pipedOutputStream);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull PipedOutputStream pipedOutputStream) {
                    Intrinsics.checkNotNullParameter(pipedOutputStream, "pipedOutputStream");
                    ObjectMapper objectMapper = this.this$0.objectMapper;
                    Intrinsics.checkNotNull(objectMapper);
                    objectMapper.getFactory().createGenerator(pipedOutputStream).writeObject(this.$obj);
                }
            });
        }
        byte[] bytes = ((String) obj).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteArrayInputStream(bytes);
    }

    @Override // p013io.javalin.plugin.json.JsonMapper
    public <T> T fromJsonString(@NotNull String json, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(cls, "targetClass");
        ensureDependenciesPresent(cls);
        ObjectMapper objectMapper = this.objectMapper;
        Intrinsics.checkNotNull(objectMapper);
        return (T) objectMapper.readValue(json, cls);
    }

    @Override // p013io.javalin.plugin.json.JsonMapper
    public <T> T fromJsonStream(@NotNull InputStream json, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(cls, "targetClass");
        ensureDependenciesPresent(cls);
        ObjectMapper objectMapper = this.objectMapper;
        Intrinsics.checkNotNull(objectMapper);
        return (T) objectMapper.readValue(json, cls);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: io.javalin.plugin.json.JavalinJackson */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void ensureDependenciesPresent$default(JavalinJackson javalinJackson, Class cls, int i, Object obj) {
        if ((i & 1) != 0) {
            cls = null;
        }
        javalinJackson.ensureDependenciesPresent(cls);
    }

    private final void ensureDependenciesPresent(Class<?> cls) {
        Util.ensureDependencyPresent$default(Util.INSTANCE, OptionalDependency.JACKSON, false, 2, null);
        if (cls != null && Util.INSTANCE.isKotlinClass(cls)) {
            Util.ensureDependencyPresent$default(Util.INSTANCE, OptionalDependency.JACKSON_KT, false, 2, null);
        }
        ObjectMapper objectMapper = this.objectMapper;
        this.objectMapper = objectMapper == null ? Companion.defaultMapper() : objectMapper;
    }

    /* compiled from: JavalinJackson.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m373d2 = {"Lio/javalin/plugin/json/JavalinJackson$Companion;", "", "()V", "defaultMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "javalin"})
    /* renamed from: io.javalin.plugin.json.JavalinJackson$Companion */
    /* loaded from: grasscutter.jar:io/javalin/plugin/json/JavalinJackson$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ObjectMapper defaultMapper() {
            return JavalinJacksonKt.access$registerOptionalModule(JavalinJacksonKt.access$registerOptionalModule(JavalinJacksonKt.access$registerOptionalModule(new ObjectMapper(), OptionalDependency.JACKSON_KT.getTestClass()), OptionalDependency.JACKSON_JSR_310.getTestClass()), OptionalDependency.JACKSON_KTORM.getTestClass());
        }
    }
}
