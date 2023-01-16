package com.mongodb.client.model.geojson;

import com.mongodb.client.model.geojson.codecs.GeoJsonCodecProvider;
import com.mongodb.lang.Nullable;
import java.io.StringWriter;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;

/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/Geometry.class */
public abstract class Geometry {
    private static final CodecRegistry REGISTRY = CodecRegistries.fromProviders(new GeoJsonCodecProvider());
    private final CoordinateReferenceSystem coordinateReferenceSystem;

    public abstract GeoJsonObjectType getType();

    protected Geometry() {
        this(null);
    }

    /* access modifiers changed from: protected */
    public Geometry(@Nullable CoordinateReferenceSystem coordinateReferenceSystem) {
        this.coordinateReferenceSystem = coordinateReferenceSystem;
    }

    public String toJson() {
        StringWriter stringWriter = new StringWriter();
        getRegistry().get(getClass()).encode(new JsonWriter(stringWriter, JsonWriterSettings.builder().build()), this, EncoderContext.builder().build());
        return stringWriter.toString();
    }

    static CodecRegistry getRegistry() {
        return REGISTRY;
    }

    @Nullable
    public CoordinateReferenceSystem getCoordinateReferenceSystem() {
        return this.coordinateReferenceSystem;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Geometry geometry = (Geometry) o;
        if (this.coordinateReferenceSystem != null) {
            if (!this.coordinateReferenceSystem.equals(geometry.coordinateReferenceSystem)) {
                return false;
            }
            return true;
        } else if (geometry.coordinateReferenceSystem != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        if (this.coordinateReferenceSystem != null) {
            return this.coordinateReferenceSystem.hashCode();
        }
        return 0;
    }
}
