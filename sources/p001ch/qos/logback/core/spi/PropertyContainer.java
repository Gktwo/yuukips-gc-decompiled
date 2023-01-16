package p001ch.qos.logback.core.spi;

import java.util.Map;

/* renamed from: ch.qos.logback.core.spi.PropertyContainer */
/* loaded from: grasscutter.jar:ch/qos/logback/core/spi/PropertyContainer.class */
public interface PropertyContainer {
    String getProperty(String str);

    Map<String, String> getCopyOfPropertyMap();
}
