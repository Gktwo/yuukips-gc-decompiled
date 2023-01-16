package com.mongodb.client.gridfs;

import com.mongodb.client.MongoIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.client.model.Collation;
import com.mongodb.lang.Nullable;
import java.util.concurrent.TimeUnit;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/gridfs/GridFSFindIterable.class */
public interface GridFSFindIterable extends MongoIterable<GridFSFile> {
    GridFSFindIterable filter(@Nullable Bson bson);

    GridFSFindIterable limit(int i);

    GridFSFindIterable skip(int i);

    GridFSFindIterable sort(@Nullable Bson bson);

    GridFSFindIterable noCursorTimeout(boolean z);

    GridFSFindIterable maxTime(long j, TimeUnit timeUnit);

    /* Return type fixed from 'com.mongodb.client.gridfs.GridFSFindIterable' to match base method */
    @Override // com.mongodb.client.MongoIterable
    MongoIterable<GridFSFile> batchSize(int i);

    GridFSFindIterable collation(@Nullable Collation collation);
}
