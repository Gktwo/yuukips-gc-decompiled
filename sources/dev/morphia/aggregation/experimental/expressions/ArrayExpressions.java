package dev.morphia.aggregation.experimental.expressions;

import com.mongodb.QueryOperators;
import dev.morphia.aggregation.experimental.expressions.impls.ArrayExpression;
import dev.morphia.aggregation.experimental.expressions.impls.ArrayFilterExpression;
import dev.morphia.aggregation.experimental.expressions.impls.ArrayIndexExpression;
import dev.morphia.aggregation.experimental.expressions.impls.ArrayLiteral;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.aggregation.experimental.expressions.impls.MapExpression;
import dev.morphia.aggregation.experimental.expressions.impls.RangeExpression;
import dev.morphia.aggregation.experimental.expressions.impls.ReduceExpression;
import dev.morphia.aggregation.experimental.expressions.impls.SliceExpression;
import dev.morphia.aggregation.experimental.expressions.impls.ZipExpression;
import java.util.Arrays;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/ArrayExpressions.class */
public final class ArrayExpressions {
    private ArrayExpressions() {
    }

    public static ArrayExpression array(Expression... expressions) {
        return new ArrayLiteral(expressions);
    }

    public static Expression arrayToObject(Expression array) {
        return new Expression("$arrayToObject", array);
    }

    public static Expression concatArrays(Expression array, Expression additional) {
        return new Expression("$concatArrays", Arrays.asList(array, additional));
    }

    public static Expression elementAt(Expression array, Expression index) {
        return new Expression("$arrayElemAt", List.of(array, index));
    }

    public static ArrayFilterExpression filter(Expression array, Expression conditional) {
        return new ArrayFilterExpression(array, conditional);
    }

    /* renamed from: in */
    public static Expression m1265in(Expression search, Expression array) {
        return new Expression(QueryOperators.f432IN, List.of(search, array));
    }

    public static Expression indexOfArray(Expression array, Expression search) {
        return new ArrayIndexExpression(array, search);
    }

    public static Expression isArray(Expression array) {
        return new Expression("$isArray", List.of(array));
    }

    public static MapExpression map(Expression input, Expression in) {
        return new MapExpression(input, in);
    }

    public static Expression objectToArray(Expression array) {
        return new Expression("$objectToArray", array);
    }

    public static RangeExpression range(int start, int end) {
        return new RangeExpression(start, end);
    }

    public static Expression reduce(Expression input, Expression initial, Expression in) {
        return new ReduceExpression(input, initial, in);
    }

    public static Expression reverseArray(Expression array) {
        return new Expression("$reverseArray", array);
    }

    public static Expression size(Expression array) {
        return new Expression(QueryOperators.SIZE, array);
    }

    public static Expression slice(Expression array, int size) {
        return new SliceExpression(array, size);
    }

    public static ZipExpression zip(Expression... arrays) {
        return new ZipExpression(Arrays.asList(arrays));
    }
}
