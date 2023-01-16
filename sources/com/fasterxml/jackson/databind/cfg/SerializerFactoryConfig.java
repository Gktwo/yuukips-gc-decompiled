package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import java.io.Serializable;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/cfg/SerializerFactoryConfig.class */
public final class SerializerFactoryConfig implements Serializable {
    private static final long serialVersionUID = 1;
    protected static final Serializers[] NO_SERIALIZERS = new Serializers[0];
    protected static final BeanSerializerModifier[] NO_MODIFIERS = new BeanSerializerModifier[0];
    protected final Serializers[] _additionalSerializers;
    protected final Serializers[] _additionalKeySerializers;
    protected final BeanSerializerModifier[] _modifiers;

    public SerializerFactoryConfig() {
        this(null, null, null);
    }

    protected SerializerFactoryConfig(Serializers[] allAdditionalSerializers, Serializers[] allAdditionalKeySerializers, BeanSerializerModifier[] modifiers) {
        this._additionalSerializers = allAdditionalSerializers == null ? NO_SERIALIZERS : allAdditionalSerializers;
        this._additionalKeySerializers = allAdditionalKeySerializers == null ? NO_SERIALIZERS : allAdditionalKeySerializers;
        this._modifiers = modifiers == null ? NO_MODIFIERS : modifiers;
    }

    public SerializerFactoryConfig withAdditionalSerializers(Serializers additional) {
        if (additional != null) {
            return new SerializerFactoryConfig((Serializers[]) ArrayBuilders.insertInListNoDup(this._additionalSerializers, additional), this._additionalKeySerializers, this._modifiers);
        }
        throw new IllegalArgumentException("Cannot pass null Serializers");
    }

    public SerializerFactoryConfig withAdditionalKeySerializers(Serializers additional) {
        if (additional == null) {
            throw new IllegalArgumentException("Cannot pass null Serializers");
        }
        return new SerializerFactoryConfig(this._additionalSerializers, (Serializers[]) ArrayBuilders.insertInListNoDup(this._additionalKeySerializers, additional), this._modifiers);
    }

    public SerializerFactoryConfig withSerializerModifier(BeanSerializerModifier modifier) {
        if (modifier == null) {
            throw new IllegalArgumentException("Cannot pass null modifier");
        }
        return new SerializerFactoryConfig(this._additionalSerializers, this._additionalKeySerializers, (BeanSerializerModifier[]) ArrayBuilders.insertInListNoDup(this._modifiers, modifier));
    }

    public boolean hasSerializers() {
        return this._additionalSerializers.length > 0;
    }

    public boolean hasKeySerializers() {
        return this._additionalKeySerializers.length > 0;
    }

    public boolean hasSerializerModifiers() {
        return this._modifiers.length > 0;
    }

    public Iterable<Serializers> serializers() {
        return new ArrayIterator(this._additionalSerializers);
    }

    public Iterable<Serializers> keySerializers() {
        return new ArrayIterator(this._additionalKeySerializers);
    }

    public Iterable<BeanSerializerModifier> serializerModifiers() {
        return new ArrayIterator(this._modifiers);
    }
}
