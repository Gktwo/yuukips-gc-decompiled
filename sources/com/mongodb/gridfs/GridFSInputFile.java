package com.mongodb.gridfs;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:com/mongodb/gridfs/GridFSInputFile.class */
public class GridFSInputFile extends GridFSFile {
    private final InputStream inputStream;
    private final boolean closeStreamOnPersist;
    private boolean savedChunks;
    private byte[] buffer;
    private int currentChunkNumber;
    private int currentBufferPosition;
    private long totalBytes;
    private OutputStream outputStream;

    static /* synthetic */ int access$112(GridFSInputFile x0, int x1) {
        int i = x0.currentBufferPosition + x1;
        x0.currentBufferPosition = i;
        return i;
    }

    /* access modifiers changed from: protected */
    public GridFSInputFile(GridFS gridFS, InputStream inputStream, String filename, boolean closeStreamOnPersist) {
        this.savedChunks = false;
        this.buffer = null;
        this.currentChunkNumber = 0;
        this.currentBufferPosition = 0;
        this.totalBytes = 0;
        this.outputStream = null;
        this.f452fs = gridFS;
        this.inputStream = inputStream;
        this.filename = filename;
        this.closeStreamOnPersist = closeStreamOnPersist;
        this.f453id = new ObjectId();
        this.chunkSize = 261120;
        this.uploadDate = new Date();
        this.buffer = new byte[(int) this.chunkSize];
    }

    /* access modifiers changed from: protected */
    public GridFSInputFile(GridFS gridFS, InputStream inputStream, String filename) {
        this(gridFS, inputStream, filename, false);
    }

    /* access modifiers changed from: protected */
    public GridFSInputFile(GridFS gridFS, String filename) {
        this(gridFS, null, filename);
    }

    /* access modifiers changed from: protected */
    public GridFSInputFile(GridFS gridFS) {
        this(gridFS, null, null);
    }

    public void setId(Object id) {
        this.f453id = id;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setChunkSize(long chunkSize) {
        if (this.outputStream == null && !this.savedChunks) {
            this.chunkSize = chunkSize;
            this.buffer = new byte[(int) this.chunkSize];
        }
    }

    @Override // com.mongodb.gridfs.GridFSFile
    public void save() {
        save(this.chunkSize);
    }

    public void save(long chunkSize) {
        if (this.outputStream != null) {
            throw new MongoException("cannot mix OutputStream and regular save()");
        }
        if (!this.savedChunks) {
            try {
                saveChunks(chunkSize);
            } catch (IOException ioe) {
                throw new MongoException("couldn't save chunks", ioe);
            }
        }
        save();
    }

    public int saveChunks() throws IOException {
        return saveChunks(this.chunkSize);
    }

    public int saveChunks(long chunkSize) throws IOException {
        if (this.outputStream != null) {
            throw new MongoException("Cannot mix OutputStream and regular save()");
        } else if (this.savedChunks) {
            throw new MongoException("Chunks already saved!");
        } else if (chunkSize <= 0) {
            throw new MongoException("chunkSize must be greater than zero");
        } else {
            if (this.chunkSize != chunkSize) {
                this.chunkSize = chunkSize;
                this.buffer = new byte[(int) this.chunkSize];
            }
            int bytesRead = 0;
            while (bytesRead >= 0) {
                this.currentBufferPosition = 0;
                bytesRead = _readStream2Buffer();
                dumpBuffer(true);
            }
            finishData();
            return this.currentChunkNumber;
        }
    }

    public OutputStream getOutputStream() {
        if (this.outputStream == null) {
            this.outputStream = new GridFSOutputStream();
        }
        return this.outputStream;
    }

    /* access modifiers changed from: private */
    public void dumpBuffer(boolean writePartial) {
        if ((((long) this.currentBufferPosition) >= this.chunkSize || writePartial) && this.currentBufferPosition != 0) {
            byte[] writeBuffer = this.buffer;
            if (((long) this.currentBufferPosition) != this.chunkSize) {
                writeBuffer = new byte[this.currentBufferPosition];
                System.arraycopy(this.buffer, 0, writeBuffer, 0, this.currentBufferPosition);
            }
            this.f452fs.getChunksCollection().save(createChunk(this.f453id, this.currentChunkNumber, writeBuffer));
            this.currentChunkNumber++;
            this.totalBytes += (long) writeBuffer.length;
            this.currentBufferPosition = 0;
        }
    }

    protected DBObject createChunk(Object id, int currentChunkNumber, byte[] writeBuffer) {
        return new BasicDBObject("files_id", id).append("n", (Object) Integer.valueOf(currentChunkNumber)).append("data", (Object) writeBuffer);
    }

    private int _readStream2Buffer() throws IOException {
        int bytesRead = 0;
        while (((long) this.currentBufferPosition) < this.chunkSize && bytesRead >= 0) {
            bytesRead = this.inputStream.read(this.buffer, this.currentBufferPosition, ((int) this.chunkSize) - this.currentBufferPosition);
            if (bytesRead > 0) {
                this.currentBufferPosition += bytesRead;
            } else if (bytesRead == 0) {
                throw new RuntimeException("i'm doing something wrong");
            }
        }
        return bytesRead;
    }

    /* access modifiers changed from: private */
    public void finishData() {
        if (!this.savedChunks) {
            this.length = this.totalBytes;
            this.savedChunks = true;
            try {
                if (this.inputStream != null && this.closeStreamOnPersist) {
                    this.inputStream.close();
                }
            } catch (IOException e) {
            }
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/gridfs/GridFSInputFile$GridFSOutputStream.class */
    private class GridFSOutputStream extends OutputStream {
        private GridFSOutputStream() {
        }

        @Override // java.io.OutputStream
        public void write(int b) throws IOException {
            write(new byte[]{(byte) (b & 255)}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b, int off, int len) throws IOException {
            int offset = off;
            int length = len;
            while (length > 0) {
                int toCopy = length;
                if (((long) toCopy) > GridFSInputFile.this.chunkSize - ((long) GridFSInputFile.this.currentBufferPosition)) {
                    toCopy = ((int) GridFSInputFile.this.chunkSize) - GridFSInputFile.this.currentBufferPosition;
                }
                System.arraycopy(b, offset, GridFSInputFile.this.buffer, GridFSInputFile.this.currentBufferPosition, toCopy);
                GridFSInputFile.access$112(GridFSInputFile.this, toCopy);
                offset += toCopy;
                length -= toCopy;
                if (((long) GridFSInputFile.this.currentBufferPosition) == GridFSInputFile.this.chunkSize) {
                    GridFSInputFile.this.dumpBuffer(false);
                }
            }
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            GridFSInputFile.this.dumpBuffer(true);
            GridFSInputFile.this.finishData();
            GridFSInputFile.this.save();
        }
    }
}
