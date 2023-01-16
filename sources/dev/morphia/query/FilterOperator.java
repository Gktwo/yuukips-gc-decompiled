package dev.morphia.query;

import com.mongodb.QueryOperators;
import com.mongodb.client.model.geojson.Geometry;
import com.mongodb.client.model.geojson.MultiPolygon;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Polygon;
import com.mongodb.client.model.geojson.Position;
import dev.morphia.query.Shape;
import dev.morphia.query.experimental.filters.Filter;
import dev.morphia.query.experimental.filters.Filters;
import dev.morphia.sofia.Sofia;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.jline.console.Printer;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/FilterOperator.class */
public enum FilterOperator {
    WITHIN_CIRCLE(QueryOperators.CENTER, new String[0]) {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            throw new UnsupportedOperationException(Sofia.filterMappingNotSupported(WITHIN_CIRCLE, new Locale[0]));
        }
    },
    WITHIN_CIRCLE_SPHERE(QueryOperators.CENTER_SPHERE, new String[0]) {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            throw new UnsupportedOperationException(Sofia.filterMappingNotSupported(WITHIN_CIRCLE_SPHERE, new Locale[0]));
        }
    },
    WITHIN_BOX(QueryOperators.BOX, new String[0]) {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            if (!(value instanceof Point[])) {
                throw new IllegalArgumentException(Sofia.illegalArgument(value.getClass().getCanonicalName(), Point[].class.getCanonicalName(), new Locale[0]));
            }
            Point[] points = (Point[]) value;
            return Filters.box(prop, points[0], points[1]);
        }
    },
    EQUAL("$eq", "=", "==") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.m1223eq(prop, value);
        }
    },
    NOT_EQUAL(QueryOperators.f431NE, "!=", "<>") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.m1219ne(prop, value);
        }
    },
    GREATER_THAN(QueryOperators.f429GT, ">") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.m1222gt(prop, value);
        }
    },
    GREATER_THAN_OR_EQUAL(QueryOperators.GTE, ">=") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.gte(prop, value);
        }
    },
    LESS_THAN(QueryOperators.f430LT, "<") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.m1220lt(prop, value);
        }
    },
    LESS_THAN_OR_EQUAL(QueryOperators.LTE, "<=") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.lte(prop, value);
        }
    },
    EXISTS(QueryOperators.EXISTS, "exists") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            Filter exists = Filters.exists(prop);
            if (Boolean.FALSE.equals(value)) {
                exists.not();
            }
            return exists;
        }
    },
    TYPE("$type", "type") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.type(prop, (Type) value);
        }
    },
    NOT(QueryOperators.NOT, new String[0]) {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            throw new UnsupportedOperationException(Sofia.translationNotCurrentlySupported(new Locale[0]));
        }
    },
    MOD(QueryOperators.MOD, "mod") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            long[] values = (long[]) value;
            return Filters.mod(prop, values[0], values[1]);
        }
    },
    SIZE(QueryOperators.SIZE, "size") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.size(prop, ((Integer) value).intValue());
        }
    },
    IN(QueryOperators.f432IN, "in") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.m1221in(prop, (Iterable) value);
        }
    },
    NOT_IN(QueryOperators.NIN, "nin") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.nin(prop, value);
        }
    },
    ALL(QueryOperators.ALL, Printer.ALL) {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.all(prop, value);
        }
    },
    ELEMENT_MATCH(QueryOperators.ELEM_MATCH, "elem", "elemMatch") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            throw new UnsupportedOperationException(Sofia.filterMappingNotSupported(ELEMENT_MATCH, new Locale[0]));
        }
    },
    WHERE(QueryOperators.WHERE, new String[0]) {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.where(value.toString());
        }
    },
    NEAR(QueryOperators.NEAR, "near") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.near(prop, (Point) FilterOperator.convertToGeometry(value));
        }
    },
    NEAR_SPHERE(QueryOperators.NEAR_SPHERE, new String[0]) {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.nearSphere(prop, (Point) FilterOperator.convertToGeometry(value));
        }
    },
    GEO_NEAR("$geoNear", "geoNear") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            throw new UnsupportedOperationException("An aggregation operator called in a query context?");
        }
    },
    GEO_WITHIN("$geoWithin", "geoWithin") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            if (value instanceof Shape) {
                Shape shape = (Shape) value;
                if (shape instanceof Shape.Center) {
                    Shape.Center center = (Shape.Center) shape;
                    if (QueryOperators.CENTER.equals(center.getGeometry())) {
                        return Filters.center(prop, shape.getPoints()[0], center.getRadius());
                    }
                    if (QueryOperators.CENTER_SPHERE.equals(center.getGeometry())) {
                        return Filters.centerSphere(prop, shape.getPoints()[0], center.getRadius());
                    }
                } else if (QueryOperators.BOX.equals(shape.getGeometry())) {
                    return Filters.box(prop, shape.getPoints()[0], shape.getPoints()[1]);
                } else {
                    if (QueryOperators.POLYGON.equals(shape.getGeometry())) {
                        return Filters.polygon(prop, shape.getPoints());
                    }
                }
                throw new UnsupportedOperationException(Sofia.conversionNotSupported(value.getClass().getCanonicalName(), new Locale[0]));
            } else if (value instanceof Polygon) {
                return Filters.geoWithin(prop, (Polygon) value);
            } else {
                if (value instanceof MultiPolygon) {
                    return Filters.geoWithin(prop, (MultiPolygon) value);
                }
                throw new UnsupportedOperationException(Sofia.conversionNotSupported(value.getClass().getCanonicalName(), new Locale[0]));
            }
        }
    },
    INTERSECTS("$geoIntersects", "geoIntersects") {
        @Override // dev.morphia.query.FilterOperator
        public Filter apply(String prop, Object value) {
            return Filters.geoIntersects(prop, FilterOperator.convertToGeometry(value));
        }
    };
    
    private final String value;
    private final List<String> filters;

    public abstract Filter apply(String str, Object obj);

    FilterOperator(String val, String... filterValues) {
        this.value = val;
        this.filters = Arrays.asList(filterValues);
    }

    private static Geometry convertToGeometry(Object value) {
        Geometry converted;
        if (value instanceof double[]) {
            double[] coordinates = (double[]) value;
            converted = new Point(new Position(coordinates[0], coordinates[1], new double[0]));
        } else if (value instanceof Geometry) {
            converted = (Geometry) value;
        } else {
            throw new UnsupportedOperationException(Sofia.conversionNotSupported(value.getClass().getCanonicalName(), new Locale[0]));
        }
        return converted;
    }

    public static FilterOperator fromString(String operator) {
        String filter = operator.trim().toLowerCase();
        FilterOperator[] values = values();
        for (FilterOperator filterOperator : values) {
            if (filterOperator.matches(filter)) {
                return filterOperator;
            }
        }
        throw new IllegalArgumentException(String.format("Unknown operator '%s'", operator));
    }

    public boolean matches(String filter) {
        return filter != null && this.filters.contains(filter.trim().toLowerCase());
    }

    public String val() {
        return this.value;
    }
}
