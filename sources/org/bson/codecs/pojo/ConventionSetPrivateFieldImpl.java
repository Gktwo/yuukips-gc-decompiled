package org.bson.codecs.pojo;

import java.lang.reflect.Modifier;
import org.bson.codecs.configuration.CodecConfigurationException;

/* loaded from: grasscutter.jar:org/bson/codecs/pojo/ConventionSetPrivateFieldImpl.class */
final class ConventionSetPrivateFieldImpl implements Convention {
    @Override // org.bson.codecs.pojo.Convention
    public void apply(ClassModelBuilder<?> classModelBuilder) {
        for (PropertyModelBuilder<?> propertyModelBuilder : classModelBuilder.getPropertyModelBuilders()) {
            if (!(propertyModelBuilder.getPropertyAccessor() instanceof PropertyAccessorImpl)) {
                throw new CodecConfigurationException(String.format("The SET_PRIVATE_FIELDS_CONVENTION is not compatible with propertyModelBuilder instance that have custom implementations of org.bson.codecs.pojo.PropertyAccessor: %s", propertyModelBuilder.getPropertyAccessor().getClass().getName()));
            }
            PropertyMetadata<?> propertyMetaData = ((PropertyAccessorImpl) propertyModelBuilder.getPropertyAccessor()).getPropertyMetadata();
            if (!propertyMetaData.isDeserializable() && propertyMetaData.getField() != null && Modifier.isPrivate(propertyMetaData.getField().getModifiers())) {
                setPropertyAccessor(propertyModelBuilder);
            }
        }
    }

    private <T> void setPropertyAccessor(PropertyModelBuilder<T> propertyModelBuilder) {
        propertyModelBuilder.propertyAccessor(new PrivatePropertyAccessor((PropertyAccessorImpl) propertyModelBuilder.getPropertyAccessor()));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/bson/codecs/pojo/ConventionSetPrivateFieldImpl$PrivatePropertyAccessor.class */
    public static final class PrivatePropertyAccessor<T> implements PropertyAccessor<T> {
        private final PropertyAccessorImpl<T> wrapped;

        private PrivatePropertyAccessor(PropertyAccessorImpl<T> wrapped) {
            this.wrapped = wrapped;
            try {
                wrapped.getPropertyMetadata().getField().setAccessible(true);
            } catch (Exception e) {
                throw new CodecConfigurationException(String.format("Unable to make private field accessible '%s' in %s", wrapped.getPropertyMetadata().getName(), wrapped.getPropertyMetadata().getDeclaringClassName()), e);
            }
        }

        @Override // org.bson.codecs.pojo.PropertyAccessor
        public <S> T get(S instance) {
            return this.wrapped.get(instance);
        }

        @Override // org.bson.codecs.pojo.PropertyAccessor
        public <S> void set(S instance, T value) {
            try {
                this.wrapped.getPropertyMetadata().getField().set(instance, value);
            } catch (Exception e) {
                throw new CodecConfigurationException(String.format("Unable to set value for property '%s' in %s", this.wrapped.getPropertyMetadata().getName(), this.wrapped.getPropertyMetadata().getDeclaringClassName()), e);
            }
        }
    }
}
