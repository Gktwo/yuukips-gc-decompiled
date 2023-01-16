package dev.morphia.query.experimental.updates;

import dev.morphia.internal.PathTarget;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.codec.writer.DocumentWriter;
import dev.morphia.query.OperationTarget;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/updates/SetEntityOperator.class */
public class SetEntityOperator extends UpdateOperator {
    public SetEntityOperator(Object value) {
        super("$set", "", value);
    }

    @Override // dev.morphia.query.experimental.updates.UpdateOperator
    public OperationTarget toTarget(PathTarget pathTarget) {
        return new OperationTarget(null, value()) { // from class: dev.morphia.query.experimental.updates.SetEntityOperator.1
            @Override // dev.morphia.query.OperationTarget
            public Object encode(Mapper mapper) {
                Object value = SetEntityOperator.this.value();
                PropertyModel versionProperty = mapper.getEntityModel(value.getClass()).getVersionProperty();
                if (versionProperty == null) {
                    return encode(mapper);
                }
                Codec<Object> codec = mapper.getCodecRegistry().get(value.getClass());
                DocumentWriter writer = new DocumentWriter(mapper);
                codec.encode(writer, value, EncoderContext.builder().build());
                Document document = writer.getDocument();
                document.remove(versionProperty.getMappedName());
                return document;
            }
        };
    }
}
