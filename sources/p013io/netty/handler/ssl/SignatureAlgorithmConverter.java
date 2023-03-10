package p013io.netty.handler.ssl;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: io.netty.handler.ssl.SignatureAlgorithmConverter */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SignatureAlgorithmConverter.class */
final class SignatureAlgorithmConverter {
    private static final Pattern PATTERN = Pattern.compile("(?:(^[a-zA-Z].+)With(.+)Encryption$)|(?:(^[a-zA-Z].+)(?:_with_|-with-|_pkcs1_|_pss_rsae_)(.+$))|(?:(^[a-zA-Z].+)_(.+$))");

    private SignatureAlgorithmConverter() {
    }

    /* access modifiers changed from: package-private */
    public static String toJavaName(String opensslName) {
        if (opensslName == null) {
            return null;
        }
        Matcher matcher = PATTERN.matcher(opensslName);
        if (!matcher.matches()) {
            return null;
        }
        String group1 = matcher.group(1);
        if (group1 != null) {
            return group1.toUpperCase(Locale.ROOT) + JsonPOJOBuilder.DEFAULT_WITH_PREFIX + matcher.group(2).toUpperCase(Locale.ROOT);
        }
        if (matcher.group(3) != null) {
            return matcher.group(4).toUpperCase(Locale.ROOT) + JsonPOJOBuilder.DEFAULT_WITH_PREFIX + matcher.group(3).toUpperCase(Locale.ROOT);
        }
        if (matcher.group(5) != null) {
            return matcher.group(6).toUpperCase(Locale.ROOT) + JsonPOJOBuilder.DEFAULT_WITH_PREFIX + matcher.group(5).toUpperCase(Locale.ROOT);
        }
        return null;
    }
}
