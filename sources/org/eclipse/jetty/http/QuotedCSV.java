package org.eclipse.jetty.http;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/QuotedCSV.class */
public class QuotedCSV extends QuotedCSVParser implements Iterable<String> {
    protected final List<String> _values;

    public QuotedCSV(String... values) {
        this(true, values);
    }

    public QuotedCSV(boolean keepQuotes, String... values) {
        super(keepQuotes);
        this._values = new ArrayList();
        for (String v : values) {
            addValue(v);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.http.QuotedCSVParser
    public void parsedValueAndParams(StringBuffer buffer) {
        this._values.add(buffer.toString());
    }

    public int size() {
        return this._values.size();
    }

    public boolean isEmpty() {
        return this._values.isEmpty();
    }

    public List<String> getValues() {
        return this._values;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this._values.iterator();
    }

    @Override // java.lang.Object
    public String toString() {
        List<String> list = new ArrayList<>();
        Iterator<String> it = iterator();
        while (it.hasNext()) {
            list.add(it.next());
        }
        return list.toString();
    }
}
