package com.mongodb.client.gridfs.model;

import com.mongodb.MongoGridFSException;
import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.Date;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:com/mongodb/client/gridfs/model/GridFSFile.class */
public final class GridFSFile {

    /* renamed from: id */
    private final BsonValue f441id;
    private final String filename;
    private final long length;
    private final int chunkSize;
    private final Date uploadDate;
    private final Document metadata;

    public GridFSFile(BsonValue id, String filename, long length, int chunkSize, Date uploadDate, @Nullable Document metadata) {
        this.f441id = (BsonValue) Assertions.notNull("id", id);
        this.filename = (String) Assertions.notNull("filename", filename);
        this.length = ((Long) Assertions.notNull("length", Long.valueOf(length))).longValue();
        this.chunkSize = ((Integer) Assertions.notNull("chunkSize", Integer.valueOf(chunkSize))).intValue();
        this.uploadDate = (Date) Assertions.notNull("uploadDate", uploadDate);
        this.metadata = (metadata == null || !metadata.isEmpty()) ? metadata : null;
    }

    public ObjectId getObjectId() {
        if (this.f441id.isObjectId()) {
            return this.f441id.asObjectId().getValue();
        }
        throw new MongoGridFSException("Custom id type used for this GridFS file");
    }

    public BsonValue getId() {
        return this.f441id;
    }

    public String getFilename() {
        return this.filename;
    }

    public long getLength() {
        return this.length;
    }

    public int getChunkSize() {
        return this.chunkSize;
    }

    public Date getUploadDate() {
        return this.uploadDate;
    }

    @Nullable
    public Document getMetadata() {
        return this.metadata;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GridFSFile that = (GridFSFile) o;
        if (this.f441id != null) {
            if (!this.f441id.equals(that.f441id)) {
                return false;
            }
        } else if (that.f441id != null) {
            return false;
        }
        if (!this.filename.equals(that.filename) || this.length != that.length || this.chunkSize != that.chunkSize || !this.uploadDate.equals(that.uploadDate)) {
            return false;
        }
        if (this.metadata != null) {
            if (!this.metadata.equals(that.metadata)) {
                return false;
            }
            return true;
        } else if (that.metadata != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * (this.f441id != null ? this.f441id.hashCode() : 0)) + this.filename.hashCode())) + ((int) (this.length ^ (this.length >>> 32))))) + this.chunkSize)) + this.uploadDate.hashCode())) + (this.metadata != null ? this.metadata.hashCode() : 0);
    }

    public String toString() {
        return "GridFSFile{id=" + this.f441id + ", filename='" + this.filename + "', length=" + this.length + ", chunkSize=" + this.chunkSize + ", uploadDate=" + this.uploadDate + ", metadata=" + this.metadata + '}';
    }
}
