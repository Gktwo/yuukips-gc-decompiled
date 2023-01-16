package org.bson.codecs.pojo;

import org.bson.BsonType;
import org.bson.codecs.Codec;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PropertyModel.class */
public final class PropertyModel<T> {
    private final String name;
    private final String readName;
    private final String writeName;
    private final TypeData<T> typeData;
    private final Codec<T> codec;
    private final PropertySerialization<T> propertySerialization;
    private final Boolean useDiscriminator;
    private final PropertyAccessor<T> propertyAccessor;
    private final String error;
    private volatile Codec<T> cachedCodec;
    private final BsonType bsonRepresentation;

    /* access modifiers changed from: package-private */
    public PropertyModel(String name, String readName, String writeName, TypeData<T> typeData, Codec<T> codec, PropertySerialization<T> propertySerialization, Boolean useDiscriminator, PropertyAccessor<T> propertyAccessor, String error, BsonType bsonRepresentation) {
        this.name = name;
        this.readName = readName;
        this.writeName = writeName;
        this.typeData = typeData;
        this.codec = codec;
        this.cachedCodec = codec;
        this.propertySerialization = propertySerialization;
        this.useDiscriminator = useDiscriminator;
        this.propertyAccessor = propertyAccessor;
        this.error = error;
        this.bsonRepresentation = bsonRepresentation;
    }

    public static <T> PropertyModelBuilder<T> builder() {
        return new PropertyModelBuilder<>();
    }

    public String getName() {
        return this.name;
    }

    public String getWriteName() {
        return this.writeName;
    }

    public String getReadName() {
        return this.readName;
    }

    public boolean isWritable() {
        return this.writeName != null;
    }

    public boolean isReadable() {
        return this.readName != null;
    }

    public TypeData<T> getTypeData() {
        return this.typeData;
    }

    public Codec<T> getCodec() {
        return this.codec;
    }

    public BsonType getBsonRepresentation() {
        return this.bsonRepresentation;
    }

    public boolean shouldSerialize(T value) {
        return this.propertySerialization.shouldSerialize(value);
    }

    public PropertyAccessor<T> getPropertyAccessor() {
        return this.propertyAccessor;
    }

    public Boolean useDiscriminator() {
        return this.useDiscriminator;
    }

    public String toString() {
        return "PropertyModel{propertyName='" + this.name + "', readName='" + this.readName + "', writeName='" + this.writeName + "', typeData=" + this.typeData + "}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PropertyModel<?> that = (PropertyModel) o;
        if (getName() != null) {
            if (!getName().equals(that.getName())) {
                return false;
            }
        } else if (that.getName() != null) {
            return false;
        }
        if (getReadName() != null) {
            if (!getReadName().equals(that.getReadName())) {
                return false;
            }
        } else if (that.getReadName() != null) {
            return false;
        }
        if (getWriteName() != null) {
            if (!getWriteName().equals(that.getWriteName())) {
                return false;
            }
        } else if (that.getWriteName() != null) {
            return false;
        }
        if (getTypeData() != null) {
            if (!getTypeData().equals(that.getTypeData())) {
                return false;
            }
        } else if (that.getTypeData() != null) {
            return false;
        }
        if (getCodec() != null) {
            if (!getCodec().equals(that.getCodec())) {
                return false;
            }
        } else if (that.getCodec() != null) {
            return false;
        }
        if (getPropertySerialization() != null) {
            if (!getPropertySerialization().equals(that.getPropertySerialization())) {
                return false;
            }
        } else if (that.getPropertySerialization() != null) {
            return false;
        }
        if (this.useDiscriminator != null) {
            if (!this.useDiscriminator.equals(that.useDiscriminator)) {
                return false;
            }
        } else if (that.useDiscriminator != null) {
            return false;
        }
        if (getPropertyAccessor() != null) {
            if (!getPropertyAccessor().equals(that.getPropertyAccessor())) {
                return false;
            }
        } else if (that.getPropertyAccessor() != null) {
            return false;
        }
        if (getError() != null) {
            if (!getError().equals(that.getError())) {
                return false;
            }
        } else if (that.getError() != null) {
            return false;
        }
        if (getCachedCodec() != null) {
            if (!getCachedCodec().equals(that.getCachedCodec())) {
                return false;
            }
            return true;
        } else if (that.getCachedCodec() != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * (getName() != null ? getName().hashCode() : 0)) + (getReadName() != null ? getReadName().hashCode() : 0))) + (getWriteName() != null ? getWriteName().hashCode() : 0))) + (getTypeData() != null ? getTypeData().hashCode() : 0))) + (getCodec() != null ? getCodec().hashCode() : 0))) + (getPropertySerialization() != null ? getPropertySerialization().hashCode() : 0))) + (this.useDiscriminator != null ? this.useDiscriminator.hashCode() : 0))) + (getPropertyAccessor() != null ? getPropertyAccessor().hashCode() : 0))) + (getError() != null ? getError().hashCode() : 0))) + (getCachedCodec() != null ? getCachedCodec().hashCode() : 0);
    }

    /* access modifiers changed from: package-private */
    public boolean hasError() {
        return this.error != null;
    }

    /* access modifiers changed from: package-private */
    public String getError() {
        return this.error;
    }

    /* access modifiers changed from: package-private */
    public PropertySerialization<T> getPropertySerialization() {
        return this.propertySerialization;
    }

    /* access modifiers changed from: package-private */
    public void cachedCodec(Codec<T> codec) {
        this.cachedCodec = codec;
    }

    /* access modifiers changed from: package-private */
    public Codec<T> getCachedCodec() {
        return this.cachedCodec;
    }
}
