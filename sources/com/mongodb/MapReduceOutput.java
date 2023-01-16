package com.mongodb;

import com.mongodb.internal.operation.MapReduceBatchCursor;
import com.mongodb.internal.operation.MapReduceStatistics;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/MapReduceOutput.class */
public class MapReduceOutput {
    private final DBCollection collection;
    private final DBObject command;
    private final List<DBObject> inlineResults;
    private final MapReduceStatistics mapReduceStatistics;
    private final DBCursor resultsFromCollection;

    /* access modifiers changed from: package-private */
    public MapReduceOutput(DBObject command, MapReduceBatchCursor<DBObject> results) {
        this.command = command;
        this.mapReduceStatistics = results.getStatistics();
        this.collection = null;
        this.resultsFromCollection = null;
        this.inlineResults = new ArrayList();
        while (results.hasNext()) {
            this.inlineResults.addAll(results.next());
        }
        results.close();
    }

    /* access modifiers changed from: package-private */
    public MapReduceOutput(DBObject command, DBCursor resultsFromCollection, MapReduceStatistics mapReduceStatistics, DBCollection outputCollection) {
        this.command = command;
        this.inlineResults = null;
        this.mapReduceStatistics = mapReduceStatistics;
        this.collection = outputCollection;
        this.resultsFromCollection = resultsFromCollection;
    }

    public Iterable<DBObject> results() {
        if (this.inlineResults != null) {
            return this.inlineResults;
        }
        return this.resultsFromCollection;
    }

    public void drop() {
        if (this.collection != null) {
            this.collection.drop();
        }
    }

    @Nullable
    public DBCollection getOutputCollection() {
        return this.collection;
    }

    public DBObject getCommand() {
        return this.command;
    }

    public String toString() {
        return "MapReduceOutput{collection=" + this.collection + ", command=" + this.command + ", inlineResults=" + this.inlineResults + ", resultsFromCollection=" + this.resultsFromCollection + '}';
    }

    @Nullable
    public final String getCollectionName() {
        if (this.collection == null) {
            return null;
        }
        return this.collection.getName();
    }

    public String getDatabaseName() {
        return this.collection.getDB().getName();
    }

    public int getDuration() {
        return this.mapReduceStatistics.getDuration();
    }

    public int getInputCount() {
        return this.mapReduceStatistics.getInputCount();
    }

    public int getOutputCount() {
        return this.mapReduceStatistics.getOutputCount();
    }

    public int getEmitCount() {
        return this.mapReduceStatistics.getEmitCount();
    }
}
