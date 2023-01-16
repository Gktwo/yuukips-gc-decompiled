package org.bson.codecs.pojo;

import org.bson.codecs.configuration.CodecConfigurationException;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/PropertyAccessorImpl.class */
public final class PropertyAccessorImpl<T> implements PropertyAccessor<T> {
    private final PropertyMetadata<T> propertyMetadata;

    /* access modifiers changed from: package-private */
    public PropertyAccessorImpl(PropertyMetadata<T> propertyMetadata) {
        this.propertyMetadata = propertyMetadata;
    }

    @Override // org.bson.codecs.pojo.PropertyAccessor
    public <S> T get(S instance) {
        try {
            if (!this.propertyMetadata.isSerializable()) {
                throw getError(null);
            } else if (this.propertyMetadata.getGetter() != null) {
                return (T) this.propertyMetadata.getGetter().invoke(instance, new Object[0]);
            } else {
                return (T) this.propertyMetadata.getField().get(instance);
            }
        } catch (Exception e) {
            throw getError(e);
        }
    }

    @Override // org.bson.codecs.pojo.PropertyAccessor
    public <S> void set(S instance, T value) {
        try {
            if (this.propertyMetadata.isDeserializable()) {
                if (this.propertyMetadata.getSetter() != null) {
                    this.propertyMetadata.getSetter().invoke(instance, value);
                } else {
                    this.propertyMetadata.getField().set(instance, value);
                }
            }
        } catch (Exception e) {
            throw setError(e);
        }
    }

    /* access modifiers changed from: package-private */
    public PropertyMetadata<T> getPropertyMetadata() {
        return this.propertyMetadata;
    }

    private CodecConfigurationException getError(Exception cause) {
        return new CodecConfigurationException(String.format("Unable to get value for property '%s' in %s", this.propertyMetadata.getName(), this.propertyMetadata.getDeclaringClassName()), cause);
    }

    private CodecConfigurationException setError(Exception cause) {
        return new CodecConfigurationException(String.format("Unable to set value for property '%s' in %s", this.propertyMetadata.getName(), this.propertyMetadata.getDeclaringClassName()), cause);
    }
}
