package org.eclipse.jetty.util;

import java.net.InetAddress;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/InetAddressSet.class */
public class InetAddressSet extends AbstractSet<String> implements Set<String>, Predicate<InetAddress> {
    private Map<String, InetPattern> _patterns = new HashMap();

    public boolean add(String pattern) {
        return this._patterns.put(pattern, newInetRange(pattern)) == null;
    }

    private InetPattern newInetRange(String pattern) {
        if (pattern == null) {
            return null;
        }
        int slash = pattern.lastIndexOf(47);
        int dash = pattern.lastIndexOf(45);
        try {
            if (slash >= 0) {
                return new CidrInetRange(pattern, InetAddress.getByName(pattern.substring(0, slash).trim()), StringUtil.toInt(pattern, slash + 1));
            }
            if (dash >= 0) {
                return new MinMaxInetRange(pattern, InetAddress.getByName(pattern.substring(0, dash).trim()), InetAddress.getByName(pattern.substring(dash + 1).trim()));
            }
            return new SingletonInetRange(pattern, InetAddress.getByName(pattern));
        } catch (Exception e) {
            if (slash < 0 && dash > 0) {
                try {
                    return new LegacyInetRange(pattern);
                } catch (Exception ex2) {
                    e.addSuppressed(ex2);
                    throw new IllegalArgumentException("Bad pattern: " + pattern, e);
                }
            }
            throw new IllegalArgumentException("Bad pattern: " + pattern, e);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object pattern) {
        return this._patterns.remove(pattern) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<String> iterator() {
        return this._patterns.keySet().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this._patterns.size();
    }

    public boolean test(InetAddress address) {
        if (address == null) {
            return false;
        }
        byte[] raw = address.getAddress();
        for (InetPattern pattern : this._patterns.values()) {
            if (pattern.test(address, raw)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/InetAddressSet$InetPattern.class */
    public static abstract class InetPattern {
        final String _pattern;

        abstract boolean test(InetAddress inetAddress, byte[] bArr);

        InetPattern(String pattern) {
            this._pattern = pattern;
        }

        public String toString() {
            return this._pattern;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/InetAddressSet$SingletonInetRange.class */
    public static class SingletonInetRange extends InetPattern {
        final InetAddress _address;

        public SingletonInetRange(String pattern, InetAddress address) {
            super(pattern);
            this._address = address;
        }

        @Override // org.eclipse.jetty.util.InetAddressSet.InetPattern
        public boolean test(InetAddress address, byte[] raw) {
            return this._address.equals(address);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/InetAddressSet$MinMaxInetRange.class */
    public static class MinMaxInetRange extends InetPattern {
        final int[] _min;
        final int[] _max;

        public MinMaxInetRange(String pattern, InetAddress min, InetAddress max) {
            super(pattern);
            byte[] rawMin = min.getAddress();
            byte[] rawMax = max.getAddress();
            if (rawMin.length != rawMax.length) {
                throw new IllegalArgumentException("Cannot mix IPv4 and IPv6: " + pattern);
            }
            if (rawMin.length == 4) {
                int count = 0;
                for (char c : pattern.toCharArray()) {
                    if (c == '.') {
                        count++;
                    }
                }
                if (count != 6) {
                    throw new IllegalArgumentException("Legacy pattern: " + pattern);
                }
            }
            this._min = new int[rawMin.length];
            this._max = new int[rawMin.length];
            for (int i = 0; i < this._min.length; i++) {
                this._min[i] = 255 & rawMin[i];
                this._max[i] = 255 & rawMax[i];
            }
            for (int i2 = 0; i2 < this._min.length; i2++) {
                if (this._min[i2] > this._max[i2]) {
                    throw new IllegalArgumentException("min is greater than max: " + pattern);
                } else if (this._min[i2] < this._max[i2]) {
                    return;
                }
            }
        }

        @Override // org.eclipse.jetty.util.InetAddressSet.InetPattern
        public boolean test(InetAddress item, byte[] raw) {
            if (raw.length != this._min.length) {
                return false;
            }
            boolean minOk = false;
            boolean maxOk = false;
            for (int i = 0; i < this._min.length; i++) {
                int r = 255 & raw[i];
                if (!minOk) {
                    if (r < this._min[i]) {
                        return false;
                    }
                    if (r > this._min[i]) {
                        minOk = true;
                    }
                }
                if (!maxOk) {
                    if (r > this._max[i]) {
                        return false;
                    }
                    if (r < this._max[i]) {
                        maxOk = true;
                    }
                }
                if (minOk && maxOk) {
                    return true;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/InetAddressSet$CidrInetRange.class */
    public static class CidrInetRange extends InetPattern {
        final byte[] _raw;
        final int _octets;
        final int _mask;
        final int _masked;

        public CidrInetRange(String pattern, InetAddress address, int cidr) {
            super(pattern);
            this._raw = address.getAddress();
            this._octets = cidr / 8;
            this._mask = 255 & (255 << (8 - (cidr % 8)));
            this._masked = this._mask == 0 ? 0 : this._raw[this._octets] & this._mask;
            if (cidr > this._raw.length * 8) {
                throw new IllegalArgumentException("CIDR too large: " + pattern);
            } else if (this._mask == 0 || (255 & this._raw[this._octets]) == this._masked) {
                for (int o = this._octets + (this._mask == 0 ? 0 : 1); o < this._raw.length; o++) {
                    if (this._raw[o] != 0) {
                        throw new IllegalArgumentException("CIDR bits non zero: " + pattern);
                    }
                }
            } else {
                throw new IllegalArgumentException("CIDR bits non zero: " + pattern);
            }
        }

        @Override // org.eclipse.jetty.util.InetAddressSet.InetPattern
        public boolean test(InetAddress item, byte[] raw) {
            if (raw.length != this._raw.length) {
                return false;
            }
            for (int o = 0; o < this._octets; o++) {
                if (this._raw[o] != raw[o]) {
                    return false;
                }
            }
            return this._mask == 0 || (raw[this._octets] & this._mask) == this._masked;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/InetAddressSet$LegacyInetRange.class */
    public static class LegacyInetRange extends InetPattern {
        int[] _min = new int[4];
        int[] _max = new int[4];

        public LegacyInetRange(String pattern) {
            super(pattern);
            String[] parts = pattern.split("\\.");
            if (parts.length != 4) {
                throw new IllegalArgumentException("Bad legacy pattern: " + pattern);
            }
            for (int i = 0; i < 4; i++) {
                String part = parts[i].trim();
                int dash = part.indexOf(45);
                if (dash < 0) {
                    int[] iArr = this._min;
                    int[] iArr2 = this._max;
                    int parseInt = Integer.parseInt(part);
                    iArr2[i] = parseInt;
                    iArr[i] = parseInt;
                } else {
                    this._min[i] = dash == 0 ? 0 : StringUtil.toInt(part, 0);
                    this._max[i] = dash == part.length() - 1 ? 255 : StringUtil.toInt(part, dash + 1);
                }
                if (this._min[i] < 0 || this._min[i] > this._max[i] || this._max[i] > 255) {
                    throw new IllegalArgumentException("Bad legacy pattern: " + pattern);
                }
            }
        }

        @Override // org.eclipse.jetty.util.InetAddressSet.InetPattern
        public boolean test(InetAddress item, byte[] raw) {
            if (raw.length != 4) {
                return false;
            }
            for (int i = 0; i < 4; i++) {
                if ((255 & raw[i]) < this._min[i] || (255 & raw[i]) > this._max[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}
