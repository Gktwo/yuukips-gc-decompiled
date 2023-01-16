package com.mongodb.client.gridfs;

import com.mongodb.MongoGridFSException;
import com.mongodb.QueryOperators;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.lang.Nullable;
import org.bson.BsonValue;
import org.bson.Document;

/* loaded from: grasscutter.jar:com/mongodb/client/gridfs/GridFSDownloadStreamImpl.class */
class GridFSDownloadStreamImpl extends GridFSDownloadStream {
    private final ClientSession clientSession;
    private final GridFSFile fileInfo;
    private final MongoCollection<Document> chunksCollection;
    private final BsonValue fileId;
    private final long length;
    private final int chunkSizeInBytes;
    private final int numberOfChunks;
    private MongoCursor<Document> cursor;
    private int batchSize;
    private int chunkIndex;
    private int bufferOffset;
    private long currentPosition;
    private long markPosition;
    private byte[] buffer = null;
    private final Object closeLock = new Object();
    private final Object cursorLock = new Object();
    private boolean closed = false;

    /* access modifiers changed from: package-private */
    public GridFSDownloadStreamImpl(@Nullable ClientSession clientSession, GridFSFile fileInfo, MongoCollection<Document> chunksCollection) {
        this.clientSession = clientSession;
        this.fileInfo = (GridFSFile) Assertions.notNull("file information", fileInfo);
        this.chunksCollection = (MongoCollection) Assertions.notNull("chunks collection", chunksCollection);
        this.fileId = fileInfo.getId();
        this.length = fileInfo.getLength();
        this.chunkSizeInBytes = fileInfo.getChunkSize();
        this.numberOfChunks = (int) Math.ceil(((double) this.length) / ((double) this.chunkSizeInBytes));
    }

    @Override // com.mongodb.client.gridfs.GridFSDownloadStream
    public GridFSFile getGridFSFile() {
        return this.fileInfo;
    }

    @Override // com.mongodb.client.gridfs.GridFSDownloadStream
    public GridFSDownloadStream batchSize(int batchSize) {
        Assertions.isTrueArgument("batchSize cannot be negative", batchSize >= 0);
        this.batchSize = batchSize;
        discardCursor();
        return this;
    }

    @Override // com.mongodb.client.gridfs.GridFSDownloadStream, java.io.InputStream
    public int read() {
        byte[] b = new byte[1];
        if (read(b) < 0) {
            return -1;
        }
        return b[0] & 255;
    }

    @Override // com.mongodb.client.gridfs.GridFSDownloadStream, java.io.InputStream
    public int read(byte[] b) {
        return read(b, 0, b.length);
    }

    @Override // com.mongodb.client.gridfs.GridFSDownloadStream, java.io.InputStream
    public int read(byte[] b, int off, int len) {
        checkClosed();
        if (this.currentPosition == this.length) {
            return -1;
        }
        if (this.buffer == null) {
            this.buffer = getBuffer(this.chunkIndex);
        } else if (this.bufferOffset == this.buffer.length) {
            this.chunkIndex++;
            this.buffer = getBuffer(this.chunkIndex);
            this.bufferOffset = 0;
        }
        int r = Math.min(len, this.buffer.length - this.bufferOffset);
        System.arraycopy(this.buffer, this.bufferOffset, b, off, r);
        this.bufferOffset += r;
        this.currentPosition += (long) r;
        return r;
    }

    @Override // com.mongodb.client.gridfs.GridFSDownloadStream, java.io.InputStream
    public long skip(long bytesToSkip) {
        checkClosed();
        if (bytesToSkip <= 0) {
            return 0;
        }
        long skippedPosition = this.currentPosition + bytesToSkip;
        this.bufferOffset = (int) (skippedPosition % ((long) this.chunkSizeInBytes));
        if (skippedPosition >= this.length) {
            long skipped = this.length - this.currentPosition;
            this.chunkIndex = this.numberOfChunks - 1;
            this.currentPosition = this.length;
            this.buffer = null;
            discardCursor();
            return skipped;
        }
        int newChunkIndex = (int) Math.floor(((double) skippedPosition) / ((double) this.chunkSizeInBytes));
        if (this.chunkIndex != newChunkIndex) {
            this.chunkIndex = newChunkIndex;
            this.buffer = null;
            discardCursor();
        }
        this.currentPosition += bytesToSkip;
        return bytesToSkip;
    }

    @Override // com.mongodb.client.gridfs.GridFSDownloadStream, java.io.InputStream
    public int available() {
        checkClosed();
        if (this.buffer == null) {
            return 0;
        }
        return this.buffer.length - this.bufferOffset;
    }

    @Override // com.mongodb.client.gridfs.GridFSDownloadStream
    public void mark() {
        mark(Integer.MAX_VALUE);
    }

    @Override // java.io.InputStream
    public synchronized void mark(int readlimit) {
        this.markPosition = this.currentPosition;
    }

    @Override // com.mongodb.client.gridfs.GridFSDownloadStream, java.io.InputStream
    public synchronized void reset() {
        checkClosed();
        if (this.currentPosition != this.markPosition) {
            this.bufferOffset = (int) (this.markPosition % ((long) this.chunkSizeInBytes));
            this.currentPosition = this.markPosition;
            int markChunkIndex = (int) Math.floor(((double) this.markPosition) / ((double) this.chunkSizeInBytes));
            if (markChunkIndex != this.chunkIndex) {
                this.chunkIndex = markChunkIndex;
                this.buffer = null;
                discardCursor();
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // com.mongodb.client.gridfs.GridFSDownloadStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.closeLock) {
            if (!this.closed) {
                this.closed = true;
            }
            discardCursor();
        }
    }

    private void checkClosed() {
        synchronized (this.closeLock) {
            if (this.closed) {
                throw new MongoGridFSException("The InputStream has been closed");
            }
        }
    }

    private void discardCursor() {
        synchronized (this.cursorLock) {
            if (this.cursor != null) {
                this.cursor.close();
                this.cursor = null;
            }
        }
    }

    @Nullable
    private Document getChunk(int startChunkIndex) {
        if (this.cursor == null) {
            this.cursor = getCursor(startChunkIndex);
        }
        Document chunk = null;
        if (this.cursor.hasNext()) {
            chunk = this.cursor.next();
            if (this.batchSize == 1) {
                discardCursor();
            }
            if (chunk.getInteger("n").intValue() != startChunkIndex) {
                throw new MongoGridFSException(String.format("Could not find file chunk for file_id: %s at chunk index %s.", this.fileId, Integer.valueOf(startChunkIndex)));
            }
        }
        return chunk;
    }

    private MongoCursor<Document> getCursor(int startChunkIndex) {
        FindIterable<Document> findIterable;
        Document filter = new Document("files_id", this.fileId).append("n", new Document(QueryOperators.GTE, Integer.valueOf(startChunkIndex)));
        if (this.clientSession != null) {
            findIterable = this.chunksCollection.find(this.clientSession, filter);
        } else {
            findIterable = this.chunksCollection.find(filter);
        }
        return findIterable.batchSize(this.batchSize).sort(new Document("n", 1)).iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [long] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] getBufferFromChunk(@com.mongodb.lang.Nullable org.bson.Document r10, int r11) {
        /*
        // Method dump skipped, instructions count: 261
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.client.gridfs.GridFSDownloadStreamImpl.getBufferFromChunk(org.bson.Document, int):byte[]");
    }

    private byte[] getBuffer(int chunkIndexToFetch) {
        return getBufferFromChunk(getChunk(chunkIndexToFetch), chunkIndexToFetch);
    }
}
