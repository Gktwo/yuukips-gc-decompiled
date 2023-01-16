package com.mongodb.client.model.geojson.codecs;

import com.mongodb.client.model.geojson.CoordinateReferenceSystem;
import com.mongodb.client.model.geojson.Geometry;
import com.mongodb.client.model.geojson.GeometryCollection;
import com.mongodb.client.model.geojson.LineString;
import com.mongodb.client.model.geojson.MultiLineString;
import com.mongodb.client.model.geojson.MultiPoint;
import com.mongodb.client.model.geojson.MultiPolygon;
import com.mongodb.client.model.geojson.NamedCoordinateReferenceSystem;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Polygon;
import com.mongodb.client.model.geojson.PolygonCoordinates;
import com.mongodb.client.model.geojson.Position;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.bson.BsonReader;
import org.bson.BsonReaderMark;
import org.bson.BsonType;
import org.bson.codecs.configuration.CodecConfigurationException;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/codecs/GeometryDecoderHelper.class */
public final class GeometryDecoderHelper {
    /* access modifiers changed from: package-private */
    public static <T extends Geometry> T decodeGeometry(BsonReader reader, Class<T> clazz) {
        if (clazz.equals(Point.class)) {
            return decodePoint(reader);
        }
        if (clazz.equals(MultiPoint.class)) {
            return decodeMultiPoint(reader);
        }
        if (clazz.equals(Polygon.class)) {
            return decodePolygon(reader);
        }
        if (clazz.equals(MultiPolygon.class)) {
            return decodeMultiPolygon(reader);
        }
        if (clazz.equals(LineString.class)) {
            return decodeLineString(reader);
        }
        if (clazz.equals(MultiLineString.class)) {
            return decodeMultiLineString(reader);
        }
        if (clazz.equals(GeometryCollection.class)) {
            return decodeGeometryCollection(reader);
        }
        if (clazz.equals(Geometry.class)) {
            return (T) decodeGeometry(reader);
        }
        throw new CodecConfigurationException(String.format("Unsupported Geometry: %s", clazz));
    }

    private static Point decodePoint(BsonReader reader) {
        String type = null;
        Position position = null;
        CoordinateReferenceSystem crs = null;
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            String key = reader.readName();
            if (key.equals("type")) {
                type = reader.readString();
            } else if (key.equals("coordinates")) {
                position = decodePosition(reader);
            } else if (key.equals("crs")) {
                crs = decodeCoordinateReferenceSystem(reader);
            } else {
                throw new CodecConfigurationException(String.format("Unexpected key '%s' found when decoding a GeoJSON point", key));
            }
        }
        reader.readEndDocument();
        if (type == null) {
            throw new CodecConfigurationException("Invalid Point, document contained no type information.");
        } else if (!type.equals("Point")) {
            throw new CodecConfigurationException(String.format("Invalid Point, found type '%s'.", type));
        } else if (position != null) {
            return crs != null ? new Point(crs, position) : new Point(position);
        } else {
            throw new CodecConfigurationException("Invalid Point, missing position coordinates.");
        }
    }

    private static MultiPoint decodeMultiPoint(BsonReader reader) {
        String type = null;
        List<Position> coordinates = null;
        CoordinateReferenceSystem crs = null;
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            String key = reader.readName();
            if (key.equals("type")) {
                type = reader.readString();
            } else if (key.equals("coordinates")) {
                coordinates = decodeCoordinates(reader);
            } else if (key.equals("crs")) {
                crs = decodeCoordinateReferenceSystem(reader);
            } else {
                throw new CodecConfigurationException(String.format("Unexpected key '%s' found when decoding a GeoJSON point", key));
            }
        }
        reader.readEndDocument();
        if (type == null) {
            throw new CodecConfigurationException("Invalid MultiPoint, document contained no type information.");
        } else if (!type.equals("MultiPoint")) {
            throw new CodecConfigurationException(String.format("Invalid MultiPoint, found type '%s'.", type));
        } else if (coordinates != null) {
            return crs != null ? new MultiPoint(crs, coordinates) : new MultiPoint(coordinates);
        } else {
            throw new CodecConfigurationException("Invalid MultiPoint, missing position coordinates.");
        }
    }

    private static Polygon decodePolygon(BsonReader reader) {
        String type = null;
        PolygonCoordinates coordinates = null;
        CoordinateReferenceSystem crs = null;
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            String key = reader.readName();
            if (key.equals("type")) {
                type = reader.readString();
            } else if (key.equals("coordinates")) {
                coordinates = decodePolygonCoordinates(reader);
            } else if (key.equals("crs")) {
                crs = decodeCoordinateReferenceSystem(reader);
            } else {
                throw new CodecConfigurationException(String.format("Unexpected key '%s' found when decoding a GeoJSON Polygon", key));
            }
        }
        reader.readEndDocument();
        if (type == null) {
            throw new CodecConfigurationException("Invalid Polygon, document contained no type information.");
        } else if (!type.equals("Polygon")) {
            throw new CodecConfigurationException(String.format("Invalid Polygon, found type '%s'.", type));
        } else if (coordinates != null) {
            return crs != null ? new Polygon(crs, coordinates) : new Polygon(coordinates);
        } else {
            throw new CodecConfigurationException("Invalid Polygon, missing coordinates.");
        }
    }

    private static MultiPolygon decodeMultiPolygon(BsonReader reader) {
        String type = null;
        List<PolygonCoordinates> coordinates = null;
        CoordinateReferenceSystem crs = null;
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            String key = reader.readName();
            if (key.equals("type")) {
                type = reader.readString();
            } else if (key.equals("coordinates")) {
                coordinates = decodeMultiPolygonCoordinates(reader);
            } else if (key.equals("crs")) {
                crs = decodeCoordinateReferenceSystem(reader);
            } else {
                throw new CodecConfigurationException(String.format("Unexpected key '%s' found when decoding a GeoJSON Polygon", key));
            }
        }
        reader.readEndDocument();
        if (type == null) {
            throw new CodecConfigurationException("Invalid MultiPolygon, document contained no type information.");
        } else if (!type.equals("MultiPolygon")) {
            throw new CodecConfigurationException(String.format("Invalid MultiPolygon, found type '%s'.", type));
        } else if (coordinates != null) {
            return crs != null ? new MultiPolygon(crs, coordinates) : new MultiPolygon(coordinates);
        } else {
            throw new CodecConfigurationException("Invalid MultiPolygon, missing coordinates.");
        }
    }

    private static LineString decodeLineString(BsonReader reader) {
        String type = null;
        List<Position> coordinates = null;
        CoordinateReferenceSystem crs = null;
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            String key = reader.readName();
            if (key.equals("type")) {
                type = reader.readString();
            } else if (key.equals("coordinates")) {
                coordinates = decodeCoordinates(reader);
            } else if (key.equals("crs")) {
                crs = decodeCoordinateReferenceSystem(reader);
            } else {
                throw new CodecConfigurationException(String.format("Unexpected key '%s' found when decoding a GeoJSON Polygon", key));
            }
        }
        reader.readEndDocument();
        if (type == null) {
            throw new CodecConfigurationException("Invalid LineString, document contained no type information.");
        } else if (!type.equals("LineString")) {
            throw new CodecConfigurationException(String.format("Invalid LineString, found type '%s'.", type));
        } else if (coordinates != null) {
            return crs != null ? new LineString(crs, coordinates) : new LineString(coordinates);
        } else {
            throw new CodecConfigurationException("Invalid LineString, missing coordinates.");
        }
    }

    private static MultiLineString decodeMultiLineString(BsonReader reader) {
        String type = null;
        List<List<Position>> coordinates = null;
        CoordinateReferenceSystem crs = null;
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            String key = reader.readName();
            if (key.equals("type")) {
                type = reader.readString();
            } else if (key.equals("coordinates")) {
                coordinates = decodeMultiCoordinates(reader);
            } else if (key.equals("crs")) {
                crs = decodeCoordinateReferenceSystem(reader);
            } else {
                throw new CodecConfigurationException(String.format("Unexpected key '%s' found when decoding a GeoJSON Polygon", key));
            }
        }
        reader.readEndDocument();
        if (type == null) {
            throw new CodecConfigurationException("Invalid MultiLineString, document contained no type information.");
        } else if (!type.equals("MultiLineString")) {
            throw new CodecConfigurationException(String.format("Invalid MultiLineString, found type '%s'.", type));
        } else if (coordinates != null) {
            return crs != null ? new MultiLineString(crs, coordinates) : new MultiLineString(coordinates);
        } else {
            throw new CodecConfigurationException("Invalid MultiLineString, missing coordinates.");
        }
    }

    private static GeometryCollection decodeGeometryCollection(BsonReader reader) {
        String type = null;
        List<? extends Geometry> geometries = null;
        CoordinateReferenceSystem crs = null;
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            String key = reader.readName();
            if (key.equals("type")) {
                type = reader.readString();
            } else if (key.equals("geometries")) {
                geometries = decodeGeometries(reader);
            } else if (key.equals("crs")) {
                crs = decodeCoordinateReferenceSystem(reader);
            } else {
                throw new CodecConfigurationException(String.format("Unexpected key '%s' found when decoding a GeoJSON Polygon", key));
            }
        }
        reader.readEndDocument();
        if (type == null) {
            throw new CodecConfigurationException("Invalid GeometryCollection, document contained no type information.");
        } else if (!type.equals("GeometryCollection")) {
            throw new CodecConfigurationException(String.format("Invalid GeometryCollection, found type '%s'.", type));
        } else if (geometries != null) {
            return crs != null ? new GeometryCollection(crs, geometries) : new GeometryCollection(geometries);
        } else {
            throw new CodecConfigurationException("Invalid GeometryCollection, missing geometries.");
        }
    }

    private static List<? extends Geometry> decodeGeometries(BsonReader reader) {
        validateIsArray(reader);
        reader.readStartArray();
        List<Geometry> values = new ArrayList<>();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            values.add(decodeGeometry(reader));
        }
        reader.readEndArray();
        return values;
    }

    private static Geometry decodeGeometry(BsonReader reader) {
        Geometry geometry;
        String type = null;
        BsonReaderMark mark = reader.getMark();
        validateIsDocument(reader);
        reader.readStartDocument();
        while (true) {
            if (reader.readBsonType() == BsonType.END_OF_DOCUMENT) {
                break;
            } else if (reader.readName().equals("type")) {
                type = reader.readString();
                break;
            } else {
                reader.skipValue();
            }
        }
        mark.reset();
        if (type == null) {
            throw new CodecConfigurationException("Invalid Geometry item, document contained no type information.");
        }
        if (type.equals("Point")) {
            geometry = decodePoint(reader);
        } else if (type.equals("MultiPoint")) {
            geometry = decodeMultiPoint(reader);
        } else if (type.equals("Polygon")) {
            geometry = decodePolygon(reader);
        } else if (type.equals("MultiPolygon")) {
            geometry = decodeMultiPolygon(reader);
        } else if (type.equals("LineString")) {
            geometry = decodeLineString(reader);
        } else if (type.equals("MultiLineString")) {
            geometry = decodeMultiLineString(reader);
        } else if (type.equals("GeometryCollection")) {
            geometry = decodeGeometryCollection(reader);
        } else {
            throw new CodecConfigurationException(String.format("Invalid Geometry item, found type '%s'.", type));
        }
        return geometry;
    }

    private static PolygonCoordinates decodePolygonCoordinates(BsonReader reader) {
        validateIsArray(reader);
        reader.readStartArray();
        List<List<Position>> values = new ArrayList<>();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            values.add(decodeCoordinates(reader));
        }
        reader.readEndArray();
        if (values.isEmpty()) {
            throw new CodecConfigurationException("Invalid Polygon no coordinates.");
        }
        try {
            return new PolygonCoordinates(values.remove(0), (ArrayList[]) values.toArray(new ArrayList[values.size()]));
        } catch (IllegalArgumentException e) {
            throw new CodecConfigurationException(String.format("Invalid Polygon: %s", e.getMessage()));
        }
    }

    private static List<PolygonCoordinates> decodeMultiPolygonCoordinates(BsonReader reader) {
        validateIsArray(reader);
        reader.readStartArray();
        List<PolygonCoordinates> values = new ArrayList<>();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            values.add(decodePolygonCoordinates(reader));
        }
        reader.readEndArray();
        if (!values.isEmpty()) {
            return values;
        }
        throw new CodecConfigurationException("Invalid MultiPolygon no coordinates.");
    }

    private static List<Position> decodeCoordinates(BsonReader reader) {
        validateIsArray(reader);
        reader.readStartArray();
        List<Position> values = new ArrayList<>();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            values.add(decodePosition(reader));
        }
        reader.readEndArray();
        return values;
    }

    private static List<List<Position>> decodeMultiCoordinates(BsonReader reader) {
        validateIsArray(reader);
        reader.readStartArray();
        List<List<Position>> values = new ArrayList<>();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            values.add(decodeCoordinates(reader));
        }
        reader.readEndArray();
        return values;
    }

    private static Position decodePosition(BsonReader reader) {
        validateIsArray(reader);
        reader.readStartArray();
        List<Double> values = new ArrayList<>();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            values.add(Double.valueOf(readAsDouble(reader)));
        }
        reader.readEndArray();
        try {
            return new Position(values);
        } catch (IllegalArgumentException e) {
            throw new CodecConfigurationException(String.format("Invalid Position: %s", e.getMessage()));
        }
    }

    private static double readAsDouble(BsonReader reader) {
        if (reader.getCurrentBsonType() == BsonType.DOUBLE) {
            return reader.readDouble();
        }
        if (reader.getCurrentBsonType() == BsonType.INT32) {
            return (double) reader.readInt32();
        }
        if (reader.getCurrentBsonType() == BsonType.INT64) {
            return (double) reader.readInt64();
        }
        throw new CodecConfigurationException("A GeoJSON position value must be a numerical type, but the value is of type " + reader.getCurrentBsonType());
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public static CoordinateReferenceSystem decodeCoordinateReferenceSystem(BsonReader reader) {
        String crsName = null;
        validateIsDocument(reader);
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            String name = reader.readName();
            if (name.equals("type")) {
                String type = reader.readString();
                if (!type.equals("name")) {
                    throw new CodecConfigurationException(String.format("Unsupported CoordinateReferenceSystem '%s'.", type));
                }
            } else if (name.equals("properties")) {
                crsName = decodeCoordinateReferenceSystemProperties(reader);
            } else {
                throw new CodecConfigurationException(String.format("Found invalid key '%s' in the CoordinateReferenceSystem.", name));
            }
        }
        reader.readEndDocument();
        if (crsName != null) {
            return new NamedCoordinateReferenceSystem(crsName);
        }
        return null;
    }

    private static String decodeCoordinateReferenceSystemProperties(BsonReader reader) {
        String crsName = null;
        validateIsDocument(reader);
        reader.readStartDocument();
        while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
            String name = reader.readName();
            if (name.equals("name")) {
                crsName = reader.readString();
            } else {
                throw new CodecConfigurationException(String.format("Found invalid key '%s' in the CoordinateReferenceSystem.", name));
            }
        }
        reader.readEndDocument();
        if (crsName != null) {
            return crsName;
        }
        throw new CodecConfigurationException("Found invalid properties in the CoordinateReferenceSystem.");
    }

    private static void validateIsDocument(BsonReader reader) {
        BsonType currentType = reader.getCurrentBsonType();
        if (currentType == null) {
            currentType = reader.readBsonType();
        }
        if (!currentType.equals(BsonType.DOCUMENT)) {
            throw new CodecConfigurationException("Invalid BsonType expecting a Document");
        }
    }

    private static void validateIsArray(BsonReader reader) {
        if (reader.getCurrentBsonType() != BsonType.ARRAY) {
            throw new CodecConfigurationException("Invalid BsonType expecting an Array");
        }
    }

    private GeometryDecoderHelper() {
    }
}
