package com.mchange.p009v2.p010io;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;
import p001ch.qos.logback.classic.net.SyslogAppender;

/* renamed from: com.mchange.v2.io.IndentedWriter */
/* loaded from: grasscutter.jar:com/mchange/v2/io/IndentedWriter.class */
public class IndentedWriter extends FilterWriter {
    static final String EOL;
    int indent_level;
    boolean at_line_start;
    String indentSpacing;

    static {
        String property = System.getProperty("line.separator");
        EOL = property != null ? property : "\r\n";
    }

    public IndentedWriter(Writer writer, String str) {
        super(writer);
        this.indent_level = 0;
        this.at_line_start = true;
        this.indentSpacing = str;
    }

    public IndentedWriter(Writer writer) {
        this(writer, SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
    }

    private boolean isEol(char c) {
        return c == '\r' || c == '\n';
    }

    public void upIndent() {
        this.indent_level++;
    }

    public void downIndent() {
        this.indent_level--;
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(int i) throws IOException {
        this.out.write(i);
        this.at_line_start = isEol((char) i);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        this.out.write(cArr, i, i2);
        this.at_line_start = isEol(cArr[(i + i2) - 1]);
    }

    @Override // java.io.FilterWriter, java.io.Writer
    public void write(String str, int i, int i2) throws IOException {
        if (i2 > 0) {
            this.out.write(str, i, i2);
            this.at_line_start = isEol(str.charAt((i + i2) - 1));
        }
    }

    private void printIndent() throws IOException {
        for (int i = 0; i < this.indent_level; i++) {
            this.out.write(this.indentSpacing);
        }
    }

    public void print(String str) throws IOException {
        if (this.at_line_start) {
            printIndent();
        }
        this.out.write(str);
        this.at_line_start = isEol(str.charAt(str.length() - 1));
    }

    public void println(String str) throws IOException {
        if (this.at_line_start) {
            printIndent();
        }
        this.out.write(str);
        this.out.write(EOL);
        this.at_line_start = true;
    }

    public void print(boolean z) throws IOException {
        print(String.valueOf(z));
    }

    public void print(byte b) throws IOException {
        print(String.valueOf((int) b));
    }

    public void print(char c) throws IOException {
        print(String.valueOf(c));
    }

    public void print(short s) throws IOException {
        print(String.valueOf((int) s));
    }

    public void print(int i) throws IOException {
        print(String.valueOf(i));
    }

    public void print(long j) throws IOException {
        print(String.valueOf(j));
    }

    public void print(float f) throws IOException {
        print(String.valueOf(f));
    }

    public void print(double d) throws IOException {
        print(String.valueOf(d));
    }

    public void print(Object obj) throws IOException {
        print(String.valueOf(obj));
    }

    public void println(boolean z) throws IOException {
        println(String.valueOf(z));
    }

    public void println(byte b) throws IOException {
        println(String.valueOf((int) b));
    }

    public void println(char c) throws IOException {
        println(String.valueOf(c));
    }

    public void println(short s) throws IOException {
        println(String.valueOf((int) s));
    }

    public void println(int i) throws IOException {
        println(String.valueOf(i));
    }

    public void println(long j) throws IOException {
        println(String.valueOf(j));
    }

    public void println(float f) throws IOException {
        println(String.valueOf(f));
    }

    public void println(double d) throws IOException {
        println(String.valueOf(d));
    }

    public void println(Object obj) throws IOException {
        println(String.valueOf(obj));
    }

    public void println() throws IOException {
        println("");
    }
}
