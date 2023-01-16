package com.mongodb;

import com.mongodb.client.model.Collation;
import com.mongodb.lang.Nullable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.pattern.parser.Parser;

/* loaded from: grasscutter.jar:com/mongodb/MapReduceCommand.class */
public class MapReduceCommand {
    private final String mapReduce;
    private final String map;
    private final String reduce;
    private String finalize;
    private ReadPreference readPreference;
    private final OutputType outputType;
    private final String outputCollection;
    private final DBObject query;
    private DBObject sort;
    private int limit;
    private long maxTimeMS;
    private Map<String, Object> scope;
    private Boolean jsMode;
    private Boolean bypassDocumentValidation;
    private Collation collation;
    private String outputDB = null;
    private Boolean verbose = true;

    /* loaded from: grasscutter.jar:com/mongodb/MapReduceCommand$OutputType.class */
    public enum OutputType {
        REPLACE,
        MERGE,
        REDUCE,
        INLINE
    }

    public MapReduceCommand(DBCollection inputCollection, String map, String reduce, @Nullable String outputCollection, OutputType type, DBObject query) {
        this.mapReduce = inputCollection.getName();
        this.map = map;
        this.reduce = reduce;
        this.outputCollection = outputCollection;
        this.outputType = type;
        this.query = query;
    }

    public void setVerbose(Boolean verbose) {
        this.verbose = verbose;
    }

    public Boolean isVerbose() {
        return this.verbose;
    }

    public String getInput() {
        return this.mapReduce;
    }

    public String getMap() {
        return this.map;
    }

    public String getReduce() {
        return this.reduce;
    }

    @Nullable
    public String getOutputTarget() {
        return this.outputCollection;
    }

    public OutputType getOutputType() {
        return this.outputType;
    }

    @Nullable
    public String getFinalize() {
        return this.finalize;
    }

    public void setFinalize(@Nullable String finalize) {
        this.finalize = finalize;
    }

    @Nullable
    public DBObject getQuery() {
        return this.query;
    }

    @Nullable
    public DBObject getSort() {
        return this.sort;
    }

    public void setSort(@Nullable DBObject sort) {
        this.sort = sort;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getMaxTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.maxTimeMS, TimeUnit.MILLISECONDS);
    }

    public void setMaxTime(long maxTime, TimeUnit timeUnit) {
        this.maxTimeMS = TimeUnit.MILLISECONDS.convert(maxTime, timeUnit);
    }

    @Nullable
    public Map<String, Object> getScope() {
        return this.scope;
    }

    public void setScope(@Nullable Map<String, Object> scope) {
        this.scope = scope;
    }

    @Nullable
    public Boolean getJsMode() {
        return this.jsMode;
    }

    public void setJsMode(@Nullable Boolean jsMode) {
        this.jsMode = jsMode;
    }

    @Nullable
    public String getOutputDB() {
        return this.outputDB;
    }

    public void setOutputDB(@Nullable String outputDB) {
        this.outputDB = outputDB;
    }

    @Nullable
    public Boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public void setBypassDocumentValidation(@Nullable Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
    }

    public DBObject toDBObject() {
        BasicDBObject cmd = new BasicDBObject();
        cmd.put((Object) "mapreduce", (Object) this.mapReduce);
        cmd.put((Object) "map", (Object) this.map);
        cmd.put((Object) "reduce", (Object) this.reduce);
        if (this.verbose != null) {
            cmd.put((Object) "verbose", (Object) this.verbose);
        }
        BasicDBObject out = new BasicDBObject();
        switch (this.outputType) {
            case INLINE:
                out.put((Object) "inline", (Object) 1);
                break;
            case REPLACE:
                out.put((Object) Parser.REPLACE_CONVERTER_WORD, (Object) this.outputCollection);
                break;
            case MERGE:
                out.put((Object) "merge", (Object) this.outputCollection);
                break;
            case REDUCE:
                out.put((Object) "reduce", (Object) this.outputCollection);
                break;
            default:
                throw new IllegalArgumentException("Unexpected output type");
        }
        if (this.outputDB != null) {
            out.put((Object) "db", (Object) this.outputDB);
        }
        cmd.put((Object) "out", (Object) out);
        if (this.query != null) {
            cmd.put((Object) "query", (Object) this.query);
        }
        if (this.finalize != null) {
            cmd.put((Object) "finalize", (Object) this.finalize);
        }
        if (this.sort != null) {
            cmd.put((Object) "sort", (Object) this.sort);
        }
        if (this.limit > 0) {
            cmd.put((Object) "limit", (Object) Integer.valueOf(this.limit));
        }
        if (this.scope != null) {
            cmd.put((Object) Action.SCOPE_ATTRIBUTE, (Object) this.scope);
        }
        if (this.jsMode != null) {
            cmd.put((Object) "jsMode", (Object) this.jsMode);
        }
        if (this.maxTimeMS != 0) {
            cmd.put((Object) "maxTimeMS", (Object) Long.valueOf(this.maxTimeMS));
        }
        return cmd;
    }

    public void setReadPreference(@Nullable ReadPreference preference) {
        this.readPreference = preference;
    }

    @Nullable
    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    @Nullable
    public Collation getCollation() {
        return this.collation;
    }

    @Nullable
    public void setCollation(Collation collation) {
        this.collation = collation;
    }

    public String toString() {
        return toDBObject().toString();
    }

    /* access modifiers changed from: package-private */
    public String getOutputTargetNonNull() {
        if (this.outputCollection != null) {
            return this.outputCollection;
        }
        throw new MongoInternalException("outputCollection can not be null in this context");
    }
}
