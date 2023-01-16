package com.mongodb;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: grasscutter.jar:com/mongodb/QueryBuilder.class */
public class QueryBuilder {
    private final DBObject _query = new BasicDBObject();
    private String _currentKey;
    private boolean _hasNot;

    public static QueryBuilder start() {
        return new QueryBuilder();
    }

    public static QueryBuilder start(String key) {
        return new QueryBuilder().put(key);
    }

    public QueryBuilder put(String key) {
        this._currentKey = key;
        if (this._query.get(key) == null) {
            this._query.put(this._currentKey, new NullObject());
        }
        return this;
    }

    public QueryBuilder and(String key) {
        return put(key);
    }

    public QueryBuilder greaterThan(Object object) {
        addOperand(QueryOperators.f429GT, object);
        return this;
    }

    public QueryBuilder greaterThanEquals(Object object) {
        addOperand(QueryOperators.GTE, object);
        return this;
    }

    public QueryBuilder lessThan(Object object) {
        addOperand(QueryOperators.f430LT, object);
        return this;
    }

    public QueryBuilder lessThanEquals(Object object) {
        addOperand(QueryOperators.LTE, object);
        return this;
    }

    /* renamed from: is */
    public QueryBuilder m1280is(Object object) {
        addOperand(null, object);
        return this;
    }

    public QueryBuilder notEquals(Object object) {
        addOperand(QueryOperators.f431NE, object);
        return this;
    }

    /* renamed from: in */
    public QueryBuilder m1281in(Object object) {
        addOperand(QueryOperators.f432IN, object);
        return this;
    }

    public QueryBuilder notIn(Object object) {
        addOperand(QueryOperators.NIN, object);
        return this;
    }

    public QueryBuilder mod(Object object) {
        addOperand(QueryOperators.MOD, object);
        return this;
    }

    public QueryBuilder all(Object object) {
        addOperand(QueryOperators.ALL, object);
        return this;
    }

    public QueryBuilder size(Object object) {
        addOperand(QueryOperators.SIZE, object);
        return this;
    }

    public QueryBuilder exists(Object object) {
        addOperand(QueryOperators.EXISTS, object);
        return this;
    }

    public QueryBuilder regex(Pattern regex) {
        addOperand(null, regex);
        return this;
    }

    public QueryBuilder elemMatch(DBObject match) {
        addOperand(QueryOperators.ELEM_MATCH, match);
        return this;
    }

    public QueryBuilder withinCenter(double x, double y, double radius) {
        addOperand(QueryOperators.WITHIN, new BasicDBObject(QueryOperators.CENTER, Arrays.asList(Arrays.asList(Double.valueOf(x), Double.valueOf(y)), Double.valueOf(radius))));
        return this;
    }

    public QueryBuilder near(double x, double y) {
        addOperand(QueryOperators.NEAR, Arrays.asList(Double.valueOf(x), Double.valueOf(y)));
        return this;
    }

    public QueryBuilder near(double x, double y, double maxDistance) {
        addOperand(QueryOperators.NEAR, Arrays.asList(Double.valueOf(x), Double.valueOf(y)));
        addOperand(QueryOperators.MAX_DISTANCE, Double.valueOf(maxDistance));
        return this;
    }

    public QueryBuilder nearSphere(double longitude, double latitude) {
        addOperand(QueryOperators.NEAR_SPHERE, Arrays.asList(Double.valueOf(longitude), Double.valueOf(latitude)));
        return this;
    }

    public QueryBuilder nearSphere(double longitude, double latitude, double maxDistance) {
        addOperand(QueryOperators.NEAR_SPHERE, Arrays.asList(Double.valueOf(longitude), Double.valueOf(latitude)));
        addOperand(QueryOperators.MAX_DISTANCE, Double.valueOf(maxDistance));
        return this;
    }

    public QueryBuilder withinCenterSphere(double longitude, double latitude, double maxDistance) {
        addOperand(QueryOperators.WITHIN, new BasicDBObject(QueryOperators.CENTER_SPHERE, Arrays.asList(Arrays.asList(Double.valueOf(longitude), Double.valueOf(latitude)), Double.valueOf(maxDistance))));
        return this;
    }

    public QueryBuilder withinBox(double x, double y, double x2, double y2) {
        addOperand(QueryOperators.WITHIN, new BasicDBObject(QueryOperators.BOX, new Object[]{new Double[]{Double.valueOf(x), Double.valueOf(y)}, new Double[]{Double.valueOf(x2), Double.valueOf(y2)}}));
        return this;
    }

    public QueryBuilder withinPolygon(List<Double[]> points) {
        Assertions.notNull("points", points);
        if (points.isEmpty() || points.size() < 3) {
            throw new IllegalArgumentException("Polygon insufficient number of vertices defined");
        }
        addOperand(QueryOperators.WITHIN, new BasicDBObject(QueryOperators.POLYGON, convertToListOfLists(points)));
        return this;
    }

    private List<List<Double>> convertToListOfLists(List<Double[]> points) {
        List<List<Double>> listOfLists = new ArrayList<>(points.size());
        for (Double[] cur : points) {
            List<Double> list = new ArrayList<>(cur.length);
            Collections.addAll(list, cur);
            listOfLists.add(list);
        }
        return listOfLists;
    }

    public QueryBuilder text(String search) {
        return text(search, null);
    }

    public QueryBuilder text(String search, @Nullable String language) {
        if (this._currentKey != null) {
            throw new QueryBuilderException("The text operand may only occur at the top-level of a query. It does not apply to a specific element, but rather to a document as a whole.");
        }
        put(QueryOperators.TEXT);
        addOperand(QueryOperators.SEARCH, search);
        if (language != null) {
            addOperand(QueryOperators.LANGUAGE, language);
        }
        return this;
    }

    public QueryBuilder not() {
        this._hasNot = true;
        return this;
    }

    /* renamed from: or */
    public QueryBuilder m1279or(DBObject... ors) {
        List l = (List) this._query.get(QueryOperators.f428OR);
        if (l == null) {
            l = new ArrayList();
            this._query.put(QueryOperators.f428OR, l);
        }
        Collections.addAll(l, ors);
        return this;
    }

    public QueryBuilder and(DBObject... ands) {
        List l = (List) this._query.get(QueryOperators.AND);
        if (l == null) {
            l = new ArrayList();
            this._query.put(QueryOperators.AND, l);
        }
        Collections.addAll(l, ands);
        return this;
    }

    public DBObject get() {
        for (String key : this._query.keySet()) {
            if (this._query.get(key) instanceof NullObject) {
                throw new QueryBuilderException("No operand for key:" + key);
            }
        }
        return this._query;
    }

    private void addOperand(@Nullable String op, Object value) {
        BasicDBObject operand;
        Object valueToPut = value;
        if (op == null) {
            if (this._hasNot) {
                valueToPut = new BasicDBObject(QueryOperators.NOT, valueToPut);
                this._hasNot = false;
            }
            this._query.put(this._currentKey, valueToPut);
            return;
        }
        if (!(this._query.get(this._currentKey) instanceof DBObject)) {
            operand = new BasicDBObject();
            if (this._hasNot) {
                this._query.put(this._currentKey, new BasicDBObject(QueryOperators.NOT, operand));
                this._hasNot = false;
            } else {
                this._query.put(this._currentKey, operand);
            }
        } else {
            operand = (BasicDBObject) this._query.get(this._currentKey);
            if (operand.get(QueryOperators.NOT) != null) {
                operand = (BasicDBObject) operand.get(QueryOperators.NOT);
            }
        }
        operand.put((Object) op, valueToPut);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/QueryBuilder$QueryBuilderException.class */
    public static class QueryBuilderException extends RuntimeException {
        QueryBuilderException(String message) {
            super(message);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/QueryBuilder$NullObject.class */
    public static class NullObject {
        private NullObject() {
        }
    }
}
