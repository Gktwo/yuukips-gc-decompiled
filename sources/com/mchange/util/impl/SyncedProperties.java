package com.mchange.util.impl;

import com.mchange.p005io.InputStreamUtils;
import com.mchange.p005io.OutputStreamUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Properties;

/* loaded from: grasscutter.jar:com/mchange/util/impl/SyncedProperties.class */
public class SyncedProperties {
    private static final String[] SA_TEMPLATE = new String[0];
    private static final byte H_START_BYTE = 35;
    private static final byte[] H_LF_BYTES;
    private static final String ASCII = "8859_1";
    Properties props;
    byte[] headerBytes;
    File file;
    long last_mod;

    static {
        try {
            H_LF_BYTES = System.getProperty("line.separator", "\r\n").getBytes(ASCII);
        } catch (UnsupportedEncodingException e) {
            throw new InternalError("Encoding 8859_1 not supported ?!?");
        }
    }

    public SyncedProperties(File file, String str) throws IOException {
        this(file, makeHeaderBytes(str));
    }

    public SyncedProperties(File file, String[] strArr) throws IOException {
        this(file, makeHeaderBytes(strArr));
    }

    public SyncedProperties(File file) throws IOException {
        this(file, (byte[]) null);
    }

    private SyncedProperties(File file, byte[] bArr) throws IOException {
        this.last_mod = -1;
        if (file.exists()) {
            if (!file.isFile()) {
                throw new IOException(file.getPath() + ": Properties file can't be a directory or special file!");
            } else if (bArr == null) {
                BufferedReader bufferedReader = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    LinkedList linkedList = new LinkedList();
                    String readLine = bufferedReader.readLine();
                    while (readLine.trim().equals("")) {
                        readLine = bufferedReader.readLine();
                    }
                    while (readLine.charAt(0) == '#') {
                        linkedList.add(readLine.substring(1).trim());
                    }
                    bArr = makeHeaderBytes((String[]) linkedList.toArray(SA_TEMPLATE));
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (Throwable th) {
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        }
        if (!file.canWrite()) {
            throw new IOException("Can't write to file " + file.getPath());
        }
        this.props = new Properties();
        this.headerBytes = bArr;
        this.file = file;
        ensureUpToDate();
    }

    public synchronized String getProperty(String str) throws IOException {
        ensureUpToDate();
        return this.props.getProperty(str);
    }

    public synchronized String getProperty(String str, String str2) throws IOException {
        String property = this.props.getProperty(str);
        return property == null ? str2 : property;
    }

    public synchronized void put(String str, String str2) throws IOException {
        ensureUpToDate();
        this.props.put(str, str2);
        rewritePropsFile();
    }

    public synchronized void remove(String str) throws IOException {
        ensureUpToDate();
        this.props.remove(str);
        rewritePropsFile();
    }

    public synchronized void clear() throws IOException {
        ensureUpToDate();
        this.props.clear();
        rewritePropsFile();
    }

    public synchronized boolean contains(String str) throws IOException {
        ensureUpToDate();
        return this.props.contains(str);
    }

    public synchronized boolean containsKey(String str) throws IOException {
        ensureUpToDate();
        return this.props.containsKey(str);
    }

    public synchronized Enumeration elements() throws IOException {
        ensureUpToDate();
        return this.props.elements();
    }

    public synchronized Enumeration keys() throws IOException {
        ensureUpToDate();
        return this.props.keys();
    }

    public synchronized int size() throws IOException {
        ensureUpToDate();
        return this.props.size();
    }

    public synchronized boolean isEmpty() throws IOException {
        ensureUpToDate();
        return this.props.isEmpty();
    }

    private synchronized void ensureUpToDate() throws IOException {
        long lastModified = this.file.lastModified();
        if (lastModified > this.last_mod) {
            BufferedInputStream bufferedInputStream = null;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(this.file));
                this.props.clear();
                this.props.load(bufferedInputStream);
                this.last_mod = lastModified;
                InputStreamUtils.attemptClose(bufferedInputStream);
            } catch (Throwable th) {
                InputStreamUtils.attemptClose(bufferedInputStream);
                throw th;
            }
        }
    }

    private synchronized void rewritePropsFile() throws IOException {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.file));
            if (this.headerBytes != null) {
                bufferedOutputStream.write(this.headerBytes);
            }
            this.props.store(bufferedOutputStream, (String) null);
            bufferedOutputStream.flush();
            this.last_mod = this.file.lastModified();
        } finally {
            OutputStreamUtils.attemptClose(bufferedOutputStream);
        }
    }

    private static byte[] makeHeaderBytes(String[] strArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (String str : strArr) {
                byteArrayOutputStream.write(35);
                byteArrayOutputStream.write(str.getBytes());
                byteArrayOutputStream.write(H_LF_BYTES);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new InternalError("IOException working with ByteArrayOutputStream?!?");
        }
    }

    private static byte[] makeHeaderBytes(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(35);
            byteArrayOutputStream.write(str.getBytes());
            byteArrayOutputStream.write(H_LF_BYTES);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new InternalError("IOException working with ByteArrayOutputStream?!?");
        }
    }
}
