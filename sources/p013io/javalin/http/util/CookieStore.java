package p013io.javalin.http.util;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.reader.LineReader;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;
import p013io.javalin.http.Cookie;
import p013io.javalin.plugin.json.JsonMapper;

/* compiled from: CookieStore.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��0\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018�� \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u0010\u000e\u001a\u0002H\u000f\"\u0004\b��\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u0011J$\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00010\u00050\u00052\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\bH\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0001H\u0002R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\bX\u0004¢\u0006\u0002\n��R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\t\u0010\n¨\u0006\u001a"}, m373d2 = {"Lio/javalin/http/util/CookieStore;", "", "jsonMapper", "Lio/javalin/plugin/json/JsonMapper;", "cookie", "", "(Lio/javalin/plugin/json/JsonMapper;Ljava/lang/String;)V", "cookieMap", "", "getJsonMapper", "()Lio/javalin/plugin/json/JsonMapper;", LineReader.CLEAR, "", "deserialize", BeanUtil.PREFIX_GETTER_GET, "T", Action.KEY_ATTRIBUTE, "(Ljava/lang/String;)Ljava/lang/Object;", "serialize", "kotlin.jvm.PlatformType", "map", "serializeToCookie", "Lio/javalin/http/Cookie;", "set", "value", "Companion", "javalin"})
/* renamed from: io.javalin.http.util.CookieStore */
/* loaded from: grasscutter.jar:io/javalin/http/util/CookieStore.class */
public final class CookieStore {
    @NotNull
    private final JsonMapper jsonMapper;
    @NotNull
    private final Map<String, Object> cookieMap;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static String COOKIE_NAME = "javalin-cookie-store";

    public CookieStore(@NotNull JsonMapper jsonMapper, @Nullable String cookie) {
        Intrinsics.checkNotNullParameter(jsonMapper, "jsonMapper");
        this.jsonMapper = jsonMapper;
        this.cookieMap = deserialize(cookie);
    }

    @NotNull
    public final JsonMapper getJsonMapper() {
        return this.jsonMapper;
    }

    /* compiled from: CookieStore.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, m373d2 = {"Lio/javalin/http/util/CookieStore$Companion;", "", "()V", "COOKIE_NAME", "", "getCOOKIE_NAME", "()Ljava/lang/String;", "setCOOKIE_NAME", "(Ljava/lang/String;)V", "javalin"})
    /* renamed from: io.javalin.http.util.CookieStore$Companion */
    /* loaded from: grasscutter.jar:io/javalin/http/util/CookieStore$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String getCOOKIE_NAME() {
            return CookieStore.COOKIE_NAME;
        }

        public final void setCOOKIE_NAME(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            CookieStore.COOKIE_NAME = str;
        }
    }

    @NotNull
    public final Cookie serializeToCookie() {
        String str = COOKIE_NAME;
        String serialize = serialize(this.cookieMap);
        Intrinsics.checkNotNullExpressionValue(serialize, "serialize(cookieMap)");
        return new Cookie(str, serialize, null, 0, false, 0, false, null, null, null, PacketOpcodes.BigTalentPointConvertReq, null);
    }

    public final <T> T get(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return (T) this.cookieMap.get(key);
    }

    @Nullable
    public final Object set(@NotNull String key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(value, "value");
        return this.cookieMap.put(key, value);
    }

    public final void clear() {
        this.cookieMap.clear();
    }

    private final Map<String, Object> deserialize(String cookie) {
        String str = cookie;
        if (str == null || str.length() == 0) {
            return new LinkedHashMap();
        }
        JsonMapper jsonMapper = this.jsonMapper;
        byte[] decode = Base64.getDecoder().decode(cookie);
        Intrinsics.checkNotNullExpressionValue(decode, "getDecoder().decode(cookie)");
        return TypeIntrinsics.asMutableMap(jsonMapper.fromJsonString(new String(decode, Charsets.UTF_8), Map.class));
    }

    private final String serialize(Map<String, Object> map) {
        Base64.Encoder encoder = Base64.getEncoder();
        String jsonString = this.jsonMapper.toJsonString(map);
        Intrinsics.checkNotNullExpressionValue(jsonString, "jsonMapper.toJsonString(map)");
        byte[] bytes = jsonString.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return encoder.encodeToString(bytes);
    }
}
