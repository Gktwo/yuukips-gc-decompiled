package org.quartz.utils;

import dev.morphia.mapping.Mapper;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.StringTokenizer;

/* loaded from: grasscutter.jar:org/quartz/utils/PropertiesParser.class */
public class PropertiesParser {
    Properties props;

    public PropertiesParser(Properties props) {
        this.props = null;
        this.props = props;
    }

    public Properties getUnderlyingProperties() {
        return this.props;
    }

    public String getStringProperty(String name) {
        return getStringProperty(name, null);
    }

    public String getStringProperty(String name, String def) {
        String val = this.props.getProperty(name, def);
        if (val == null) {
            return def;
        }
        String val2 = val.trim();
        return val2.length() == 0 ? def : val2;
    }

    public String[] getStringArrayProperty(String name) {
        return getStringArrayProperty(name, null);
    }

    public String[] getStringArrayProperty(String name, String[] def) {
        String vals = getStringProperty(name);
        if (vals == null) {
            return def;
        }
        StringTokenizer stok = new StringTokenizer(vals, ",");
        ArrayList<String> strs = new ArrayList<>();
        while (stok.hasMoreTokens()) {
            try {
                strs.add(stok.nextToken().trim());
            } catch (Exception e) {
                return def;
            }
        }
        return (String[]) strs.toArray(new String[strs.size()]);
    }

    public boolean getBooleanProperty(String name) {
        return getBooleanProperty(name, false);
    }

    public boolean getBooleanProperty(String name, boolean def) {
        String val = getStringProperty(name);
        return val == null ? def : Boolean.valueOf(val).booleanValue();
    }

    public byte getByteProperty(String name) throws NumberFormatException {
        String val = getStringProperty(name);
        if (val == null) {
            throw new NumberFormatException(" null string");
        }
        try {
            return Byte.parseByte(val);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(" '" + val + "'");
        }
    }

    public byte getByteProperty(String name, byte def) throws NumberFormatException {
        String val = getStringProperty(name);
        if (val == null) {
            return def;
        }
        try {
            return Byte.parseByte(val);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(" '" + val + "'");
        }
    }

    public char getCharProperty(String name) {
        return getCharProperty(name, 0);
    }

    public char getCharProperty(String name, char def) {
        String param = getStringProperty(name);
        return param == null ? def : param.charAt(0);
    }

    public double getDoubleProperty(String name) throws NumberFormatException {
        String val = getStringProperty(name);
        if (val == null) {
            throw new NumberFormatException(" null string");
        }
        try {
            return Double.parseDouble(val);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(" '" + val + "'");
        }
    }

    public double getDoubleProperty(String name, double def) throws NumberFormatException {
        String val = getStringProperty(name);
        if (val == null) {
            return def;
        }
        try {
            return Double.parseDouble(val);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(" '" + val + "'");
        }
    }

    public float getFloatProperty(String name) throws NumberFormatException {
        String val = getStringProperty(name);
        if (val == null) {
            throw new NumberFormatException(" null string");
        }
        try {
            return Float.parseFloat(val);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(" '" + val + "'");
        }
    }

    public float getFloatProperty(String name, float def) throws NumberFormatException {
        String val = getStringProperty(name);
        if (val == null) {
            return def;
        }
        try {
            return Float.parseFloat(val);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(" '" + val + "'");
        }
    }

    public int getIntProperty(String name) throws NumberFormatException {
        String val = getStringProperty(name);
        if (val == null) {
            throw new NumberFormatException(" null string");
        }
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(" '" + val + "'");
        }
    }

    public int getIntProperty(String name, int def) throws NumberFormatException {
        String val = getStringProperty(name);
        if (val == null) {
            return def;
        }
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(" '" + val + "'");
        }
    }

    public int[] getIntArrayProperty(String name) throws NumberFormatException {
        return getIntArrayProperty(name, null);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0041
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public int[] getIntArrayProperty(java.lang.String r6, int[] r7) throws java.lang.NumberFormatException {
        /*
            r5 = this;
            r0 = r5
            r1 = r6
            java.lang.String r0 = r0.getStringProperty(r1)
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L_0x000c
            r0 = r7
            return r0
        L_0x000c:
            java.util.StringTokenizer r0 = new java.util.StringTokenizer
            r1 = r0
            r2 = r8
            java.lang.String r3 = ","
            r1.<init>(r2, r3)
            r9 = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r10 = r0
        L_0x0021:
            r0 = r9
            boolean r0 = r0.hasMoreTokens()     // Catch: Exception -> 0x0094
            if (r0 == 0) goto L_0x0063
            r0 = r10
            java.lang.Integer r1 = new java.lang.Integer     // Catch: Exception -> 0x0094, NumberFormatException -> 0x0041
            r2 = r1
            r3 = r9
            java.lang.String r3 = r3.nextToken()     // Catch: Exception -> 0x0094, NumberFormatException -> 0x0041
            java.lang.String r3 = r3.trim()     // Catch: Exception -> 0x0094, NumberFormatException -> 0x0041
            r2.<init>(r3)     // Catch: Exception -> 0x0094, NumberFormatException -> 0x0041
            boolean r0 = r0.add(r1)     // Catch: Exception -> 0x0094, NumberFormatException -> 0x0041
            goto L_0x0021
        L_0x0041:
            r11 = move-exception
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException     // Catch: Exception -> 0x0094
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: Exception -> 0x0094
            r3 = r2
            r3.<init>()     // Catch: Exception -> 0x0094
            java.lang.String r3 = " '"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: Exception -> 0x0094
            r3 = r8
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: Exception -> 0x0094
            java.lang.String r3 = "'"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: Exception -> 0x0094
            java.lang.String r2 = r2.toString()     // Catch: Exception -> 0x0094
            r1.<init>(r2)     // Catch: Exception -> 0x0094
            throw r0     // Catch: Exception -> 0x0094
        L_0x0063:
            r0 = r10
            int r0 = r0.size()     // Catch: Exception -> 0x0094
            int[] r0 = new int[r0]     // Catch: Exception -> 0x0094
            r11 = r0
            r0 = 0
            r12 = r0
        L_0x006f:
            r0 = r12
            r1 = r10
            int r1 = r1.size()     // Catch: Exception -> 0x0094
            if (r0 >= r1) goto L_0x0091
            r0 = r11
            r1 = r12
            r2 = r10
            r3 = r12
            java.lang.Object r2 = r2.get(r3)     // Catch: Exception -> 0x0094
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch: Exception -> 0x0094
            int r2 = r2.intValue()     // Catch: Exception -> 0x0094
            r0[r1] = r2     // Catch: Exception -> 0x0094
            int r12 = r12 + 1
            goto L_0x006f
        L_0x0091:
            r0 = r11
            return r0
        L_0x0094:
            r11 = move-exception
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.utils.PropertiesParser.getIntArrayProperty(java.lang.String, int[]):int[]");
    }

    public long getLongProperty(String name) throws NumberFormatException {
        String val = getStringProperty(name);
        if (val == null) {
            throw new NumberFormatException(" null string");
        }
        try {
            return Long.parseLong(val);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(" '" + val + "'");
        }
    }

    public long getLongProperty(String name, long def) throws NumberFormatException {
        String val = getStringProperty(name);
        if (val == null) {
            return def;
        }
        try {
            return Long.parseLong(val);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(" '" + val + "'");
        }
    }

    public short getShortProperty(String name) throws NumberFormatException {
        String val = getStringProperty(name);
        if (val == null) {
            throw new NumberFormatException(" null string");
        }
        try {
            return Short.parseShort(val);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(" '" + val + "'");
        }
    }

    public short getShortProperty(String name, short def) throws NumberFormatException {
        String val = getStringProperty(name);
        if (val == null) {
            return def;
        }
        try {
            return Short.parseShort(val);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(" '" + val + "'");
        }
    }

    public String[] getPropertyGroups(String prefix) {
        Enumeration<?> keys = this.props.propertyNames();
        HashSet<String> groups = new HashSet<>(10);
        if (!prefix.endsWith(Mapper.IGNORED_FIELDNAME)) {
            prefix = prefix + Mapper.IGNORED_FIELDNAME;
        }
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            if (key.startsWith(prefix)) {
                groups.add(key.substring(prefix.length(), key.indexOf(46, prefix.length())));
            }
        }
        return (String[]) groups.toArray(new String[groups.size()]);
    }

    public Properties getPropertyGroup(String prefix) {
        return getPropertyGroup(prefix, false, null);
    }

    public Properties getPropertyGroup(String prefix, boolean stripPrefix) {
        return getPropertyGroup(prefix, stripPrefix, null);
    }

    public Properties getPropertyGroup(String prefix, boolean stripPrefix, String[] excludedPrefixes) {
        Enumeration<?> keys = this.props.propertyNames();
        Properties group = new Properties();
        if (!prefix.endsWith(Mapper.IGNORED_FIELDNAME)) {
            prefix = prefix + Mapper.IGNORED_FIELDNAME;
        }
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            if (key.startsWith(prefix)) {
                boolean exclude = false;
                if (excludedPrefixes != null) {
                    for (int i = 0; i < excludedPrefixes.length && !exclude; i++) {
                        exclude = key.startsWith(excludedPrefixes[i]);
                    }
                }
                if (!exclude) {
                    String value = getStringProperty(key, "");
                    if (stripPrefix) {
                        group.put(key.substring(prefix.length()), value);
                    } else {
                        group.put(key, value);
                    }
                }
            }
        }
        return group;
    }
}
