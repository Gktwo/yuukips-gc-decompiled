package p001ch.qos.logback.classic.jmx;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import p001ch.qos.logback.core.joran.spi.JoranException;

/* renamed from: ch.qos.logback.classic.jmx.JMXConfiguratorMBean */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/jmx/JMXConfiguratorMBean.class */
public interface JMXConfiguratorMBean {
    void reloadDefaultConfiguration() throws JoranException;

    void reloadByFileName(String str) throws JoranException, FileNotFoundException;

    void reloadByURL(URL url) throws JoranException;

    void setLoggerLevel(String str, String str2);

    String getLoggerLevel(String str);

    String getLoggerEffectiveLevel(String str);

    List<String> getLoggerList();

    List<String> getStatuses();
}
