package dev.morphia.mapping.codec.pojo;

import com.mongodb.lang.Nullable;
import dev.morphia.mapping.codec.writer.DocumentWriter;
import dev.morphia.query.Query;
import dev.morphia.query.Update;
import dev.morphia.query.UpdateException;
import dev.morphia.query.experimental.updates.UpdateOperator;
import dev.morphia.query.experimental.updates.UpdateOperators;
import java.util.Map;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/pojo/MergingEncoder.class */
public class MergingEncoder<T> extends EntityEncoder {
    private final Query<T> query;
    private final DocumentWriter setOperations;
    private Update<T> update;

    /* Return type fixed from 'java.lang.Class' to match base method */
    @Override // dev.morphia.mapping.codec.pojo.EntityEncoder, org.bson.codecs.Encoder
    public /* bridge */ /* synthetic */ Class<Object> getEncoderClass() {
        return getEncoderClass();
    }

    @Override // dev.morphia.mapping.codec.pojo.EntityEncoder, org.bson.codecs.Encoder
    public /* bridge */ /* synthetic */ void encode(BsonWriter bsonWriter, Object obj, EncoderContext encoderContext) {
        encode(bsonWriter, obj, encoderContext);
    }

    public MergingEncoder(Query<T> query, MorphiaCodec<T> morphiaCodec) {
        super(morphiaCodec);
        this.query = query;
        this.setOperations = new DocumentWriter(morphiaCodec.getMapper());
    }

    public Update<T> encode(Object entity) {
        encode(this.setOperations, entity, EncoderContext.builder().build());
        for (Map.Entry<String, Object> entry : this.setOperations.getDocument().entrySet()) {
            add(UpdateOperators.set(entry.getKey(), entry.getValue()));
        }
        if (this.update != null) {
            return this.update;
        }
        throw new UpdateException("Nothing to update");
    }

    @Override // dev.morphia.mapping.codec.pojo.EntityEncoder
    protected void encodeDiscriminator(BsonWriter writer, EntityModel model) {
    }

    @Override // dev.morphia.mapping.codec.pojo.EntityEncoder
    protected void encodeIdProperty(BsonWriter writer, Object instance, EncoderContext encoderContext, @Nullable PropertyModel idModel) {
    }

    @Override // dev.morphia.mapping.codec.pojo.EntityEncoder
    protected void encodeValue(BsonWriter writer, EncoderContext encoderContext, PropertyModel model, @Nullable Object value) {
        encodeValue(writer, encoderContext, model, value);
        if (!model.shouldSerialize(value)) {
            add(UpdateOperators.unset(model.getMappedName()));
        }
    }

    private void add(UpdateOperator operator) {
        if (this.update == null) {
            this.update = this.query.update(operator, new UpdateOperator[0]);
        } else {
            this.update.add(operator);
        }
    }
}
