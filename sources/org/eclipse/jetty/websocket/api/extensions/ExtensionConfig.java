package org.eclipse.jetty.websocket.api.extensions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.jetty.websocket.api.util.QuoteUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/extensions/ExtensionConfig.class */
public class ExtensionConfig {
    private final String name;
    private final Map<String, String> parameters = new HashMap();

    public static ExtensionConfig parse(String parameterizedName) {
        return new ExtensionConfig(parameterizedName);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0049, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        if (r3 != null) goto L_0x000c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        if (r3.hasMoreElements() == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r0 = org.eclipse.jetty.websocket.api.util.QuoteUtil.splitAt(r3.nextElement(), ",");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002a, code lost:
        if (r0.hasNext() == false) goto L_0x000c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002d, code lost:
        r0.add(parse(r0.next()));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<org.eclipse.jetty.websocket.api.extensions.ExtensionConfig> parseEnum(java.util.Enumeration<java.lang.String> r3) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r3
            if (r0 == 0) goto L_0x0048
        L_0x000c:
            r0 = r3
            boolean r0 = r0.hasMoreElements()
            if (r0 == 0) goto L_0x0048
            r0 = r3
            java.lang.Object r0 = r0.nextElement()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = ","
            java.util.Iterator r0 = org.eclipse.jetty.websocket.api.util.QuoteUtil.splitAt(r0, r1)
            r5 = r0
        L_0x0024:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0045
            r0 = r5
            java.lang.Object r0 = r0.next()
            java.lang.String r0 = (java.lang.String) r0
            r6 = r0
            r0 = r4
            r1 = r6
            org.eclipse.jetty.websocket.api.extensions.ExtensionConfig r1 = parse(r1)
            boolean r0 = r0.add(r1)
            goto L_0x0024
        L_0x0045:
            goto L_0x000c
        L_0x0048:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.websocket.api.extensions.ExtensionConfig.parseEnum(java.util.Enumeration):java.util.List");
    }

    public static List<ExtensionConfig> parseList(String... rawSecWebSocketExtensions) {
        List<ExtensionConfig> configs = new ArrayList<>();
        for (String rawValue : rawSecWebSocketExtensions) {
            Iterator<String> extTokenIter = QuoteUtil.splitAt(rawValue, ",");
            while (extTokenIter.hasNext()) {
                configs.add(parse(extTokenIter.next()));
            }
        }
        return configs;
    }

    public static String toHeaderValue(List<ExtensionConfig> configs) {
        if (configs == null || configs.isEmpty()) {
            return null;
        }
        StringBuilder parameters = new StringBuilder();
        boolean needsDelim = false;
        for (ExtensionConfig ext : configs) {
            if (needsDelim) {
                parameters.append(", ");
            }
            parameters.append(ext.getParameterizedName());
            needsDelim = true;
        }
        return parameters.toString();
    }

    public ExtensionConfig(ExtensionConfig copy) {
        this.name = copy.name;
        this.parameters.putAll(copy.parameters);
    }

    public ExtensionConfig(String parameterizedName) {
        Iterator<String> extListIter = QuoteUtil.splitAt(parameterizedName, ";");
        this.name = extListIter.next();
        while (extListIter.hasNext()) {
            Iterator<String> extParamIter = QuoteUtil.splitAt(extListIter.next(), "=");
            String key = extParamIter.next().trim();
            String value = null;
            if (extParamIter.hasNext()) {
                value = extParamIter.next();
            }
            this.parameters.put(key, value);
        }
    }

    public String getName() {
        return this.name;
    }

    public final int getParameter(String key, int defValue) {
        String val = this.parameters.get(key);
        if (val == null) {
            return defValue;
        }
        return Integer.parseInt(val);
    }

    public final String getParameter(String key, String defValue) {
        String val = this.parameters.get(key);
        if (val == null) {
            return defValue;
        }
        return val;
    }

    public final String getParameterizedName() {
        StringBuilder str = new StringBuilder();
        str.append(this.name);
        for (String param : this.parameters.keySet()) {
            str.append(';');
            str.append(param);
            String value = this.parameters.get(param);
            if (value != null) {
                str.append('=');
                QuoteUtil.quoteIfNeeded(str, value, ";=");
            }
        }
        return str.toString();
    }

    public final Set<String> getParameterKeys() {
        return this.parameters.keySet();
    }

    public final Map<String, String> getParameters() {
        return this.parameters;
    }

    public final void init(ExtensionConfig other) {
        this.parameters.clear();
        this.parameters.putAll(other.parameters);
    }

    public final void setParameter(String key) {
        this.parameters.put(key, null);
    }

    public final void setParameter(String key, int value) {
        this.parameters.put(key, Integer.toString(value));
    }

    public final void setParameter(String key, String value) {
        this.parameters.put(key, value);
    }

    public String toString() {
        return getParameterizedName();
    }
}
