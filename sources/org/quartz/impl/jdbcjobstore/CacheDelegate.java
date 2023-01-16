package org.quartz.impl.jdbcjobstore;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/CacheDelegate.class */
public class CacheDelegate extends StdJDBCDelegate {
    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected void setBytes(PreparedStatement ps, int index, ByteArrayOutputStream baos) throws SQLException {
        ps.setObject(index, baos == null ? null : baos.toByteArray(), RetcodeOuterClass.Retcode.RET_ORDER_INFO_NOT_EXIST_VALUE);
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected Object getObjectFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        Blob blob = rs.getBlob(colName);
        if (blob == null) {
            return null;
        }
        try {
            if (blob.length() == 0) {
                return null;
            }
            InputStream binaryInput = blob.getBinaryStream();
            if (binaryInput == null) {
                blob.free();
                return null;
            } else if (!(binaryInput instanceof ByteArrayInputStream) || ((ByteArrayInputStream) binaryInput).available() != 0) {
                ObjectInputStream in = new ObjectInputStream(binaryInput);
                Object readObject = in.readObject();
                in.close();
                blob.free();
                return readObject;
            } else {
                blob.free();
                return null;
            }
        } finally {
            blob.free();
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected Object getJobDataFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        if (!canUseProperties()) {
            return getObjectFromBlob(rs, colName);
        }
        Blob blob = rs.getBlob(colName);
        if (blob == null) {
            return null;
        }
        return new BlobFreeingStream(blob, blob.getBinaryStream());
    }

    /* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/CacheDelegate$BlobFreeingStream.class */
    private static class BlobFreeingStream extends InputStream {
        private final Blob source;
        private final InputStream delegate;

        private BlobFreeingStream(Blob blob, InputStream stream) {
            this.source = blob;
            this.delegate = stream;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return this.delegate.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] b) throws IOException {
            return this.delegate.read(b);
        }

        @Override // java.io.InputStream
        public int read(byte[] b, int off, int len) throws IOException {
            return this.delegate.read(b, off, len);
        }

        @Override // java.io.InputStream
        public long skip(long n) throws IOException {
            return this.delegate.skip(n);
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.delegate.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.delegate.close();
                try {
                    this.source.free();
                } catch (SQLException ex) {
                    throw new IOException(ex);
                }
            } catch (Throwable th) {
                try {
                    this.source.free();
                    throw th;
                } catch (SQLException ex2) {
                    throw new IOException(ex2);
                }
            }
        }

        @Override // java.io.InputStream
        public synchronized void mark(int readlimit) {
            this.delegate.mark(readlimit);
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            this.delegate.reset();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.delegate.markSupported();
        }
    }
}
