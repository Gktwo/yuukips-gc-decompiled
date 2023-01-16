package p013io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: io.netty.handler.ssl.IdentityCipherSuiteFilter */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/IdentityCipherSuiteFilter.class */
public final class IdentityCipherSuiteFilter implements CipherSuiteFilter {
    public static final IdentityCipherSuiteFilter INSTANCE = new IdentityCipherSuiteFilter(true);
    public static final IdentityCipherSuiteFilter INSTANCE_DEFAULTING_TO_SUPPORTED_CIPHERS = new IdentityCipherSuiteFilter(false);
    private final boolean defaultToDefaultCiphers;

    private IdentityCipherSuiteFilter(boolean defaultToDefaultCiphers) {
        this.defaultToDefaultCiphers = defaultToDefaultCiphers;
    }

    @Override // p013io.netty.handler.ssl.CipherSuiteFilter
    public String[] filterCipherSuites(Iterable<String> ciphers, List<String> defaultCiphers, Set<String> supportedCiphers) {
        String c;
        if (ciphers != null) {
            List<String> newCiphers = new ArrayList<>(supportedCiphers.size());
            Iterator<String> it = ciphers.iterator();
            while (it.hasNext() && (c = it.next()) != null) {
                newCiphers.add(c);
            }
            return (String[]) newCiphers.toArray(new String[0]);
        } else if (this.defaultToDefaultCiphers) {
            return (String[]) defaultCiphers.toArray(new String[0]);
        } else {
            return (String[]) supportedCiphers.toArray(new String[0]);
        }
    }
}
