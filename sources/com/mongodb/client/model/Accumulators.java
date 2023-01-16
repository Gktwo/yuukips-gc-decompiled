package com.mongodb.client.model;

import com.mongodb.lang.Nullable;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonString;

/* loaded from: grasscutter.jar:com/mongodb/client/model/Accumulators.class */
public final class Accumulators {
    public static <TExpression> BsonField sum(String fieldName, TExpression expression) {
        return accumulatorOperator("$sum", fieldName, expression);
    }

    public static <TExpression> BsonField avg(String fieldName, TExpression expression) {
        return accumulatorOperator("$avg", fieldName, expression);
    }

    public static <TExpression> BsonField first(String fieldName, TExpression expression) {
        return accumulatorOperator("$first", fieldName, expression);
    }

    public static <TExpression> BsonField last(String fieldName, TExpression expression) {
        return accumulatorOperator("$last", fieldName, expression);
    }

    public static <TExpression> BsonField max(String fieldName, TExpression expression) {
        return accumulatorOperator("$max", fieldName, expression);
    }

    public static <TExpression> BsonField min(String fieldName, TExpression expression) {
        return accumulatorOperator("$min", fieldName, expression);
    }

    public static <TExpression> BsonField push(String fieldName, TExpression expression) {
        return accumulatorOperator("$push", fieldName, expression);
    }

    public static <TExpression> BsonField addToSet(String fieldName, TExpression expression) {
        return accumulatorOperator("$addToSet", fieldName, expression);
    }

    public static <TExpression> BsonField stdDevPop(String fieldName, TExpression expression) {
        return accumulatorOperator("$stdDevPop", fieldName, expression);
    }

    public static <TExpression> BsonField stdDevSamp(String fieldName, TExpression expression) {
        return accumulatorOperator("$stdDevSamp", fieldName, expression);
    }

    public static BsonField accumulator(String fieldName, String initFunction, String accumulateFunction, String mergeFunction) {
        return accumulator(fieldName, initFunction, null, accumulateFunction, null, mergeFunction, null, "js");
    }

    public static BsonField accumulator(String fieldName, String initFunction, String accumulateFunction, String mergeFunction, @Nullable String finalizeFunction) {
        return accumulator(fieldName, initFunction, null, accumulateFunction, null, mergeFunction, finalizeFunction, "js");
    }

    public static BsonField accumulator(String fieldName, String initFunction, @Nullable List<String> initArgs, String accumulateFunction, @Nullable List<String> accumulateArgs, String mergeFunction, @Nullable String finalizeFunction) {
        return accumulator(fieldName, initFunction, initArgs, accumulateFunction, accumulateArgs, mergeFunction, finalizeFunction, "js");
    }

    public static BsonField accumulator(String fieldName, String initFunction, String accumulateFunction, String mergeFunction, @Nullable String finalizeFunction, String lang) {
        return accumulator(fieldName, initFunction, null, accumulateFunction, null, mergeFunction, finalizeFunction, lang);
    }

    public static BsonField accumulator(String fieldName, String initFunction, @Nullable List<String> initArgs, String accumulateFunction, @Nullable List<String> accumulateArgs, String mergeFunction, @Nullable String finalizeFunction, String lang) {
        BsonDocument accumulatorStage = new BsonDocument("init", new BsonString(initFunction)).append("initArgs", initArgs != null ? new BsonArray((List) initArgs.stream().map(initArg -> {
            return new BsonString(initArg);
        }).collect(Collectors.toList())) : new BsonArray()).append("accumulate", new BsonString(accumulateFunction)).append("accumulateArgs", accumulateArgs != null ? new BsonArray((List) accumulateArgs.stream().map(accumulateArg -> {
            return new BsonString(accumulateArg);
        }).collect(Collectors.toList())) : new BsonArray()).append("merge", new BsonString(mergeFunction)).append("lang", new BsonString(lang));
        if (finalizeFunction != null) {
            accumulatorStage.append("finalize", new BsonString(finalizeFunction));
        }
        return accumulatorOperator("$accumulator", fieldName, accumulatorStage);
    }

    private static <TExpression> BsonField accumulatorOperator(String name, String fieldName, TExpression expression) {
        return new BsonField(fieldName, new SimpleExpression(name, expression));
    }

    private Accumulators() {
    }
}
