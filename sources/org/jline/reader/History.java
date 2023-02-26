package org.jline.reader;

import java.io.IOException;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: grasscutter.jar:org/jline/reader/History.class */
public interface History extends Iterable<Entry> {

    /* loaded from: grasscutter.jar:org/jline/reader/History$Entry.class */
    public interface Entry {
        int index();

        Instant time();

        String line();
    }

    void attach(LineReader lineReader);

    void load() throws IOException;

    void save() throws IOException;

    void write(Path path, boolean z) throws IOException;

    void append(Path path, boolean z) throws IOException;

    void read(Path path, boolean z) throws IOException;

    void purge() throws IOException;

    int size();

    int index();

    int first();

    int last();

    String get(int i);

    void add(Instant instant, String str);

    ListIterator<Entry> iterator(int i);

    String current();

    boolean previous();

    boolean next();

    boolean moveToFirst();

    boolean moveToLast();

    boolean moveTo(int i);

    void moveToEnd();

    void resetIndex();

    default boolean isEmpty() {
        return size() == 0;
    }

    default void add(String line) {
        add(Instant.now(), line);
    }

    default boolean isPersistable(Entry entry) {
        return true;
    }

    /* Return type fixed from 'java.util.ListIterator<org.jline.reader.History$Entry>' to match base method */
    @Override // java.lang.Iterable
    default Iterator<Entry> iterator() {
        return iterator(first());
    }

    default Iterator<Entry> reverseIterator() {
        return reverseIterator(last());
    }

    default Iterator<Entry> reverseIterator(final int index) {
        return new Iterator<Entry>() { // from class: org.jline.reader.History.1

            /* renamed from: it */
            private final ListIterator<Entry> f3193it;

            {
                this.f3193it = History.this.iterator(index + 1);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f3193it.hasPrevious();
            }

            @Override // java.util.Iterator
            public Entry next() {
                return this.f3193it.previous();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f3193it.remove();
                History.this.resetIndex();
            }
        };
    }
}
