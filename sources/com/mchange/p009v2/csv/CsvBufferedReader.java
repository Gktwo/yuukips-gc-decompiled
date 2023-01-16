package com.mchange.p009v2.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.stream.Stream;

/* renamed from: com.mchange.v2.csv.CsvBufferedReader */
/* loaded from: grasscutter.jar:com/mchange/v2/csv/CsvBufferedReader.class */
public class CsvBufferedReader extends BufferedReader {
    private BufferedReader inner;

    public CsvBufferedReader(BufferedReader bufferedReader) {
        super(bufferedReader);
        this.inner = bufferedReader;
    }

    @Override // java.io.BufferedReader
    public String readLine() throws IOException {
        try {
            return FastCsvUtils.csvReadLine(this.inner);
        } catch (MalformedCsvException e) {
            throw new IOException("Badly formatted CSV file.", e);
        }
    }

    public String[] readSplitLine() throws IOException, MalformedCsvException {
        String readLine = readLine();
        if (readLine == null) {
            return null;
        }
        return FastCsvUtils.splitRecord(readLine);
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read() throws IOException {
        return this.inner.read();
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        return this.inner.read(cArr, i, i2);
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public long skip(long j) throws IOException {
        return this.inner.skip(j);
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public boolean ready() throws IOException {
        return this.inner.ready();
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public boolean markSupported() {
        return this.inner.markSupported();
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public void mark(int i) throws IOException {
        this.inner.mark(i);
    }

    @Override // java.io.BufferedReader, java.io.Reader
    public void reset() throws IOException {
        this.inner.reset();
    }

    @Override // java.io.BufferedReader, java.io.Closeable, java.io.Reader, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inner.close();
    }

    @Override // java.io.BufferedReader
    public Stream<String> lines() {
        throw new UnsupportedOperationException("lines() not yet implemented for CsvBufferedReader!");
    }
}
