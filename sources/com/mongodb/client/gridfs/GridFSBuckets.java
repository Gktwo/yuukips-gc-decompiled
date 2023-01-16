package com.mongodb.client.gridfs;

import com.mongodb.client.MongoDatabase;

/* loaded from: grasscutter.jar:com/mongodb/client/gridfs/GridFSBuckets.class */
public final class GridFSBuckets {
    public static GridFSBucket create(MongoDatabase database) {
        return new GridFSBucketImpl(database);
    }

    public static GridFSBucket create(MongoDatabase database, String bucketName) {
        return new GridFSBucketImpl(database, bucketName);
    }

    private GridFSBuckets() {
    }
}
