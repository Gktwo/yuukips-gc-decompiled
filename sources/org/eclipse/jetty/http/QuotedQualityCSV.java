package org.eclipse.jetty.http;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import org.eclipse.jetty.util.log.Log;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/QuotedQualityCSV.class */
public class QuotedQualityCSV extends QuotedCSV implements Iterable<String> {
    public static ToIntFunction<String> MOST_SPECIFIC_MIME_ORDERING = s -> {
        if ("*/*".equals(s)) {
            return 0;
        }
        if (s.endsWith("/*")) {
            return 1;
        }
        if (s.indexOf(59) < 0) {
            return 2;
        }
        return 3;
    };
    private final List<QualityValue> _qualities;
    private QualityValue _lastQuality;
    private boolean _sorted;
    private final ToIntFunction<String> _secondaryOrdering;

    public QuotedQualityCSV() {
        this((ToIntFunction<String>) null);
    }

    public QuotedQualityCSV(String[] preferredOrder) {
        this(s -> {
            for (int i = 0; i < preferredOrder.length; i++) {
                if (preferredOrder[i].equals(s)) {
                    return preferredOrder.length - i;
                }
            }
            if ("*".equals(s)) {
                return preferredOrder.length;
            }
            return 0;
        });
    }

    public QuotedQualityCSV(ToIntFunction<String> secondaryOrdering) {
        super(new String[0]);
        this._qualities = new ArrayList();
        this._sorted = false;
        this._secondaryOrdering = secondaryOrdering == null ? s -> {
            return 0;
        } : secondaryOrdering;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.http.QuotedCSV, org.eclipse.jetty.http.QuotedCSVParser
    public void parsedValueAndParams(StringBuffer buffer) {
        parsedValueAndParams(buffer);
        this._lastQuality = new QualityValue(this._lastQuality._quality, buffer.toString(), this._lastQuality._index);
        this._qualities.set(this._lastQuality._index, this._lastQuality);
    }

    @Override // org.eclipse.jetty.http.QuotedCSVParser
    protected void parsedValue(StringBuffer buffer) {
        parsedValue(buffer);
        this._sorted = false;
        this._lastQuality = new QualityValue(1.0d, buffer.toString(), this._qualities.size());
        this._qualities.add(this._lastQuality);
    }

    /* JADX WARN: Type inference failed for: r0v23, types: [double] */
    @Override // org.eclipse.jetty.http.QuotedCSVParser
    protected void parsedParam(StringBuffer buffer, int valueLength, int paramName, int paramValue) {
        char c;
        Double d;
        this._sorted = false;
        if (paramName < 0) {
            if (buffer.charAt(buffer.length() - 1) == ';') {
                buffer.setLength(buffer.length() - 1);
            }
        } else if (paramValue >= 0 && buffer.charAt(paramName) == 'q' && paramValue > paramName && buffer.length() >= paramName && buffer.charAt(paramName + 1) == '=') {
            try {
                if (!this._keepQuotes || buffer.charAt(paramValue) != '\"') {
                    d = Double.valueOf(buffer.substring(paramValue));
                } else {
                    d = Double.valueOf(buffer.substring(paramValue + 1, buffer.length() - 1));
                }
                c = d.doubleValue();
            } catch (Exception e) {
                Log.getLogger(QuotedQualityCSV.class).ignore(e);
                c = 0;
            }
            buffer.setLength(Math.max(0, paramName - 1));
            if (c != 1.0d) {
                this._lastQuality = new QualityValue(c, buffer.toString(), this._lastQuality._index);
                this._qualities.set(this._lastQuality._index, this._lastQuality);
            }
        }
    }

    @Override // org.eclipse.jetty.http.QuotedCSV
    public List<String> getValues() {
        if (!this._sorted) {
            sort();
        }
        return this._values;
    }

    @Override // org.eclipse.jetty.http.QuotedCSV, java.lang.Iterable
    public Iterator<String> iterator() {
        if (!this._sorted) {
            sort();
        }
        return this._values.iterator();
    }

    protected void sort() {
        this._values.clear();
        this._qualities.stream().filter(qv -> {
            return qv._quality != 0.0d;
        }).sorted().map(rec$ -> {
            return ((QualityValue) rec$).getValue();
        }).collect(Collectors.toCollection(() -> {
            return this._values;
        }));
        this._sorted = true;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/QuotedQualityCSV$QualityValue.class */
    public class QualityValue implements Comparable<QualityValue> {
        private final double _quality;
        private final String _value;
        private final int _index;

        private QualityValue(double quality, String value, int index) {
            this._quality = quality;
            this._value = value;
            this._index = index;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Double.hashCode(this._quality) ^ Objects.hash(this._value, Integer.valueOf(this._index));
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (!(obj instanceof QualityValue)) {
                return false;
            }
            QualityValue qv = (QualityValue) obj;
            return this._quality == qv._quality && Objects.equals(this._value, qv._value) && Objects.equals(Integer.valueOf(this._index), Integer.valueOf(qv._index));
        }

        /* access modifiers changed from: private */
        public String getValue() {
            return this._value;
        }

        public int compareTo(QualityValue o) {
            int compare = Double.compare(o._quality, this._quality);
            if (compare == 0) {
                compare = Integer.compare(QuotedQualityCSV.this._secondaryOrdering.applyAsInt(o._value), QuotedQualityCSV.this._secondaryOrdering.applyAsInt(this._value));
                if (compare == 0) {
                    compare = -Integer.compare(o._index, this._index);
                }
            }
            return compare;
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("%s@%x[%s,q=%f,i=%d]", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._value, Double.valueOf(this._quality), Integer.valueOf(this._index));
        }
    }
}
