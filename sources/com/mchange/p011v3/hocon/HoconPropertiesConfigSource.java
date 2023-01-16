package com.mchange.p011v3.hocon;

import com.mchange.p009v2.cfg.DelayedLogItem;
import com.mchange.p009v2.cfg.PropertiesConfigSource;
import com.mchange.p009v2.lang.SystemUtils;
import com.mchange.p011v3.hocon.HoconUtils;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigMergeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p013io.javalin.http.sse.EmitterKt;

/* renamed from: com.mchange.v3.hocon.HoconPropertiesConfigSource */
/* loaded from: grasscutter.jar:com/mchange/v3/hocon/HoconPropertiesConfigSource.class */
public final class HoconPropertiesConfigSource implements PropertiesConfigSource {
    private static Config extractConfig(ClassLoader classLoader, String str, List<DelayedLogItem> list) throws FileNotFoundException, Exception {
        String str2;
        String str3;
        int indexOf = str.indexOf(58);
        ArrayList arrayList = new ArrayList();
        if (indexOf < 0 || !"hocon".equals(str.substring(0, indexOf).toLowerCase())) {
            throw new IllegalArgumentException(String.format("Invalid resource identifier for hocon config file: '%s'", str));
        }
        String[] split = str.substring(indexOf + 1).trim().split("\\s*,\\s*");
        for (String str4 : split) {
            int lastIndexOf = str4.lastIndexOf(35);
            if (lastIndexOf > 0) {
                str3 = str4.substring(0, lastIndexOf);
                str2 = str4.substring(lastIndexOf + 1).replace('/', '.').trim();
            } else {
                str3 = str4;
                str2 = null;
            }
            Config config = null;
            if ("/".equals(str3)) {
                config = ConfigFactory.systemProperties();
            } else {
                Config config2 = null;
                if ("application".equals(str3) || "/application".equals(str3)) {
                    String property = System.getProperty("config.resource");
                    if (property != null) {
                        str3 = property;
                    } else {
                        String property2 = System.getProperty("config.file");
                        if (property2 != null) {
                            File file = new File(property2);
                            if (!file.exists()) {
                                list.add(new DelayedLogItem(DelayedLogItem.Level.WARNING, String.format("Specified config.file '%s' does not exist. Falling back to standard application.(conf|json|properties).}", file.getAbsolutePath())));
                            } else if (file.canRead()) {
                                config2 = ConfigFactory.parseFile(file);
                            } else {
                                list.add(new DelayedLogItem(DelayedLogItem.Level.WARNING, String.format("Specified config.file '%s' is not readable. Falling back to standard application.(conf|json|properties).}", file.getAbsolutePath())));
                            }
                        } else {
                            String property3 = System.getProperty("config.url");
                            if (property3 != null) {
                                config2 = ConfigFactory.parseURL(new URL(property3));
                            }
                        }
                    }
                }
                if (config2 == null) {
                    URL url = null;
                    if (str3.indexOf(EmitterKt.COMMENT_PREFIX) >= 0) {
                        try {
                            url = new URL(SystemUtils.sysPropsEnvReplace(str3));
                        } catch (MalformedURLException e) {
                            list.add(new DelayedLogItem(DelayedLogItem.Level.WARNING, String.format("Apparent URL resource path for HOCON '%s' could not be parsed as a URL.", str3), e));
                        }
                    }
                    if (url != null) {
                        config2 = ConfigFactory.parseURL(url);
                    } else {
                        if (str3.charAt(0) == '/') {
                            str3 = str3.substring(1);
                        }
                        if (str3.indexOf(46) >= 0) {
                            config2 = ConfigFactory.parseResources(classLoader, str3);
                        } else {
                            config2 = ConfigFactory.parseResourcesAnySyntax(classLoader, str3);
                        }
                    }
                }
                if (config2.isEmpty()) {
                    list.add(new DelayedLogItem(DelayedLogItem.Level.FINE, String.format("Missing or empty HOCON configuration for resource path '%s'.", str3)));
                } else {
                    config = config2;
                }
            }
            if (config != null) {
                if (str2 != null) {
                    config = config.getConfig(str2);
                }
                arrayList.add(config);
            }
        }
        if (arrayList.size() == 0) {
            throw new FileNotFoundException(String.format("Could not find HOCON configuration at any of the listed resources in '%s'", str));
        }
        Config empty = ConfigFactory.empty();
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return empty.resolve();
            }
            empty = empty.withFallback((ConfigMergeable) arrayList.get(size));
        }
    }

    public PropertiesConfigSource.Parse propertiesFromSource(ClassLoader classLoader, String str) throws FileNotFoundException, Exception {
        LinkedList linkedList = new LinkedList();
        HoconUtils.PropertiesConversion configToProperties = HoconUtils.configToProperties(extractConfig(classLoader, str, linkedList));
        Iterator<String> it = configToProperties.unrenderable.iterator();
        while (it.hasNext()) {
            linkedList.add(new DelayedLogItem(DelayedLogItem.Level.FINE, String.format("Value at path '%s' could not be converted to a String. Skipping.", it.next())));
        }
        return new PropertiesConfigSource.Parse(configToProperties.properties, linkedList);
    }

    @Override // com.mchange.p009v2.cfg.PropertiesConfigSource
    public PropertiesConfigSource.Parse propertiesFromSource(String str) throws FileNotFoundException, Exception {
        return propertiesFromSource(HoconPropertiesConfigSource.class.getClassLoader(), str);
    }
}
