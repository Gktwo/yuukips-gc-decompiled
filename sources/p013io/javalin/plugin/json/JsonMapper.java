package p013io.javalin.plugin.json;

import java.io.InputStream;
import kotlin.NotImplementedError;
import org.jetbrains.annotations.NotNull;

/* renamed from: io.javalin.plugin.json.JsonMapper */
/* loaded from: grasscutter.jar:io/javalin/plugin/json/JsonMapper.class */
public interface JsonMapper {
    @NotNull
    default String toJsonString(@NotNull Object obj) {
        throw new NotImplementedError("JsonMapper#toJsonString not implemented");
    }

    @NotNull
    default InputStream toJsonStream(@NotNull Object obj) {
        throw new NotImplementedError("JsonMapper#toJsonStream not implemented");
    }

    @NotNull
    default <T> T fromJsonString(@NotNull String json, @NotNull Class<T> targetClass) {
        throw new NotImplementedError("JsonMapper#fromJsonString not implemented");
    }

    @NotNull
    default <T> T fromJsonStream(@NotNull InputStream json, @NotNull Class<T> targetClass) {
        throw new NotImplementedError("JsonMapper#fromJsonStream not implemented");
    }
}
