package com.mongodb.gridfs;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: grasscutter.jar:com/mongodb/gridfs/GridFSDBFile.class */
public class GridFSDBFile extends GridFSFile {
    public InputStream getInputStream() {
        return new GridFSInputStream();
    }

    public long writeTo(String filename) throws IOException {
        return writeTo(new File(filename));
    }

    public long writeTo(File file) throws IOException {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            long writeTo = writeTo(out);
            if (out != null) {
                out.close();
            }
            return writeTo;
        } catch (Throwable th) {
            if (out != null) {
                out.close();
            }
            throw th;
        }
    }

    public long writeTo(OutputStream out) throws IOException {
        int nc = numChunks();
        for (int i = 0; i < nc; i++) {
            out.write(getChunk(i));
        }
        return this.length;
    }

    /* access modifiers changed from: private */
    public byte[] getChunk(int chunkNumber) {
        if (this.f452fs == null) {
            throw new IllegalStateException("No GridFS instance defined!");
        }
        DBObject chunk = this.f452fs.getChunksCollection().findOne((DBObject) new BasicDBObject("files_id", this.f453id).append("n", (Object) Integer.valueOf(chunkNumber)));
        if (chunk != null) {
            return (byte[]) chunk.get("data");
        }
        throw new MongoException("Can't find a chunk!  file id: " + this.f453id + " chunk: " + chunkNumber);
    }

    /* access modifiers changed from: package-private */
    public void remove() {
        this.f452fs.getFilesCollection().remove(new BasicDBObject(DBCollection.ID_FIELD_NAME, this.f453id));
        this.f452fs.getChunksCollection().remove(new BasicDBObject("files_id", this.f453id));
    }

    /* loaded from: grasscutter.jar:com/mongodb/gridfs/GridFSDBFile$GridFSInputStream.class */
    private class GridFSInputStream extends InputStream {
        private final int numberOfChunks;
        private int currentChunkId = -1;
        private int offset = 0;
        private byte[] buffer = null;

        GridFSInputStream() {
            this.numberOfChunks = GridFSDBFile.this.numChunks();
        }

        @Override // java.io.InputStream
        public int available() {
            if (this.buffer == null) {
                return 0;
            }
            return this.buffer.length - this.offset;
        }

        @Override // java.io.InputStream
        public int read() {
            byte[] b = new byte[1];
            if (read(b) < 0) {
                return -1;
            }
            return b[0] & 255;
        }

        @Override // java.io.InputStream
        public int read(byte[] b) {
            return read(b, 0, b.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] b, int off, int len) {
            if (this.buffer == null || this.offset >= this.buffer.length) {
                if (this.currentChunkId + 1 >= this.numberOfChunks) {
                    return -1;
                }
                GridFSDBFile gridFSDBFile = GridFSDBFile.this;
                int i = this.currentChunkId + 1;
                this.currentChunkId = i;
                this.buffer = gridFSDBFile.getChunk(i);
                this.offset = 0;
            }
            int r = Math.min(len, this.buffer.length - this.offset);
            System.arraycopy(this.buffer, this.offset, b, off, r);
            this.offset += r;
            return r;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r9v0 */
        /* JADX WARN: Type inference failed for: r9v1, types: [long] */
        /* JADX WARN: Type inference failed for: r9v4 */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // java.io.InputStream
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long skip(long r7) throws java.io.IOException {
            /*
                r6 = this;
                r0 = r7
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L_0x0008
                r0 = 0
                return r0
            L_0x0008:
                r0 = r6
                int r0 = r0.currentChunkId
                r1 = r6
                int r1 = r1.numberOfChunks
                if (r0 != r1) goto L_0x0015
                r0 = 0
                return r0
            L_0x0015:
                r0 = 0
                r9 = r0
                r0 = r6
                int r0 = r0.currentChunkId
                if (r0 < 0) goto L_0x0032
                r0 = r6
                int r0 = r0.currentChunkId
                long r0 = (long) r0
                r1 = r6
                com.mongodb.gridfs.GridFSDBFile r1 = com.mongodb.gridfs.GridFSDBFile.this
                long r1 = r1.chunkSize
                long r0 = r0 * r1
                r1 = r6
                int r1 = r1.offset
                long r1 = (long) r1
                long r0 = r0 + r1
                r9 = r0
            L_0x0032:
                r0 = r7
                r1 = r9
                long r0 = r0 + r1
                r1 = r6
                com.mongodb.gridfs.GridFSDBFile r1 = com.mongodb.gridfs.GridFSDBFile.this
                long r1 = r1.length
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 < 0) goto L_0x0057
                r0 = r6
                r1 = r6
                int r1 = r1.numberOfChunks
                r0.currentChunkId = r1
                r0 = r6
                r1 = 0
                r0.buffer = r1
                r0 = r6
                com.mongodb.gridfs.GridFSDBFile r0 = com.mongodb.gridfs.GridFSDBFile.this
                long r0 = r0.length
                r1 = r9
                long r0 = r0 - r1
                return r0
            L_0x0057:
                r0 = r6
                int r0 = r0.currentChunkId
                r11 = r0
                r0 = r6
                r1 = r7
                r2 = r9
                long r1 = r1 + r2
                r2 = r6
                com.mongodb.gridfs.GridFSDBFile r2 = com.mongodb.gridfs.GridFSDBFile.this
                long r2 = r2.chunkSize
                long r1 = r1 / r2
                int r1 = (int) r1
                r0.currentChunkId = r1
                r0 = r11
                r1 = r6
                int r1 = r1.currentChunkId
                if (r0 == r1) goto L_0x0085
                r0 = r6
                r1 = r6
                com.mongodb.gridfs.GridFSDBFile r1 = com.mongodb.gridfs.GridFSDBFile.this
                r2 = r6
                int r2 = r2.currentChunkId
                byte[] r1 = com.mongodb.gridfs.GridFSDBFile.access$000(r1, r2)
                r0.buffer = r1
            L_0x0085:
                r0 = r6
                r1 = r7
                r2 = r9
                long r1 = r1 + r2
                r2 = r6
                com.mongodb.gridfs.GridFSDBFile r2 = com.mongodb.gridfs.GridFSDBFile.this
                long r2 = r2.chunkSize
                long r1 = r1 % r2
                int r1 = (int) r1
                r0.offset = r1
                r0 = r7
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mongodb.gridfs.GridFSDBFile.GridFSInputStream.skip(long):long");
        }
    }
}
