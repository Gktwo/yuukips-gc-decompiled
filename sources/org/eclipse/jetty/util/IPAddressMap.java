package org.eclipse.jetty.util;

import dev.morphia.mapping.Mapper;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/IPAddressMap.class */
public class IPAddressMap<TYPE> extends HashMap<String, TYPE> {
    private final HashMap<String, IPAddrPattern> _patterns = new HashMap<>();

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((String) obj, (String) obj2);
    }

    public IPAddressMap() {
        super(11);
    }

    public IPAddressMap(int capacity) {
        super(capacity);
    }

    public TYPE put(String addrSpec, TYPE object) throws IllegalArgumentException {
        if (addrSpec == null || addrSpec.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid IP address pattern: " + addrSpec);
        }
        String spec = addrSpec.trim();
        if (this._patterns.get(spec) == null) {
            this._patterns.put(spec, new IPAddrPattern(spec));
        }
        return put((IPAddressMap<TYPE>) spec, (String) object);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public TYPE get(Object key) {
        return get(key);
    }

    public TYPE match(String addr) {
        Map.Entry<String, TYPE> entry = getMatch(addr);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public Map.Entry<String, TYPE> getMatch(String addr) {
        if (addr == null) {
            return null;
        }
        for (Map.Entry<String, TYPE> entry : entrySet()) {
            if (this._patterns.get(entry.getKey()).match(addr)) {
                return entry;
            }
        }
        return null;
    }

    public Object getLazyMatches(String addr) {
        if (addr == null) {
            return LazyList.getList(entrySet());
        }
        Object entries = null;
        for (Map.Entry<String, TYPE> entry : entrySet()) {
            if (this._patterns.get(entry.getKey()).match(addr)) {
                entries = LazyList.add(entries, entry);
            }
        }
        return entries;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/IPAddressMap$IPAddrPattern.class */
    public static class IPAddrPattern {
        private final OctetPattern[] _octets = new OctetPattern[4];

        public IPAddrPattern(String value) throws IllegalArgumentException {
            if (value == null || value.trim().length() == 0) {
                throw new IllegalArgumentException("Invalid IP address pattern: " + value);
            }
            try {
                StringTokenizer parts = new StringTokenizer(value, Mapper.IGNORED_FIELDNAME);
                for (int idx = 0; idx < 4; idx++) {
                    String part = parts.hasMoreTokens() ? parts.nextToken().trim() : "0-255";
                    int len = part.length();
                    if (len != 0 || !parts.hasMoreTokens()) {
                        this._octets[idx] = new OctetPattern(len == 0 ? "0-255" : part);
                    } else {
                        throw new IllegalArgumentException("Invalid IP address pattern: " + value);
                    }
                }
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Invalid IP address pattern: " + value, ex);
            }
        }

        public boolean match(String value) throws IllegalArgumentException {
            if (value == null || value.trim().length() == 0) {
                throw new IllegalArgumentException("Invalid IP address: " + value);
            }
            try {
                StringTokenizer parts = new StringTokenizer(value, Mapper.IGNORED_FIELDNAME);
                boolean result = true;
                for (int idx = 0; idx < 4; idx++) {
                    if (!parts.hasMoreTokens()) {
                        throw new IllegalArgumentException("Invalid IP address: " + value);
                    }
                    boolean match = result & this._octets[idx].match(parts.nextToken());
                    result = match;
                    if (!match) {
                        break;
                    }
                }
                return result;
            } catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException("Invalid IP address: " + value, ex);
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/IPAddressMap$OctetPattern.class */
    public static class OctetPattern extends BitSet {
        private final BitSet _mask = new BitSet(256);

        public OctetPattern(String octetSpec) throws IllegalArgumentException {
            if (octetSpec != null) {
                try {
                    String spec = octetSpec.trim();
                    if (spec.length() == 0) {
                        this._mask.set(0, 255);
                    } else {
                        StringTokenizer parts = new StringTokenizer(spec, ",");
                        while (parts.hasMoreTokens()) {
                            String part = parts.nextToken().trim();
                            if (part.length() > 0) {
                                if (part.indexOf(45) < 0) {
                                    this._mask.set(Integer.parseInt(part));
                                } else {
                                    int low = 0;
                                    int high = 255;
                                    String[] bounds = part.split("-", -2);
                                    if (bounds.length != 2) {
                                        throw new IllegalArgumentException("Invalid octet spec: " + octetSpec);
                                    }
                                    low = bounds[0].length() > 0 ? Integer.parseInt(bounds[0]) : low;
                                    high = bounds[1].length() > 0 ? Integer.parseInt(bounds[1]) : high;
                                    if (low > high) {
                                        throw new IllegalArgumentException("Invalid octet spec: " + octetSpec);
                                    }
                                    this._mask.set(low, high + 1);
                                }
                            }
                        }
                    }
                } catch (NumberFormatException ex) {
                    throw new IllegalArgumentException("Invalid octet spec: " + octetSpec, ex);
                }
            }
        }

        public boolean match(String value) throws IllegalArgumentException {
            if (value == null || value.trim().length() == 0) {
                throw new IllegalArgumentException("Invalid octet: " + value);
            }
            try {
                return match(Integer.parseInt(value));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid octet: " + value);
            }
        }

        public boolean match(int number) throws IllegalArgumentException {
            if (number >= 0 && number <= 255) {
                return this._mask.get(number);
            }
            throw new IllegalArgumentException("Invalid octet: " + number);
        }
    }
}
