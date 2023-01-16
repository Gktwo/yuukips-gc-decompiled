package p001ch.qos.logback.core.joran.spi;

import java.net.URL;
import p001ch.qos.logback.core.status.StatusManager;

/* renamed from: ch.qos.logback.core.joran.spi.XMLUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/spi/XMLUtil.class */
public class XMLUtil {
    public static final int ILL_FORMED = 1;
    public static final int UNRECOVERABLE_ERROR = 2;

    public static int checkIfWellFormed(URL url, StatusManager sm) {
        return 0;
    }
}
