package com.mchange.p009v2.cfg;

import com.mchange.p009v2.cfg.DelayedLogItem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;
import org.jline.reader.impl.LineReaderImpl;
import p013io.javalin.http.sse.EmitterKt;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.cfg.ConfigUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/cfg/ConfigUtils.class */
public final class ConfigUtils {
    private static final String[] DFLT_VM_RSRC_PATHFILES = {"/com/mchange/v2/cfg/vmConfigResourcePaths.txt", "/mchange-config-resource-paths.txt"};
    private static final String[] HARDCODED_DFLT_RSRC_PATHS = {"/mchange-commons.properties", "hocon:/reference,/application,/", "/"};
    static final String[] NO_PATHS = new String[0];
    static MultiPropertiesConfig vmConfig = null;

    /* access modifiers changed from: package-private */
    public static MultiPropertiesConfig read(String[] strArr, List list) {
        return new BasicMultiPropertiesConfig(strArr, list);
    }

    public static MultiPropertiesConfig read(String[] strArr) {
        return new BasicMultiPropertiesConfig(strArr);
    }

    public static MultiPropertiesConfig combine(MultiPropertiesConfig[] multiPropertiesConfigArr) {
        return new CombinedMultiPropertiesConfig(multiPropertiesConfigArr).toBasic();
    }

    public static MultiPropertiesConfig readVmConfig(String[] strArr, String[] strArr2) {
        return readVmConfig(strArr, strArr2, null);
    }

    /* access modifiers changed from: package-private */
    public static List vmCondensedPaths(String[] strArr, String[] strArr2, List list) {
        return ensureHoconInterresolvability(condensePaths(new String[][]{strArr, vmResourcePaths(list), strArr2}));
    }

    static String stringFromPathsList(List list) {
        StringBuffer stringBuffer = new StringBuffer(2048);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(list.get(i));
        }
        return stringBuffer.toString();
    }

    public static MultiPropertiesConfig readVmConfig(String[] strArr, String[] strArr2, List list) {
        List vmCondensedPaths = vmCondensedPaths(strArr == null ? NO_PATHS : strArr, strArr2 == null ? NO_PATHS : strArr2, list);
        if (list != null) {
            list.add(new DelayedLogItem(DelayedLogItem.Level.FINER, "Reading VM config for path list " + stringFromPathsList(vmCondensedPaths)));
        }
        return read((String[]) vmCondensedPaths.toArray(new String[vmCondensedPaths.size()]), list);
    }

    private static List condensePaths(String[][] strArr) {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        while (true) {
            length--;
            if (length >= 0) {
                int length2 = strArr[length].length;
                while (true) {
                    length2--;
                    if (length2 >= 0) {
                        String str = strArr[length][length2];
                        if (!hashSet.contains(str)) {
                            hashSet.add(str);
                            arrayList.add(str);
                        }
                    }
                }
            } else {
                Collections.reverse(arrayList);
                return arrayList;
            }
        }
    }

    private static List readResourcePathsFromResourcePathsTextFile(String str, List list) {
        BufferedReader bufferedReader;
        try {
            ArrayList arrayList = new ArrayList();
            bufferedReader = null;
            try {
                InputStream resourceAsStream = MultiPropertiesConfig.class.getResourceAsStream(str);
                if (resourceAsStream != null) {
                    bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "8859_1"));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String trim = readLine.trim();
                        if (!"".equals(trim) && !trim.startsWith(LineReaderImpl.DEFAULT_COMMENT_BEGIN)) {
                            arrayList.add(trim);
                        }
                    }
                    if (list != null) {
                        list.add(new DelayedLogItem(DelayedLogItem.Level.FINEST, String.format("Added paths from resource path text file at '%s'", str)));
                    }
                } else if (list != null) {
                    list.add(new DelayedLogItem(DelayedLogItem.Level.FINEST, String.format("Could not find resource path text file for path '%s'. Skipping.", str)));
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                    throw th;
                }
            }
            throw th;
        }
    }

    private static List readResourcePathsFromResourcePathsTextFiles(String[] strArr, List list) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.addAll(readResourcePathsFromResourcePathsTextFile(str, list));
        }
        return arrayList;
    }

    private static String[] vmResourcePaths(List list) {
        List vmResourcePathList = vmResourcePathList(list);
        return (String[]) vmResourcePathList.toArray(new String[vmResourcePathList.size()]);
    }

    private static List vmResourcePathList(List list) {
        List list2;
        List readResourcePathsFromResourcePathsTextFiles = readResourcePathsFromResourcePathsTextFiles(DFLT_VM_RSRC_PATHFILES, list);
        if (readResourcePathsFromResourcePathsTextFiles.size() > 0) {
            list2 = readResourcePathsFromResourcePathsTextFiles;
        } else {
            list2 = Arrays.asList(HARDCODED_DFLT_RSRC_PATHS);
        }
        return list2;
    }

    public static synchronized MultiPropertiesConfig readVmConfig() {
        return readVmConfig(null);
    }

    public static synchronized MultiPropertiesConfig readVmConfig(List list) {
        if (vmConfig == null) {
            List vmResourcePathList = vmResourcePathList(list);
            vmConfig = new BasicMultiPropertiesConfig((String[]) vmResourcePathList.toArray(new String[vmResourcePathList.size()]));
        }
        return vmConfig;
    }

    public static synchronized boolean foundVmConfig() {
        return vmConfig != null;
    }

    public static void dumpByPrefix(MultiPropertiesConfig multiPropertiesConfig, String str) {
        Properties propertiesByPrefix = multiPropertiesConfig.getPropertiesByPrefix(str);
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(propertiesByPrefix);
        for (Map.Entry entry : treeMap.entrySet()) {
            System.err.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    private static void putToSet(Map<String, Set<String>> map, String str, String str2) {
        Set<String> set = map.get(str);
        if (set == null) {
            set = new HashSet();
            map.put(str, set);
        }
        set.add(str2);
    }

    private static String makeHoconPathFromElements(List<String> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("hocon:");
        boolean z = true;
        for (String str : list) {
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    private static String normalizeHoconPathElement(String str) {
        return (str.indexOf(EmitterKt.COMMENT_PREFIX) >= 0 || str.charAt(0) == '/') ? str : '/' + str;
    }

    private static List<String> ensureHoconInterresolvability(List<String> list) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (str.toLowerCase().startsWith("hocon:")) {
                String[] split = str.substring("hocon:".length()).split("\\s*,\\s*");
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    split[i] = normalizeHoconPathElement(split[i]);
                }
                hashMap.put(str, Arrays.asList(split));
                for (String str2 : split) {
                    putToSet(hashMap2, str2, str);
                    if (str2.indexOf(46) < 0 && !"/".equals(str2)) {
                        putToSet(hashMap2, str2 + ".conf", str);
                        putToSet(hashMap2, str2 + ".properties", str);
                        putToSet(hashMap2, str2 + ".json", str);
                    }
                }
            }
        }
        for (String str3 : list) {
            if (str3.toLowerCase().startsWith("hocon:")) {
                List<String> list2 = (List) hashMap.get(str3);
                HashSet hashSet = new HashSet();
                for (String str4 : list2) {
                    if (!"/".equals(str4)) {
                        hashSet.addAll((Collection) hashMap2.get(str4));
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                for (String str5 : list) {
                    if (str3.toLowerCase().startsWith("hocon:") && str5 != str3 && hashSet.contains(str5)) {
                        arrayList2.addAll((Collection) hashMap.get(str5));
                    }
                }
                arrayList2.addAll((Collection) hashMap.get(str3));
                arrayList.add(makeHoconPathFromElements(arrayList2));
            } else {
                arrayList.add(str3);
            }
        }
        return arrayList;
    }

    private ConfigUtils() {
    }
}
