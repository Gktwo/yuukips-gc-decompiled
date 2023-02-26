package org.eclipse.jetty.http;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;
import org.eclipse.jetty.util.ArrayTernaryTrie;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.Trie;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpFields.class */
public class HttpFields implements Iterable<HttpField> {
    @Deprecated
    public static final String __separators = ", \t";
    private HttpField[] _fields;
    private int _size;
    private static final Logger LOG = Log.getLogger(HttpFields.class);
    @Deprecated
    private static final Float __one = new Float("1.0");
    @Deprecated
    private static final Float __zero = new Float("0.0");
    @Deprecated
    private static final Trie<Float> __qualities = new ArrayTernaryTrie();

    static /* synthetic */ int access$108(HttpFields x0) {
        int i = x0._size;
        x0._size = i + 1;
        return i;
    }

    static {
        __qualities.put("*", __one);
        __qualities.put("1.0", __one);
        __qualities.put("1", __one);
        __qualities.put("0.9", new Float("0.9"));
        __qualities.put("0.8", new Float("0.8"));
        __qualities.put("0.7", new Float("0.7"));
        __qualities.put("0.66", new Float("0.66"));
        __qualities.put("0.6", new Float("0.6"));
        __qualities.put("0.5", new Float("0.5"));
        __qualities.put("0.4", new Float("0.4"));
        __qualities.put("0.33", new Float("0.33"));
        __qualities.put("0.3", new Float("0.3"));
        __qualities.put("0.2", new Float("0.2"));
        __qualities.put("0.1", new Float("0.1"));
        __qualities.put("0", __zero);
        __qualities.put("0.0", __zero);
    }

    public HttpFields() {
        this(16);
    }

    public HttpFields(int capacity) {
        this._fields = new HttpField[capacity];
    }

    public HttpFields(HttpFields fields) {
        this._fields = (HttpField[]) Arrays.copyOf(fields._fields, fields._fields.length);
        this._size = fields._size;
    }

    public void computeField(HttpHeader header, BiFunction<HttpHeader, List<HttpField>, HttpField> computeFn) {
        computeField(header, computeFn, f, h -> {
            return Boolean.valueOf(f.getHeader() == h);
        });
    }

    public void computeField(String name, BiFunction<String, List<HttpField>, HttpField> computeFn) {
        computeField(name, computeFn, (v0, v1) -> {
            return v0.m43is(v1);
        });
    }

    private <T> void computeField(T header, BiFunction<T, List<HttpField>, HttpField> computeFn, BiFunction<HttpField, T, Boolean> matcher) {
        List<HttpField> found;
        int first = -1;
        int i = 0;
        while (true) {
            if (i >= this._size) {
                break;
            } else if (matcher.apply(this._fields[i], header).booleanValue()) {
                first = i;
                break;
            } else {
                i++;
            }
        }
        if (first < 0) {
            HttpField newField = computeFn.apply(header, null);
            if (newField != null) {
                add(newField);
                return;
            }
            return;
        }
        List<HttpField> found2 = null;
        int i2 = first + 1;
        while (i2 < this._size) {
            HttpField f = this._fields[i2];
            if (matcher.apply(f, header).booleanValue()) {
                if (found2 == null) {
                    found2 = new ArrayList<>();
                    found2.add(this._fields[first]);
                }
                found2.add(f);
                i2--;
                remove(i2);
            }
            i2++;
        }
        if (found2 == null) {
            found = Collections.singletonList(this._fields[first]);
        } else {
            found = Collections.unmodifiableList(found2);
        }
        HttpField newField2 = computeFn.apply(header, found);
        if (newField2 == null) {
            remove(first);
        } else {
            this._fields[first] = newField2;
        }
    }

    public int size() {
        return this._size;
    }

    @Override // java.lang.Iterable
    public Iterator<HttpField> iterator() {
        return new ListItr();
    }

    public ListIterator<HttpField> listIterator() {
        return new ListItr();
    }

    public Stream<HttpField> stream() {
        return Arrays.stream(this._fields).limit((long) this._size);
    }

    public Set<String> getFieldNamesCollection() {
        Set<String> set = null;
        for (int i = 0; i < this._size; i++) {
            HttpField f = this._fields[i];
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(f.getName());
        }
        return set == null ? Collections.emptySet() : set;
    }

    public Enumeration<String> getFieldNames() {
        return Collections.enumeration(getFieldNamesCollection());
    }

    public HttpField getField(int index) {
        if (index < this._size) {
            return this._fields[index];
        }
        throw new NoSuchElementException();
    }

    public HttpField getField(HttpHeader header) {
        for (int i = 0; i < this._size; i++) {
            HttpField f = this._fields[i];
            if (f.getHeader() == header) {
                return f;
            }
        }
        return null;
    }

    public HttpField getField(String name) {
        for (int i = 0; i < this._size; i++) {
            HttpField f = this._fields[i];
            if (f.m43is(name)) {
                return f;
            }
        }
        return null;
    }

    public List<HttpField> getFields(HttpHeader header) {
        List<HttpField> fields = null;
        for (int i = 0; i < this._size; i++) {
            HttpField f = this._fields[i];
            if (f.getHeader() == header) {
                if (fields == null) {
                    fields = new ArrayList<>();
                }
                fields.add(f);
            }
        }
        return fields == null ? Collections.emptyList() : fields;
    }

    public List<HttpField> getFields(String name) {
        List<HttpField> fields = null;
        for (int i = 0; i < this._size; i++) {
            HttpField f = this._fields[i];
            if (f.m43is(name)) {
                if (fields == null) {
                    fields = new ArrayList<>();
                }
                fields.add(f);
            }
        }
        return fields == null ? Collections.emptyList() : fields;
    }

    public boolean contains(HttpField field) {
        int i = this._size;
        while (true) {
            i--;
            if (i <= 0) {
                return false;
            }
            HttpField f = this._fields[i];
            if (f.isSameName(field) && (f.equals(field) || f.contains(field.getValue()))) {
                return true;
            }
        }
    }

    public boolean contains(HttpHeader header, String value) {
        int i = this._size;
        while (true) {
            i--;
            if (i <= 0) {
                return false;
            }
            HttpField f = this._fields[i];
            if (f.getHeader() == header && f.contains(value)) {
                return true;
            }
        }
    }

    public boolean contains(String name, String value) {
        int i = this._size;
        while (true) {
            i--;
            if (i <= 0) {
                return false;
            }
            HttpField f = this._fields[i];
            if (f.m43is(name) && f.contains(value)) {
                return true;
            }
        }
    }

    public boolean contains(HttpHeader header) {
        int i = this._size;
        do {
            i--;
            if (i <= 0) {
                return false;
            }
        } while (this._fields[i].getHeader() != header);
        return true;
    }

    public boolean containsKey(String name) {
        int i = this._size;
        do {
            i--;
            if (i <= 0) {
                return false;
            }
        } while (!this._fields[i].m43is(name));
        return true;
    }

    @Deprecated
    public String getStringField(HttpHeader header) {
        return get(header);
    }

    public String get(HttpHeader header) {
        for (int i = 0; i < this._size; i++) {
            HttpField f = this._fields[i];
            if (f.getHeader() == header) {
                return f.getValue();
            }
        }
        return null;
    }

    @Deprecated
    public String getStringField(String name) {
        return get(name);
    }

    public String get(String header) {
        for (int i = 0; i < this._size; i++) {
            HttpField f = this._fields[i];
            if (f.m43is(header)) {
                return f.getValue();
            }
        }
        return null;
    }

    public List<String> getValuesList(HttpHeader header) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < this._size; i++) {
            HttpField f = this._fields[i];
            if (f.getHeader() == header) {
                list.add(f.getValue());
            }
        }
        return list;
    }

    public List<String> getValuesList(String name) {
        List<String> list = null;
        for (int i = 0; i < this._size; i++) {
            HttpField f = this._fields[i];
            if (f.m43is(name)) {
                if (list == null) {
                    list = new ArrayList<>(size() - i);
                }
                list.add(f.getValue());
            }
        }
        return list == null ? Collections.emptyList() : list;
    }

    public boolean addCSV(HttpHeader header, String... values) {
        QuotedCSV existing = null;
        for (int i = 0; i < this._size; i++) {
            HttpField f = this._fields[i];
            if (f.getHeader() == header) {
                if (existing == null) {
                    existing = new QuotedCSV(false, new String[0]);
                }
                existing.addValue(f.getValue());
            }
        }
        String value = addCSV(existing, values);
        if (value == null) {
            return false;
        }
        add(header, value);
        return true;
    }

    public boolean addCSV(String name, String... values) {
        QuotedCSV existing = null;
        for (int i = 0; i < this._size; i++) {
            HttpField f = this._fields[i];
            if (f.m43is(name)) {
                if (existing == null) {
                    existing = new QuotedCSV(false, new String[0]);
                }
                existing.addValue(f.getValue());
            }
        }
        String value = addCSV(existing, values);
        if (value == null) {
            return false;
        }
        add(name, value);
        return true;
    }

    protected String addCSV(QuotedCSV existing, String... values) {
        boolean add = true;
        if (existing != null && !existing.isEmpty()) {
            add = false;
            int i = values.length;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                if (existing.getValues().contains(QuotedCSV.unquote(values[i]))) {
                    values[i] = null;
                } else {
                    add = true;
                }
            }
        }
        if (!add) {
            return null;
        }
        StringBuilder value = new StringBuilder();
        for (String v : values) {
            if (v != null) {
                if (value.length() > 0) {
                    value.append(", ");
                }
                value.append(v);
            }
        }
        if (value.length() > 0) {
            return value.toString();
        }
        return null;
    }

    public List<String> getCSV(HttpHeader header, boolean keepQuotes) {
        QuotedCSV values = null;
        Iterator<HttpField> it = iterator();
        while (it.hasNext()) {
            HttpField f = it.next();
            if (f.getHeader() == header) {
                if (values == null) {
                    values = new QuotedCSV(keepQuotes, new String[0]);
                }
                values.addValue(f.getValue());
            }
        }
        return values == null ? Collections.emptyList() : values.getValues();
    }

    public List<String> getCSV(String name, boolean keepQuotes) {
        QuotedCSV values = null;
        Iterator<HttpField> it = iterator();
        while (it.hasNext()) {
            HttpField f = it.next();
            if (f.m43is(name)) {
                if (values == null) {
                    values = new QuotedCSV(keepQuotes, new String[0]);
                }
                values.addValue(f.getValue());
            }
        }
        return values == null ? Collections.emptyList() : values.getValues();
    }

    public List<String> getQualityCSV(HttpHeader header) {
        return getQualityCSV(header, null);
    }

    public List<String> getQualityCSV(HttpHeader header, ToIntFunction<String> secondaryOrdering) {
        QuotedQualityCSV values = null;
        Iterator<HttpField> it = iterator();
        while (it.hasNext()) {
            HttpField f = it.next();
            if (f.getHeader() == header) {
                if (values == null) {
                    values = new QuotedQualityCSV(secondaryOrdering);
                }
                values.addValue(f.getValue());
            }
        }
        return values == null ? Collections.emptyList() : values.getValues();
    }

    public List<String> getQualityCSV(String name) {
        QuotedQualityCSV values = null;
        Iterator<HttpField> it = iterator();
        while (it.hasNext()) {
            HttpField f = it.next();
            if (f.m43is(name)) {
                if (values == null) {
                    values = new QuotedQualityCSV();
                }
                values.addValue(f.getValue());
            }
        }
        return values == null ? Collections.emptyList() : values.getValues();
    }

    public Enumeration<String> getValues(final String name) {
        for (final int i = 0; i < this._size; i++) {
            final HttpField f = this._fields[i];
            if (f.m43is(name) && f.getValue() != null) {
                return new Enumeration<String>() { // from class: org.eclipse.jetty.http.HttpFields.1
                    HttpField field;

                    /* renamed from: i */
                    int f3098i;

                    {
                        this.field = f;
                        this.f3098i = i + 1;
                    }

                    @Override // java.util.Enumeration
                    public boolean hasMoreElements() {
                        if (this.field != null) {
                            return true;
                        }
                        while (this.f3098i < HttpFields.this._size) {
                            HttpField[] httpFieldArr = HttpFields.this._fields;
                            int i2 = this.f3098i;
                            this.f3098i = i2 + 1;
                            this.field = httpFieldArr[i2];
                            if (this.field.m43is(name) && this.field.getValue() != null) {
                                return true;
                            }
                        }
                        this.field = null;
                        return false;
                    }

                    @Override // java.util.Enumeration
                    public String nextElement() throws NoSuchElementException {
                        if (hasMoreElements()) {
                            String value = this.field.getValue();
                            this.field = null;
                            return value;
                        }
                        throw new NoSuchElementException();
                    }
                };
            }
        }
        return Collections.enumeration(Collections.emptyList());
    }

    @Deprecated
    public Enumeration<String> getValues(String name, final String separators) {
        final Enumeration<String> e = getValues(name);
        if (e == null) {
            return null;
        }
        return new Enumeration<String>() { // from class: org.eclipse.jetty.http.HttpFields.2
            QuotedStringTokenizer tok = null;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                if (this.tok != null && this.tok.hasMoreElements()) {
                    return true;
                }
                while (e.hasMoreElements()) {
                    String value = (String) e.nextElement();
                    if (value != null) {
                        this.tok = new QuotedStringTokenizer(value, separators, false, false);
                        if (this.tok.hasMoreElements()) {
                            return true;
                        }
                    }
                }
                this.tok = null;
                return false;
            }

            @Override // java.util.Enumeration
            public String nextElement() throws NoSuchElementException {
                if (!hasMoreElements()) {
                    throw new NoSuchElementException();
                }
                String next = (String) this.tok.nextElement();
                if (next != null) {
                    next = next.trim();
                }
                return next;
            }
        };
    }

    public void put(HttpField field) {
        boolean put = false;
        int i = this._size;
        while (true) {
            i--;
            if (i <= 0) {
                break;
            } else if (this._fields[i].isSameName(field)) {
                if (put) {
                    this._size--;
                    System.arraycopy(this._fields, i + 1, this._fields, i, this._size - i);
                } else {
                    this._fields[i] = field;
                    put = true;
                }
            }
        }
        if (!put) {
            add(field);
        }
    }

    public void put(String name, String value) {
        if (value == null) {
            remove(name);
        } else {
            put(new HttpField(name, value));
        }
    }

    public void put(HttpHeader header, HttpHeaderValue value) {
        put(header, value.toString());
    }

    public void put(HttpHeader header, String value) {
        Objects.requireNonNull(header, "header must not be null");
        if (value == null) {
            remove(header);
        } else {
            put(new HttpField(header, value));
        }
    }

    public void put(String name, List<String> list) {
        Objects.requireNonNull(name, "name must not be null");
        remove(name);
        if (list != null) {
            for (String v : list) {
                if (v != null) {
                    add(name, v);
                }
            }
        }
    }

    public void add(String name, String value) {
        if (value != null) {
            add(new HttpField(name, value));
        }
    }

    public void add(HttpHeader header, HttpHeaderValue value) {
        if (value != null) {
            add(header, value.toString());
        }
    }

    public void add(HttpHeader header, String value) {
        Objects.requireNonNull(header, "header must not be null");
        if (value == null) {
            throw new IllegalArgumentException("null value");
        }
        add(new HttpField(header, value));
    }

    public HttpField remove(HttpHeader name) {
        HttpField removed = null;
        int i = this._size;
        while (true) {
            i--;
            if (i <= 0) {
                return removed;
            }
            HttpField f = this._fields[i];
            if (f.getHeader() == name) {
                removed = f;
                remove(i);
            }
        }
    }

    public HttpField remove(String name) {
        HttpField removed = null;
        int i = this._size;
        while (true) {
            i--;
            if (i <= 0) {
                return removed;
            }
            HttpField f = this._fields[i];
            if (f.m43is(name)) {
                removed = f;
                remove(i);
            }
        }
    }

    /* access modifiers changed from: private */
    public void remove(int i) {
        this._size--;
        System.arraycopy(this._fields, i + 1, this._fields, i, this._size - i);
        this._fields[this._size] = null;
    }

    public long getLongField(String name) throws NumberFormatException {
        HttpField field = getField(name);
        if (field == null) {
            return -1;
        }
        return field.getLongValue();
    }

    public long getDateField(String name) {
        String val;
        HttpField field = getField(name);
        if (field == null || (val = valueParameters(field.getValue(), null)) == null) {
            return -1;
        }
        long date = DateParser.parseDate(val);
        if (date != -1) {
            return date;
        }
        throw new IllegalArgumentException("Cannot convert date: " + val);
    }

    public void putLongField(HttpHeader name, long value) {
        put(name, Long.toString(value));
    }

    public void putLongField(String name, long value) {
        put(name, Long.toString(value));
    }

    public void putDateField(HttpHeader name, long date) {
        put(name, DateGenerator.formatDate(date));
    }

    public void putDateField(String name, long date) {
        put(name, DateGenerator.formatDate(date));
    }

    public void addDateField(String name, long date) {
        add(name, DateGenerator.formatDate(date));
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hash = 0;
        for (HttpField field : this._fields) {
            hash += field.hashCode();
        }
        return hash;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HttpFields)) {
            return false;
        }
        HttpFields that = (HttpFields) o;
        if (size() != that.size()) {
            return false;
        }
        Iterator<HttpField> it = iterator();
        while (it.hasNext()) {
            HttpField fi = it.next();
            Iterator<HttpField> it2 = that.iterator();
            while (it2.hasNext()) {
                if (fi.equals(it2.next())) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public String toString() {
        try {
            StringBuilder buffer = new StringBuilder();
            Iterator<HttpField> it = iterator();
            while (it.hasNext()) {
                HttpField field = it.next();
                if (field != null) {
                    String tmp = field.getName();
                    if (tmp != null) {
                        buffer.append(tmp);
                    }
                    buffer.append(": ");
                    String tmp2 = field.getValue();
                    if (tmp2 != null) {
                        buffer.append(tmp2);
                    }
                    buffer.append("\r\n");
                }
            }
            buffer.append("\r\n");
            return buffer.toString();
        } catch (Exception e) {
            LOG.warn(e);
            return e.toString();
        }
    }

    public void clear() {
        this._size = 0;
    }

    public void add(HttpField field) {
        if (field != null) {
            if (this._size == this._fields.length) {
                this._fields = (HttpField[]) Arrays.copyOf(this._fields, this._size * 2);
            }
            HttpField[] httpFieldArr = this._fields;
            int i = this._size;
            this._size = i + 1;
            httpFieldArr[i] = field;
        }
    }

    public void addAll(HttpFields fields) {
        for (int i = 0; i < fields._size; i++) {
            add(fields._fields[i]);
        }
    }

    @Deprecated
    public void add(HttpFields fields) {
        if (fields != null) {
            Enumeration<String> e = fields.getFieldNames();
            while (e.hasMoreElements()) {
                String name = e.nextElement();
                Enumeration<String> values = fields.getValues(name);
                while (values.hasMoreElements()) {
                    add(name, values.nextElement());
                }
            }
        }
    }

    public static String stripParameters(String value) {
        if (value == null) {
            return null;
        }
        int i = value.indexOf(59);
        if (i < 0) {
            return value;
        }
        return value.substring(0, i).trim();
    }

    public static String valueParameters(String value, Map<String, String> parameters) {
        if (value == null) {
            return null;
        }
        int i = value.indexOf(59);
        if (i < 0) {
            return value;
        }
        if (parameters == null) {
            return value.substring(0, i).trim();
        }
        StringTokenizer tok1 = new QuotedStringTokenizer(value.substring(i), ";", false, true);
        while (tok1.hasMoreTokens()) {
            StringTokenizer tok2 = new QuotedStringTokenizer(tok1.nextToken(), "= ");
            if (tok2.hasMoreTokens()) {
                String paramName = tok2.nextToken();
                String paramVal = null;
                if (tok2.hasMoreTokens()) {
                    paramVal = tok2.nextToken();
                }
                parameters.put(paramName, paramVal);
            }
        }
        return value.substring(0, i).trim();
    }

    @Deprecated
    public static Float getQuality(String value) {
        int qe;
        Float q;
        if (value == null) {
            return __zero;
        }
        int qe2 = value.indexOf(";");
        int qe3 = qe2 + 1;
        if (qe2 < 0 || qe3 == value.length()) {
            return __one;
        }
        int qe4 = qe3 + 1;
        if (value.charAt(qe3) == 'q' && (q = __qualities.get(value, (qe = qe4 + 1), value.length() - qe)) != null) {
            return q;
        }
        Map<String, String> params = new HashMap<>(4);
        valueParameters(value, params);
        String qs = params.get("q");
        if (qs == null) {
            qs = "*";
        }
        Float q2 = __qualities.get(qs);
        if (q2 == null) {
            try {
                q2 = new Float(qs);
            } catch (Exception e) {
                q2 = __one;
            }
        }
        return q2;
    }

    @Deprecated
    public static List<String> qualityList(Enumeration<String> e) {
        if (e == null || !e.hasMoreElements()) {
            return Collections.emptyList();
        }
        QuotedQualityCSV values = new QuotedQualityCSV();
        while (e.hasMoreElements()) {
            values.addValue(e.nextElement());
        }
        return values.getValues();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/HttpFields$ListItr.class */
    public class ListItr implements ListIterator<HttpField> {
        int _cursor;
        int _current;

        private ListItr() {
            this._current = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this._cursor != HttpFields.this._size;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public HttpField next() {
            if (this._cursor == HttpFields.this._size) {
                throw new NoSuchElementException();
            }
            int i = this._cursor;
            this._cursor = i + 1;
            this._current = i;
            return HttpFields.this._fields[this._current];
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (this._current < 0) {
                throw new IllegalStateException();
            }
            HttpFields.this.remove(this._current);
            HttpFields.this._fields[HttpFields.this._size] = null;
            this._cursor = this._current;
            this._current = -1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this._cursor > 0;
        }

        @Override // java.util.ListIterator
        public HttpField previous() {
            if (this._cursor == 0) {
                throw new NoSuchElementException();
            }
            int i = this._cursor - 1;
            this._cursor = i;
            this._current = i;
            return HttpFields.this._fields[this._current];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this._cursor;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this._cursor - 1;
        }

        public void set(HttpField field) {
            if (this._current < 0) {
                throw new IllegalStateException();
            } else if (field == null) {
                remove();
            } else {
                HttpFields.this._fields[this._current] = field;
            }
        }

        public void add(HttpField field) {
            if (field != null) {
                HttpFields.this._fields = (HttpField[]) Arrays.copyOf(HttpFields.this._fields, HttpFields.this._fields.length + 1);
                System.arraycopy(HttpFields.this._fields, this._cursor, HttpFields.this._fields, this._cursor + 1, HttpFields.this._size - this._cursor);
                HttpField[] httpFieldArr = HttpFields.this._fields;
                int i = this._cursor;
                this._cursor = i + 1;
                httpFieldArr[i] = field;
                HttpFields.access$108(HttpFields.this);
                this._current = -1;
            }
        }
    }
}
