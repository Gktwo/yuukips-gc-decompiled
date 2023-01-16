package com.mongodb.internal.connection;

import java.util.Collections;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/SslHelper.class */
public final class SslHelper {
    public static void enableHostNameVerification(SSLParameters sslParameters) {
        sslParameters.setEndpointIdentificationAlgorithm("HTTPS");
    }

    public static void enableSni(String host, SSLParameters sslParameters) {
        try {
            sslParameters.setServerNames(Collections.singletonList(new SNIHostName(host)));
        } catch (IllegalArgumentException e) {
        }
    }

    private SslHelper() {
    }
}
