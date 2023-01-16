package dev.morphia.aggregation.experimental.expressions;

import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.aggregation.experimental.expressions.impls.IndexExpression;
import dev.morphia.aggregation.experimental.expressions.impls.RegexExpression;
import dev.morphia.aggregation.experimental.expressions.impls.ReplaceExpression;
import dev.morphia.aggregation.experimental.expressions.impls.TrimExpression;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/StringExpressions.class */
public final class StringExpressions {
    private static final Logger LOG = LoggerFactory.getLogger(StringExpressions.class);

    private StringExpressions() {
    }

    public static Expression concat(Expression first, Expression... additional) {
        return new Expression("$concat", Expressions.toList(first, additional));
    }

    public static IndexExpression indexOfBytes(Expression string, Expression substring) {
        return new IndexExpression("$indexOfBytes", string, substring);
    }

    public static IndexExpression indexOfCP(Expression string, Expression substring) {
        return new IndexExpression("$indexOfCP", string, substring);
    }

    public static TrimExpression ltrim(Expression input) {
        return new TrimExpression("$ltrim", input);
    }

    public static RegexExpression regexFind(Expression input) {
        return new RegexExpression("$regexFind", input);
    }

    public static RegexExpression regexFindAll(Expression input) {
        return new RegexExpression("$regexFindAll", input);
    }

    public static RegexExpression regexMatch(Expression input) {
        return new RegexExpression("$regexMatch", input);
    }

    public static Expression replaceAll(Expression input, Expression find, Expression replacement) {
        return new ReplaceExpression("$replaceAll", input, find, replacement);
    }

    public static Expression replaceOne(Expression input, Expression find, Expression replacement) {
        return new ReplaceExpression("$replaceOne", input, find, replacement);
    }

    public static TrimExpression rtrim(Expression input) {
        return new TrimExpression("$rtrim", input);
    }

    public static Expression split(Expression input, Expression delimiter) {
        return new Expression("$split", Arrays.asList(input, delimiter));
    }

    public static Expression strLenBytes(Expression input) {
        return new Expression("$strLenBytes", input);
    }

    public static Expression strLenCP(Expression input) {
        return new Expression("$strLenCP", input);
    }

    public static Expression strcasecmp(Expression first, Expression second) {
        return new Expression("$strcasecmp", Arrays.asList(first, second));
    }

    @Deprecated
    public static Expression substr(Expression input, int start, int length) {
        throw new UnsupportedOperationException("Use $substrBytes or $substrCP.");
    }

    public static Expression substrBytes(Expression input, int start, int length) {
        return new Expression("$substrBytes", Arrays.asList(input, Integer.valueOf(start), Integer.valueOf(length)));
    }

    public static Expression substrCP(Expression input, int start, int length) {
        return new Expression("$substrCP", Arrays.asList(input, Integer.valueOf(start), Integer.valueOf(length)));
    }

    public static Expression toLower(Expression input) {
        return new Expression("$toLower", input);
    }

    public static Expression toString(Expression input) {
        return new Expression("$toString", input);
    }

    public static Expression toUpper(Expression input) {
        return new Expression("$toUpper", input);
    }

    public static TrimExpression trim(Expression input) {
        return new TrimExpression("$trim", input);
    }
}
