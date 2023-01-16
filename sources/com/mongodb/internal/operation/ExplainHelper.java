package com.mongodb.internal.operation;

import com.mongodb.ExplainVerbosity;
import com.mongodb.MongoInternalException;
import com.mongodb.lang.Nullable;
import org.bson.BsonDocument;
import org.bson.BsonString;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/operation/ExplainHelper.class */
public final class ExplainHelper {
    /* access modifiers changed from: package-private */
    public static BsonDocument asExplainCommand(BsonDocument command, @Nullable ExplainVerbosity explainVerbosity) {
        BsonDocument explainCommand = new BsonDocument("explain", command);
        if (explainVerbosity != null) {
            explainCommand.append("verbosity", getVerbosityAsString(explainVerbosity));
        }
        return explainCommand;
    }

    private static BsonString getVerbosityAsString(ExplainVerbosity explainVerbosity) {
        switch (explainVerbosity) {
            case QUERY_PLANNER:
                return new BsonString("queryPlanner");
            case EXECUTION_STATS:
                return new BsonString("executionStats");
            case ALL_PLANS_EXECUTIONS:
                return new BsonString("allPlansExecution");
            default:
                throw new MongoInternalException(String.format("Unsupported explain verbosity %s", explainVerbosity));
        }
    }

    private ExplainHelper() {
    }
}
