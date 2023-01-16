package com.mchange.p011v3.filecache;

import com.mchange.p006v1.p008io.InputStreamUtils;
import com.mchange.p006v1.p008io.ReaderUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLogger;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;

/* renamed from: com.mchange.v3.filecache.URLFetchers */
/* loaded from: grasscutter.jar:com/mchange/v3/filecache/URLFetchers.class */
public enum URLFetchers implements URLFetcher {
    DEFAULT {
        @Override // com.mchange.p011v3.filecache.URLFetcher
        public InputStream openStream(URL url, MLogger mLogger) throws IOException {
            return url.openStream();
        }
    },
    BUFFERED_WGET {
        @Override // com.mchange.p011v3.filecache.URLFetcher
        public InputStream openStream(URL url, MLogger mLogger) throws IOException {
            Process start = new ProcessBuilder("wget", "-O", "-", url.toString()).start();
            BufferedInputStream bufferedInputStream = null;
            try {
                bufferedInputStream = new BufferedInputStream(start.getInputStream(), 1048576);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1048576);
                for (int read = bufferedInputStream.read(); read >= 0; read = bufferedInputStream.read()) {
                    byteArrayOutputStream.write(read);
                }
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                InputStreamUtils.attemptClose(bufferedInputStream);
                if (mLogger.isLoggable(MLevel.FINER)) {
                    BufferedReader bufferedReader = null;
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(start.getErrorStream()), 1048576);
                        StringWriter stringWriter = new StringWriter(1048576);
                        for (int read2 = bufferedReader.read(); read2 >= 0; read2 = bufferedReader.read()) {
                            stringWriter.write(read2);
                        }
                        mLogger.log(MLevel.FINER, "wget error stream for '" + url + "':\n " + stringWriter.toString());
                        ReaderUtils.attemptClose(bufferedReader);
                    } catch (Throwable th) {
                        ReaderUtils.attemptClose(bufferedReader);
                        throw th;
                    }
                }
                try {
                    int waitFor = start.waitFor();
                    if (waitFor == 0) {
                        return byteArrayInputStream;
                    }
                    throw new IOException("wget process terminated abnormally [return code: " + waitFor + "]");
                } catch (InterruptedException e) {
                    if (mLogger.isLoggable(MLevel.FINER)) {
                        mLogger.log(MLevel.FINER, "InterruptedException while waiting for wget to complete.", (Throwable) e);
                    }
                    throw new IOException("Interrupted while waiting for wget to complete: " + e);
                }
            } catch (Throwable th2) {
                InputStreamUtils.attemptClose(bufferedInputStream);
                if (mLogger.isLoggable(MLevel.FINER)) {
                    BufferedReader bufferedReader2 = null;
                    try {
                        bufferedReader2 = new BufferedReader(new InputStreamReader(start.getErrorStream()), 1048576);
                        StringWriter stringWriter2 = new StringWriter(1048576);
                        for (int read3 = bufferedReader2.read(); read3 >= 0; read3 = bufferedReader2.read()) {
                            stringWriter2.write(read3);
                        }
                        mLogger.log(MLevel.FINER, "wget error stream for '" + url + "':\n " + stringWriter2.toString());
                        ReaderUtils.attemptClose(bufferedReader2);
                    } catch (Throwable th3) {
                        ReaderUtils.attemptClose(bufferedReader2);
                        throw th3;
                    }
                }
                try {
                    int waitFor2 = start.waitFor();
                    if (waitFor2 != 0) {
                        throw new IOException("wget process terminated abnormally [return code: " + waitFor2 + "]");
                    }
                    throw th2;
                } catch (InterruptedException e2) {
                    if (mLogger.isLoggable(MLevel.FINER)) {
                        mLogger.log(MLevel.FINER, "InterruptedException while waiting for wget to complete.", (Throwable) e2);
                    }
                    throw new IOException("Interrupted while waiting for wget to complete: " + e2);
                }
            }
        }
    }
}
