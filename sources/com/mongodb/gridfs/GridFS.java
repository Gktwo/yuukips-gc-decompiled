package com.mongodb.gridfs;

import com.mongodb.BasicDBObject;
import com.mongodb.C0961DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:com/mongodb/gridfs/GridFS.class */
public class GridFS {
    public static final int DEFAULT_CHUNKSIZE = 261120;
    public static final String DEFAULT_BUCKET = "fs";
    private final C0961DB database;
    private final String bucketName;
    private final DBCollection filesCollection;
    private final DBCollection chunksCollection;

    public GridFS(C0961DB db) {
        this(db, DEFAULT_BUCKET);
    }

    public GridFS(C0961DB db, String bucket) {
        this.database = db;
        this.bucketName = bucket;
        this.filesCollection = this.database.getCollection(this.bucketName + ".files");
        this.chunksCollection = this.database.getCollection(this.bucketName + ".chunks");
        try {
            if (this.filesCollection.count() < 1000) {
                this.filesCollection.createIndex(new BasicDBObject("filename", 1).append("uploadDate", (Object) 1));
            }
            if (this.chunksCollection.count() < 1000) {
                this.chunksCollection.createIndex(new BasicDBObject("files_id", 1).append("n", (Object) 1), new BasicDBObject("unique", true));
            }
        } catch (MongoException e) {
        }
        this.filesCollection.setObjectClass(GridFSDBFile.class);
    }

    public DBCursor getFileList() {
        return this.filesCollection.find().sort(new BasicDBObject("filename", 1));
    }

    public DBCursor getFileList(DBObject query) {
        return this.filesCollection.find(query).sort(new BasicDBObject("filename", 1));
    }

    public DBCursor getFileList(DBObject query, DBObject sort) {
        return this.filesCollection.find(query).sort(sort);
    }

    public GridFSDBFile find(ObjectId objectId) {
        return findOne(objectId);
    }

    public GridFSDBFile findOne(ObjectId objectId) {
        return findOne(new BasicDBObject(DBCollection.ID_FIELD_NAME, objectId));
    }

    public GridFSDBFile findOne(String filename) {
        return findOne(new BasicDBObject("filename", filename));
    }

    public GridFSDBFile findOne(DBObject query) {
        return injectGridFSInstance(this.filesCollection.findOne(query));
    }

    public List<GridFSDBFile> find(String filename) {
        return find(new BasicDBObject("filename", filename));
    }

    public List<GridFSDBFile> find(String filename, DBObject sort) {
        return find(new BasicDBObject("filename", filename), sort);
    }

    public List<GridFSDBFile> find(DBObject query) {
        return find(query, (DBObject) null);
    }

    public List<GridFSDBFile> find(DBObject query, DBObject sort) {
        List<GridFSDBFile> files = new ArrayList<>();
        DBCursor cursor = this.filesCollection.find(query);
        if (sort != null) {
            cursor.sort(sort);
        }
        while (cursor.hasNext()) {
            try {
                files.add(injectGridFSInstance(cursor.next()));
            } finally {
                cursor.close();
            }
        }
        return Collections.unmodifiableList(files);
    }

    private GridFSDBFile injectGridFSInstance(Object o) {
        if (o == null) {
            return null;
        }
        if (!(o instanceof GridFSDBFile)) {
            throw new IllegalArgumentException("somehow didn't get a GridFSDBFile");
        }
        GridFSDBFile f = (GridFSDBFile) o;
        f.f452fs = this;
        return f;
    }

    public void remove(ObjectId id) {
        if (id == null) {
            throw new IllegalArgumentException("file id can not be null");
        }
        this.filesCollection.remove(new BasicDBObject(DBCollection.ID_FIELD_NAME, id));
        this.chunksCollection.remove(new BasicDBObject("files_id", id));
    }

    public void remove(String filename) {
        if (filename == null) {
            throw new IllegalArgumentException("filename can not be null");
        }
        remove(new BasicDBObject("filename", filename));
    }

    public void remove(DBObject query) {
        if (query == null) {
            throw new IllegalArgumentException("query can not be null");
        }
        for (GridFSDBFile f : find(query)) {
            f.remove();
        }
    }

    public GridFSInputFile createFile(byte[] data) {
        return createFile((InputStream) new ByteArrayInputStream(data), true);
    }

    public GridFSInputFile createFile(File file) throws IOException {
        return createFile(new FileInputStream(file), file.getName(), true);
    }

    public GridFSInputFile createFile(InputStream in) {
        return createFile(in, (String) null);
    }

    public GridFSInputFile createFile(InputStream in, boolean closeStreamOnPersist) {
        return createFile(in, null, closeStreamOnPersist);
    }

    public GridFSInputFile createFile(InputStream in, String filename) {
        return new GridFSInputFile(this, in, filename);
    }

    public GridFSInputFile createFile(InputStream in, String filename, boolean closeStreamOnPersist) {
        return new GridFSInputFile(this, in, filename, closeStreamOnPersist);
    }

    public GridFSInputFile createFile(String filename) {
        return new GridFSInputFile(this, filename);
    }

    public GridFSInputFile createFile() {
        return new GridFSInputFile(this);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public C0961DB getDB() {
        return this.database;
    }

    /* access modifiers changed from: protected */
    public DBCollection getFilesCollection() {
        return this.filesCollection;
    }

    /* access modifiers changed from: protected */
    public DBCollection getChunksCollection() {
        return this.chunksCollection;
    }
}
