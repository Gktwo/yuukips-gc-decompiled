package p013io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.SupportedCipherSuiteFilter */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SupportedCipherSuiteFilter.class */
public final class SupportedCipherSuiteFilter implements CipherSuiteFilter {
    public static final SupportedCipherSuiteFilter INSTANCE = new SupportedCipherSuiteFilter();

    private SupportedCipherSuiteFilter() {
    }

    @Override // p013io.netty.handler.ssl.CipherSuiteFilter
    public String[] filterCipherSuites(Iterable<String> ciphers, List<String> defaultCiphers, Set<String> supportedCiphers) {
        List<String> newCiphers;
        String c;
        ObjectUtil.checkNotNull(defaultCiphers, "defaultCiphers");
        ObjectUtil.checkNotNull(supportedCiphers, "supportedCiphers");
        if (ciphers == null) {
            newCiphers = new ArrayList<>(defaultCiphers.size());
            ciphers = defaultCiphers;
        } else {
            newCiphers = new ArrayList<>(supportedCiphers.size());
        }
        Iterator<String> it = ciphers.iterator();
        while (it.hasNext() && (c = it.next()) != null) {
            if (supportedCiphers.contains(c)) {
                newCiphers.add(c);
            }
        }
        return (String[]) newCiphers.toArray(new String[0]);
    }
}
