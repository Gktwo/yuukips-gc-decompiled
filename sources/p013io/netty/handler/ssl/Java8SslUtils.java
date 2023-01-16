package p013io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLParameters;
import p013io.netty.util.CharsetUtil;
import p013io.netty.util.internal.SuppressJava6Requirement;

@SuppressJava6Requirement(reason = "Usage guarded by java version check")
/* renamed from: io.netty.handler.ssl.Java8SslUtils */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/Java8SslUtils.class */
final class Java8SslUtils {
    private Java8SslUtils() {
    }

    /* access modifiers changed from: package-private */
    public static List<String> getSniHostNames(SSLParameters sslParameters) {
        List<SNIServerName> names = sslParameters.getServerNames();
        if (names == null || names.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> strings = new ArrayList<>(names.size());
        for (SNIServerName serverName : names) {
            if (serverName instanceof SNIHostName) {
                strings.add(((SNIHostName) serverName).getAsciiName());
            } else {
                throw new IllegalArgumentException("Only " + SNIHostName.class.getName() + " instances are supported, but found: " + serverName);
            }
        }
        return strings;
    }

    /* access modifiers changed from: package-private */
    public static void setSniHostNames(SSLParameters sslParameters, List<String> names) {
        sslParameters.setServerNames(getSniHostNames(names));
    }

    /* access modifiers changed from: package-private */
    public static boolean isValidHostNameForSNI(String hostname) {
        try {
            new SNIHostName(hostname);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public static List getSniHostNames(List<String> names) {
        if (names == null || names.isEmpty()) {
            return Collections.emptyList();
        }
        List<SNIServerName> sniServerNames = new ArrayList<>(names.size());
        for (String name : names) {
            sniServerNames.add(new SNIHostName(name.getBytes(CharsetUtil.UTF_8)));
        }
        return sniServerNames;
    }

    /* access modifiers changed from: package-private */
    public static List getSniHostName(byte[] hostname) {
        if (hostname == null || hostname.length == 0) {
            return Collections.emptyList();
        }
        return Collections.singletonList(new SNIHostName(hostname));
    }

    /* access modifiers changed from: package-private */
    public static boolean getUseCipherSuitesOrder(SSLParameters sslParameters) {
        return sslParameters.getUseCipherSuitesOrder();
    }

    /* access modifiers changed from: package-private */
    public static void setUseCipherSuitesOrder(SSLParameters sslParameters, boolean useOrder) {
        sslParameters.setUseCipherSuitesOrder(useOrder);
    }

    /* access modifiers changed from: package-private */
    public static void setSNIMatchers(SSLParameters sslParameters, Collection<?> matchers) {
        sslParameters.setSNIMatchers(matchers);
    }

    /* access modifiers changed from: package-private */
    public static boolean checkSniHostnameMatch(Collection<?> matchers, byte[] hostname) {
        if (matchers == null || matchers.isEmpty()) {
            return true;
        }
        SNIHostName name = new SNIHostName(hostname);
        Iterator<?> it = matchers.iterator();
        while (it.hasNext()) {
            SNIMatcher matcher = (SNIMatcher) it.next();
            if (matcher.getType() == 0 && matcher.matches(name)) {
                return true;
            }
        }
        return false;
    }
}
