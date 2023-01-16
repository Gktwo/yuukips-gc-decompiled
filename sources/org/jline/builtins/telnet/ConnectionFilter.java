package org.jline.builtins.telnet;

import java.net.InetAddress;

/* loaded from: grasscutter.jar:org/jline/builtins/telnet/ConnectionFilter.class */
public interface ConnectionFilter {
    boolean isAllowed(InetAddress inetAddress);
}
