package org.bson.codecs.pojo;

import org.bson.codecs.configuration.CodecConfigurationException;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/IdPropertyModelHolder.class */
public final class IdPropertyModelHolder<I> {
    private final PropertyModel<I> propertyModel;
    private final IdGenerator<I> idGenerator;

    /* access modifiers changed from: package-private */
    public static <T, I> IdPropertyModelHolder<I> create(ClassModel<T> classModel, PropertyModel<I> idPropertyModel) {
        return create(classModel.getType(), idPropertyModel, classModel.getIdPropertyModelHolder().getIdGenerator());
    }

    /* access modifiers changed from: package-private */
    public static <T, I, V> IdPropertyModelHolder<I> create(Class<T> type, PropertyModel<I> idProperty, IdGenerator<V> idGenerator) {
        if (idProperty == null && idGenerator != null) {
            throw new CodecConfigurationException(String.format("Invalid IdGenerator. There is no IdProperty set for: %s", type));
        } else if (idGenerator == null || idProperty.getTypeData().getType().isAssignableFrom(idGenerator.getType())) {
            return new IdPropertyModelHolder<>(idProperty, idGenerator);
        } else {
            throw new CodecConfigurationException(String.format("Invalid IdGenerator. Mismatching types, the IdProperty type is: %s but the IdGenerator type is: %s", idProperty.getTypeData().getType(), idGenerator.getType()));
        }
    }

    private IdPropertyModelHolder(PropertyModel<I> propertyModel, IdGenerator<I> idGenerator) {
        this.propertyModel = propertyModel;
        this.idGenerator = idGenerator;
    }

    /* access modifiers changed from: package-private */
    public PropertyModel<I> getPropertyModel() {
        return this.propertyModel;
    }

    /* access modifiers changed from: package-private */
    public IdGenerator<I> getIdGenerator() {
        return this.idGenerator;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdPropertyModelHolder<?> that = (IdPropertyModelHolder) o;
        if (this.propertyModel != null) {
            if (!this.propertyModel.equals(that.propertyModel)) {
                return false;
            }
        } else if (that.propertyModel != null) {
            return false;
        }
        return this.idGenerator != null ? this.idGenerator.equals(that.idGenerator) : that.idGenerator == null;
    }

    public int hashCode() {
        return (31 * (this.propertyModel != null ? this.propertyModel.hashCode() : 0)) + (this.idGenerator != null ? this.idGenerator.hashCode() : 0);
    }
}
