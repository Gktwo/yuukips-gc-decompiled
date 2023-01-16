package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.deser.SettableAnyProperty;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.IOException;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/impl/PropertyValue.class */
public abstract class PropertyValue {
    public final PropertyValue next;
    public final Object value;

    public abstract void assign(Object obj) throws IOException;

    protected PropertyValue(PropertyValue next, Object value) {
        this.next = next;
        this.value = value;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/impl/PropertyValue$Regular.class */
    public static final class Regular extends PropertyValue {
        final SettableBeanProperty _property;

        public Regular(PropertyValue next, Object value, SettableBeanProperty prop) {
            super(next, value);
            this._property = prop;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.PropertyValue
        public void assign(Object bean) throws IOException {
            this._property.set(bean, this.value);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/impl/PropertyValue$Any.class */
    public static final class Any extends PropertyValue {
        final SettableAnyProperty _property;
        final String _propertyName;

        public Any(PropertyValue next, Object value, SettableAnyProperty prop, String propName) {
            super(next, value);
            this._property = prop;
            this._propertyName = propName;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.PropertyValue
        public void assign(Object bean) throws IOException {
            this._property.set(bean, this._propertyName, this.value);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/impl/PropertyValue$Map.class */
    public static final class Map extends PropertyValue {
        final Object _key;

        public Map(PropertyValue next, Object value, Object key) {
            super(next, value);
            this._key = key;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.PropertyValue
        public void assign(Object bean) throws IOException {
            ((java.util.Map) bean).put(this._key, this.value);
        }
    }
}
