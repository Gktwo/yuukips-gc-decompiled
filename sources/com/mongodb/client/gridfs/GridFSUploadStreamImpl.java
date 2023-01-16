package com.mongodb.client.gridfs;

import com.mongodb.MongoGridFSException;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.lang.Nullable;
import java.util.Date;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.types.Binary;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:com/mongodb/client/gridfs/GridFSUploadStreamImpl.class */
final class GridFSUploadStreamImpl extends GridFSUploadStream {
    private final ClientSession clientSession;
    private final MongoCollection<GridFSFile> filesCollection;
    private final MongoCollection<Document> chunksCollection;
    private final BsonValue fileId;
    private final String filename;
    private final int chunkSizeBytes;
    private final Document metadata;
    private byte[] buffer;
    private long lengthInBytes;
    private final Object closeLock = new Object();
    private boolean closed = false;
    private int chunkIndex = 0;
    private int bufferOffset = 0;

    /* access modifiers changed from: package-private */
    public GridFSUploadStreamImpl(@Nullable ClientSession clientSession, MongoCollection<GridFSFile> filesCollection, MongoCollection<Document> chunksCollection, BsonValue fileId, String filename, int chunkSizeBytes, @Nullable Document metadata) {
        this.clientSession = clientSession;
        this.filesCollection = (MongoCollection) Assertions.notNull("files collection", filesCollection);
        this.chunksCollection = (MongoCollection) Assertions.notNull("chunks collection", chunksCollection);
        this.fileId = (BsonValue) Assertions.notNull("File Id", fileId);
        this.filename = (String) Assertions.notNull("filename", filename);
        this.chunkSizeBytes = chunkSizeBytes;
        this.metadata = metadata;
        this.buffer = new byte[chunkSizeBytes];
    }

    @Override // com.mongodb.client.gridfs.GridFSUploadStream
    public ObjectId getObjectId() {
        if (this.fileId.isObjectId()) {
            return this.fileId.asObjectId().getValue();
        }
        throw new MongoGridFSException("Custom id type used for this GridFS upload stream");
    }

    @Override // com.mongodb.client.gridfs.GridFSUploadStream
    public BsonValue getId() {
        return this.fileId;
    }

    @Override // com.mongodb.client.gridfs.GridFSUploadStream
    public void abort() {
        synchronized (this.closeLock) {
            checkClosed();
            this.closed = true;
        }
        if (this.clientSession != null) {
            this.chunksCollection.deleteMany(this.clientSession, new Document("files_id", this.fileId));
        } else {
            this.chunksCollection.deleteMany(new Document("files_id", this.fileId));
        }
    }

    @Override // com.mongodb.client.gridfs.GridFSUploadStream, java.io.OutputStream
    public void write(int b) {
        write(new byte[]{(byte) (255 & b)}, 0, 1);
    }

    @Override // com.mongodb.client.gridfs.GridFSUploadStream, java.io.OutputStream
    public void write(byte[] b) {
        write(b, 0, b.length);
    }

    @Override // com.mongodb.client.gridfs.GridFSUploadStream, java.io.OutputStream
    public void write(byte[] b, int off, int len) {
        checkClosed();
        Assertions.notNull("b", b);
        if (off < 0 || off > b.length || len < 0 || off + len > b.length || off + len < 0) {
            throw new IndexOutOfBoundsException();
        } else if (len != 0) {
            int currentOffset = off;
            int lengthToWrite = len;
            while (lengthToWrite > 0) {
                int amountToCopy = lengthToWrite;
                if (amountToCopy > this.chunkSizeBytes - this.bufferOffset) {
                    amountToCopy = this.chunkSizeBytes - this.bufferOffset;
                }
                System.arraycopy(b, currentOffset, this.buffer, this.bufferOffset, amountToCopy);
                this.bufferOffset += amountToCopy;
                currentOffset += amountToCopy;
                lengthToWrite -= amountToCopy;
                this.lengthInBytes += (long) amountToCopy;
                if (this.bufferOffset == this.chunkSizeBytes) {
                    writeChunk();
                }
            }
        }
    }

    @Override // com.mongodb.client.gridfs.GridFSUploadStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.closeLock) {
            if (!this.closed) {
                this.closed = true;
                writeChunk();
                GridFSFile gridFSFile = new GridFSFile(this.fileId, this.filename, this.lengthInBytes, this.chunkSizeBytes, new Date(), this.metadata);
                if (this.clientSession != null) {
                    this.filesCollection.insertOne(this.clientSession, (ClientSession) gridFSFile);
                } else {
                    this.filesCollection.insertOne(gridFSFile);
                }
                this.buffer = null;
            }
        }
    }

    private void writeChunk() {
        if (this.bufferOffset > 0) {
            if (this.clientSession != null) {
                this.chunksCollection.insertOne(this.clientSession, (ClientSession) new Document("files_id", this.fileId).append("n", Integer.valueOf(this.chunkIndex)).append("data", getData()));
            } else {
                this.chunksCollection.insertOne(new Document("files_id", this.fileId).append("n", Integer.valueOf(this.chunkIndex)).append("data", getData()));
            }
            this.chunkIndex++;
            this.bufferOffset = 0;
        }
    }

    private Binary getData() {
        if (this.bufferOffset < this.chunkSizeBytes) {
            byte[] sizedBuffer = new byte[this.bufferOffset];
            System.arraycopy(this.buffer, 0, sizedBuffer, 0, this.bufferOffset);
            this.buffer = sizedBuffer;
        }
        return new Binary(this.buffer);
    }

    private void checkClosed() {
        synchronized (this.closeLock) {
            if (this.closed) {
                throw new MongoGridFSException("The OutputStream has been closed");
            }
        }
    }
}
