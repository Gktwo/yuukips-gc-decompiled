package dev.morphia.aggregation.experimental.expressions;

import com.mongodb.QueryOperators;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.aggregation.experimental.expressions.impls.MathExpression;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/MathExpressions.class */
public final class MathExpressions {
    protected MathExpressions() {
    }

    public static Expression abs(Expression value) {
        return new MathExpression("$abs", value);
    }

    public static MathExpression add(Expression first, Expression... additional) {
        List<Expression> expressions = new ArrayList<>();
        expressions.add(first);
        expressions.addAll(Arrays.asList(additional));
        return new MathExpression("$add", expressions);
    }

    public static Expression ceil(Expression value) {
        return new MathExpression("$ceil", value);
    }

    public static Expression divide(Expression numerator, Expression divisor) {
        return new MathExpression("$divide", List.of(numerator, divisor));
    }

    public static Expression exp(Expression value) {
        return new MathExpression("$exp", value);
    }

    public static Expression floor(Expression value) {
        return new MathExpression("$floor", value);
    }

    /* renamed from: ln */
    public static Expression m1258ln(Expression value) {
        return new MathExpression("$ln", value);
    }

    public static Expression log(Expression number, Expression base) {
        return new MathExpression("$log", List.of(number, base));
    }

    public static Expression log10(Expression value) {
        return new MathExpression("$log10", value);
    }

    public static Expression mod(Expression dividend, Expression divisor) {
        return new MathExpression(QueryOperators.MOD, List.of(dividend, divisor));
    }

    public static Expression multiply(Expression first, Expression... additional) {
        List<Expression> expressions = new ArrayList<>(Arrays.asList(first));
        expressions.addAll(Arrays.asList(additional));
        return new MathExpression("$multiply", expressions);
    }

    public static Expression pow(Expression number, Expression exponent) {
        return new MathExpression("$pow", List.of(number, exponent));
    }

    public static Expression round(Expression number, Expression place) {
        return new MathExpression("$round", Arrays.asList(number, place));
    }

    public static Expression sqrt(Expression value) {
        return new MathExpression("$sqrt", value);
    }

    public static Expression subtract(Expression minuend, Expression subtrahend) {
        return new MathExpression("$subtract", List.of(minuend, subtrahend));
    }

    public static Expression trunc(Expression number, Expression place) {
        ArrayList<Expression> params = new ArrayList<>();
        params.add(number);
        if (place != null) {
            params.add(place);
        }
        return new MathExpression("$trunc", params);
    }
}
