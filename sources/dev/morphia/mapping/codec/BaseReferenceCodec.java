package dev.morphia.mapping.codec;

import dev.morphia.Datastore;
import dev.morphia.annotations.Reference;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.codec.pojo.TypeData;
import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Objects;
import org.bson.codecs.Codec;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/BaseReferenceCodec.class */
public abstract class BaseReferenceCodec<T> implements Codec<T> {
    private final PropertyModel property;
    private EntityModel entityModel;
    private final Datastore datastore;

    public BaseReferenceCodec(Datastore datastore, PropertyModel property) {
        this.datastore = datastore;
        this.property = property;
    }

    public Datastore getDatastore() {
        return this.datastore;
    }

    public PropertyModel getPropertyModel() {
        return this.property;
    }

    public TypeData<?> getTypeData() {
        return this.property.getTypeData();
    }

    protected EntityModel getEntityModelForField() {
        if (this.entityModel == null) {
            this.entityModel = this.datastore.getMapper().getEntityModel(PropertyModel.normalize(getTypeData()));
        }
        return this.entityModel;
    }

    @SuppressFBWarnings({"NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE"})
    protected static Reference getReferenceAnnotation(PropertyModel model) {
        return (Reference) Objects.requireNonNull((Reference) model.getAnnotation(Reference.class));
    }
}
