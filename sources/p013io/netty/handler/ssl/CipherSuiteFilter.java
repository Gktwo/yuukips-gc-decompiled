package p013io.netty.handler.ssl;

import java.util.List;
import java.util.Set;

/* renamed from: io.netty.handler.ssl.CipherSuiteFilter */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/CipherSuiteFilter.class */
public interface CipherSuiteFilter {
    String[] filterCipherSuites(Iterable<String> iterable, List<String> list, Set<String> set);
}
