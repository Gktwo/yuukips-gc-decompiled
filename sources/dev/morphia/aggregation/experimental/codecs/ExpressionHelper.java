package dev.morphia.aggregation.experimental.codecs;

import com.mongodb.lang.Nullable;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.writer.DocumentWriter;
import java.util.function.Consumer;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/ExpressionHelper.class */
public final class ExpressionHelper {
    private ExpressionHelper() {
    }

    public static void array(BsonWriter writer, Runnable body) {
        writer.writeStartArray();
        body.run();
        writer.writeEndArray();
    }

    public static void array(BsonWriter writer, String name, Runnable body) {
        writer.writeStartArray(name);
        body.run();
        writer.writeEndArray();
    }

    public static void document(BsonWriter writer, Runnable body) {
        writer.writeStartDocument();
        body.run();
        writer.writeEndDocument();
    }

    public static void document(BsonWriter writer, String name, Runnable body) {
        writer.writeStartDocument(name);
        body.run();
        writer.writeEndDocument();
    }

    public static Document document(Mapper mapper, Document seed, Consumer<BsonWriter> body) {
        DocumentWriter writer = new DocumentWriter(mapper, seed);
        writer.writeStartDocument();
        body.accept(writer);
        writer.writeEndDocument();
        return writer.getDocument();
    }

    public static void expression(Mapper mapper, BsonWriter writer, String name, @Nullable Expression expression, EncoderContext encoderContext) {
        if (expression != null) {
            writer.writeName(name);
            expression.encode(mapper, writer, encoderContext);
        }
    }

    public static void expression(Mapper mapper, BsonWriter writer, @Nullable Expression expression, EncoderContext encoderContext) {
        if (expression != null) {
            expression.encode(mapper, writer, encoderContext);
        }
    }

    public static void value(Mapper mapper, BsonWriter writer, String name, @Nullable Object value, EncoderContext encoderContext) {
        if (value != null) {
            writer.writeName(name);
            encoderContext.encodeWithChildContext(mapper.getCodecRegistry().get(value.getClass()), writer, value);
        }
    }

    public static void value(Mapper mapper, BsonWriter writer, @Nullable Object value, EncoderContext encoderContext) {
        if (value != null) {
            encoderContext.encodeWithChildContext(mapper.getCodecRegistry().get(value.getClass()), writer, value);
        }
    }
}
