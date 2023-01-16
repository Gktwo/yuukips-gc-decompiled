package com.mchange.util.impl;

import com.mchange.util.MessageLogger;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.DateFormat;
import java.util.Date;

/* loaded from: grasscutter.jar:com/mchange/util/impl/SimpleLogFile.class */
public class SimpleLogFile implements MessageLogger {
    PrintWriter logWriter;

    /* renamed from: df */
    DateFormat f377df = DateFormat.getDateTimeInstance(3, 3);

    public SimpleLogFile(File file, String str) throws UnsupportedEncodingException, IOException {
        this.logWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file.getAbsolutePath(), true), str)), true);
    }

    public SimpleLogFile(File file) throws IOException {
        this.logWriter = new PrintWriter((OutputStream) new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath(), true)), true);
    }

    @Override // com.mchange.util.MessageLogger
    public synchronized void log(String str) throws IOException {
        logMessage(str);
        flush();
    }

    @Override // com.mchange.util.MessageLogger
    public synchronized void log(Throwable th, String str) throws IOException {
        logMessage(str);
        th.printStackTrace(this.logWriter);
        flush();
    }

    private void logMessage(String str) {
        this.logWriter.println(this.f377df.format(new Date()) + " -- " + str);
    }

    private void flush() {
        this.logWriter.flush();
    }

    public synchronized void close() {
        this.logWriter.close();
    }

    public void finalize() {
        close();
    }
}
