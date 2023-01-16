package com.mchange.p009v2.cfg;

import com.mchange.p009v2.cfg.DelayedLogItem;
import com.mchange.p009v2.cfg.PropertiesConfigSource;
import com.mchange.p011v3.hocon.HoconPropertiesConfigSource;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.cfg.BasicMultiPropertiesConfig */
/* loaded from: grasscutter.jar:com/mchange/v2/cfg/BasicMultiPropertiesConfig.class */
public final class BasicMultiPropertiesConfig extends MultiPropertiesConfig {
    private static final String HOCON_CFG_CNAME = "com.typesafe.config.Config";
    private static final int HOCON_PFX_LEN = 6;
    static final BasicMultiPropertiesConfig EMPTY = new BasicMultiPropertiesConfig();
    String[] rps;
    Map propsByResourcePaths;
    Map propsByPrefixes;
    List parseMessages;
    Properties propsByKey;

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.cfg.BasicMultiPropertiesConfig$SystemPropertiesConfigSource */
    /* loaded from: grasscutter.jar:com/mchange/v2/cfg/BasicMultiPropertiesConfig$SystemPropertiesConfigSource.class */
    public static final class SystemPropertiesConfigSource implements PropertiesConfigSource {
        SystemPropertiesConfigSource() {
        }

        @Override // com.mchange.p009v2.cfg.PropertiesConfigSource
        public PropertiesConfigSource.Parse propertiesFromSource(String str) throws FileNotFoundException, Exception {
            if ("/".equals(str)) {
                return new PropertiesConfigSource.Parse((Properties) System.getProperties().clone(), Collections.emptyList());
            }
            throw new Exception(String.format("Unexpected identifier for System properties: '%s'", str));
        }
    }

    static boolean isHoconPath(String str) {
        return str.length() > 6 && str.substring(0, 6).toLowerCase().equals("hocon:");
    }

    private static PropertiesConfigSource configSource(String str) throws Exception {
        boolean isHoconPath = isHoconPath(str);
        if (!isHoconPath && !str.startsWith("/")) {
            throw new IllegalArgumentException(String.format("Resource identifier '%s' is neither an absolute resource path nor a HOCON path. (Resource paths should be specified beginning with '/' or 'hocon:/')", str));
        } else if (isHoconPath) {
            try {
                Class.forName(HOCON_CFG_CNAME);
                return new HoconPropertiesConfigSource();
            } catch (ClassNotFoundException e) {
                int lastIndexOf = str.lastIndexOf(35);
                String substring = lastIndexOf > 0 ? str.substring(6, lastIndexOf) : str.substring(6);
                if (BasicMultiPropertiesConfig.class.getResource(substring) == null) {
                    throw new FileNotFoundException(String.format("HOCON lib (typesafe-config) is not available. Also, no resource available at '%s' for HOCON identifier '%s'.", substring, str));
                }
                throw new Exception(String.format("Could not decode HOCON resource '%s', even though the resource exists, because HOCON lib (typesafe-config) is not available.", str), e);
            }
        } else if ("/".equals(str)) {
            return new SystemPropertiesConfigSource();
        } else {
            return new BasicPropertiesConfigSource();
        }
    }

    public BasicMultiPropertiesConfig(String[] strArr) {
        this(strArr, (List) null);
    }

    /* access modifiers changed from: package-private */
    public BasicMultiPropertiesConfig(String[] strArr, List list) {
        firstInit(strArr, list);
        finishInit(list);
    }

    public BasicMultiPropertiesConfig(String str, Properties properties) {
        this(new String[]{str}, resourcePathToPropertiesMap(str, properties), Collections.emptyList());
    }

    private static Map resourcePathToPropertiesMap(String str, Properties properties) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, properties);
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public BasicMultiPropertiesConfig(String[] strArr, Map map, List list) {
        this.rps = strArr;
        this.propsByResourcePaths = map;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        finishInit(arrayList);
        this.parseMessages = arrayList;
    }

    private BasicMultiPropertiesConfig() {
        this.rps = new String[0];
        Collections.emptyMap();
        Collections.emptyMap();
        Collections.emptyList();
        new Properties();
    }

    private void firstInit(String[] strArr, List list) {
        boolean z = false;
        if (list == null) {
            list = new ArrayList();
            z = true;
        }
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            try {
                PropertiesConfigSource.Parse propertiesFromSource = configSource(str).propertiesFromSource(str);
                hashMap.put(str, propertiesFromSource.getProperties());
                arrayList.add(str);
                list.addAll(propertiesFromSource.getDelayedLogItems());
            } catch (FileNotFoundException e) {
                list.add(new DelayedLogItem(DelayedLogItem.Level.FINE, String.format("The configuration file for resource identifier '%s' could not be found. Skipping.", str)));
            } catch (Exception e2) {
                list.add(new DelayedLogItem(DelayedLogItem.Level.WARNING, String.format("An Exception occurred while trying to read configuration data at resource identifier '%s'.", str), e2));
            }
        }
        this.rps = (String[]) arrayList.toArray(new String[arrayList.size()]);
        this.propsByResourcePaths = Collections.unmodifiableMap(hashMap);
        this.parseMessages = Collections.unmodifiableList(list);
        if (z) {
            dumpToSysErr(list);
        }
    }

    private void finishInit(List list) {
        boolean z = false;
        if (list == null) {
            list = new ArrayList();
            z = true;
        }
        this.propsByPrefixes = Collections.unmodifiableMap(extractPrefixMapFromRsrcPathMap(this.rps, this.propsByResourcePaths, list));
        this.propsByKey = extractPropsByKey(this.rps, this.propsByResourcePaths, list);
        if (z) {
            dumpToSysErr(list);
        }
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig
    public List getDelayedLogItems() {
        return this.parseMessages;
    }

    private static void dumpToSysErr(List list) {
        for (Object obj : list) {
            System.err.println(obj);
        }
    }

    private static String extractPrefix(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            return str.substring(0, lastIndexOf);
        }
        if ("".equals(str)) {
            return null;
        }
        return "";
    }

    private static Properties findProps(String str, Map map) {
        return (Properties) map.get(str);
    }

    private static Properties extractPropsByKey(String[] strArr, Map map, List list) {
        Properties properties = new Properties();
        for (String str : strArr) {
            Properties findProps = findProps(str, map);
            if (findProps == null) {
                list.add(new DelayedLogItem(DelayedLogItem.Level.WARNING, BasicMultiPropertiesConfig.class.getName() + ".extractPropsByKey(): Could not find loaded properties for resource path: " + str));
            } else {
                for (Object obj : findProps.keySet()) {
                    if (!(obj instanceof String)) {
                        list.add(new DelayedLogItem(DelayedLogItem.Level.WARNING, BasicMultiPropertiesConfig.class.getName() + ": Properties object found at resource path " + ("/".equals(str) ? "[system properties]" : "'" + str + "'") + "' contains a key that is not a String: " + obj + "; Skipping..."));
                    } else {
                        Object obj2 = findProps.get(obj);
                        if (obj2 == null || (obj2 instanceof String)) {
                            properties.put((String) obj, (String) obj2);
                        } else {
                            list.add(new DelayedLogItem(DelayedLogItem.Level.WARNING, BasicMultiPropertiesConfig.class.getName() + ": Properties object found at resource path " + ("/".equals(str) ? "[system properties]" : "'" + str + "'") + " contains a value that is not a String: " + obj2 + "; Skipping..."));
                        }
                    }
                }
            }
        }
        return properties;
    }

    private static Map extractPrefixMapFromRsrcPathMap(String[] strArr, Map map, List list) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            Properties findProps = findProps(str, map);
            if (findProps == null) {
                list.add(new DelayedLogItem(DelayedLogItem.Level.WARNING, BasicMultiPropertiesConfig.class.getName() + ".extractPrefixMapFromRsrcPathMap(): Could not find loaded properties for resource path: " + str));
            } else {
                for (Object obj : findProps.keySet()) {
                    if (!(obj instanceof String)) {
                        list.add(new DelayedLogItem(DelayedLogItem.Level.WARNING, BasicMultiPropertiesConfig.class.getName() + ": Properties object found at resource path " + ("/".equals(str) ? "[system properties]" : "'" + str + "'") + "' contains a key that is not a String: " + obj + "; Skipping..."));
                    } else {
                        String str2 = (String) obj;
                        for (String extractPrefix = extractPrefix(str2); extractPrefix != null; extractPrefix = extractPrefix(extractPrefix)) {
                            Properties properties = (Properties) hashMap.get(extractPrefix);
                            if (properties == null) {
                                properties = new Properties();
                                hashMap.put(extractPrefix, properties);
                            }
                            properties.put(str2, findProps.get(str2));
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig
    public String[] getPropertiesResourcePaths() {
        return (String[]) this.rps.clone();
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig
    public Properties getPropertiesByResourcePath(String str) {
        Properties properties = (Properties) this.propsByResourcePaths.get(str);
        return properties == null ? new Properties() : properties;
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig, com.mchange.p009v2.cfg.PropertiesConfig
    public Properties getPropertiesByPrefix(String str) {
        Properties properties = (Properties) this.propsByPrefixes.get(str);
        return properties == null ? new Properties() : properties;
    }

    @Override // com.mchange.p009v2.cfg.MultiPropertiesConfig, com.mchange.p009v2.cfg.PropertiesConfig
    public String getProperty(String str) {
        return this.propsByKey.getProperty(str);
    }

    public String dump() {
        return String.format("[ propertiesByResourcePaths -> %s, propertiesByPrefixes -> %s ]", this.propsByResourcePaths, this.propsByPrefixes);
    }

    public String toString() {
        return toString() + " " + dump();
    }
}
