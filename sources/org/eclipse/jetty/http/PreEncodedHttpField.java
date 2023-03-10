package org.eclipse.jetty.http;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/PreEncodedHttpField.class */
public class PreEncodedHttpField extends HttpField {
    private static final Logger LOG = Log.getLogger(PreEncodedHttpField.class);
    private static final HttpFieldPreEncoder[] __encoders;
    private final byte[][] _encodedField;

    static {
        List<HttpFieldPreEncoder> encoders = new ArrayList<>();
        Iterator<HttpFieldPreEncoder> iter = ServiceLoader.load(HttpFieldPreEncoder.class).iterator();
        while (iter.hasNext()) {
            try {
                HttpFieldPreEncoder encoder = iter.next();
                if (index(encoder.getHttpVersion()) >= 0) {
                    encoders.add(encoder);
                }
            } catch (Error | RuntimeException e) {
                LOG.debug(e);
            }
        }
        LOG.debug("HttpField encoders loaded: {}", encoders);
        int size = encoders.size();
        __encoders = new HttpFieldPreEncoder[size == 0 ? 1 : size];
        for (HttpFieldPreEncoder e2 : encoders) {
            int i = index(e2.getHttpVersion());
            if (__encoders[i] == null) {
                __encoders[i] = e2;
            } else {
                LOG.warn("multiple PreEncoders for " + e2.getHttpVersion(), new Object[0]);
            }
        }
        if (__encoders[0] == null) {
            __encoders[0] = new Http1FieldPreEncoder();
        }
    }

    private static int index(HttpVersion version) {
        switch (version) {
            case HTTP_1_0:
            case HTTP_1_1:
                return 0;
            case HTTP_2:
                return 1;
            default:
                return -1;
        }
    }

    public PreEncodedHttpField(HttpHeader header, String name, String value) {
        super(header, name, value);
        this._encodedField = new byte[__encoders.length];
        for (int i = 0; i < __encoders.length; i++) {
            this._encodedField[i] = __encoders[i].getEncodedField(header, name, value);
        }
    }

    public PreEncodedHttpField(HttpHeader header, String value) {
        this(header, header.asString(), value);
    }

    public PreEncodedHttpField(String name, String value) {
        this(null, name, value);
    }

    public void putTo(ByteBuffer bufferInFillMode, HttpVersion version) {
        bufferInFillMode.put(this._encodedField[index(version)]);
    }
}
