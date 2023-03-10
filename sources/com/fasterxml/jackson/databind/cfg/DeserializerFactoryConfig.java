package com.fasterxml.jackson.databind.cfg;

import com.fasterxml.jackson.databind.AbstractTypeResolver;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.deser.Deserializers;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.deser.ValueInstantiators;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import java.io.Serializable;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/cfg/DeserializerFactoryConfig.class */
public class DeserializerFactoryConfig implements Serializable {
    private static final long serialVersionUID = 1;
    protected static final Deserializers[] NO_DESERIALIZERS = new Deserializers[0];
    protected static final BeanDeserializerModifier[] NO_MODIFIERS = new BeanDeserializerModifier[0];
    protected static final AbstractTypeResolver[] NO_ABSTRACT_TYPE_RESOLVERS = new AbstractTypeResolver[0];
    protected static final ValueInstantiators[] NO_VALUE_INSTANTIATORS = new ValueInstantiators[0];
    protected static final KeyDeserializers[] DEFAULT_KEY_DESERIALIZERS = {new StdKeyDeserializers()};
    protected final Deserializers[] _additionalDeserializers;
    protected final KeyDeserializers[] _additionalKeyDeserializers;
    protected final BeanDeserializerModifier[] _modifiers;
    protected final AbstractTypeResolver[] _abstractTypeResolvers;
    protected final ValueInstantiators[] _valueInstantiators;

    public DeserializerFactoryConfig() {
        this(null, null, null, null, null);
    }

    protected DeserializerFactoryConfig(Deserializers[] allAdditionalDeserializers, KeyDeserializers[] allAdditionalKeyDeserializers, BeanDeserializerModifier[] modifiers, AbstractTypeResolver[] atr, ValueInstantiators[] vi) {
        this._additionalDeserializers = allAdditionalDeserializers == null ? NO_DESERIALIZERS : allAdditionalDeserializers;
        this._additionalKeyDeserializers = allAdditionalKeyDeserializers == null ? DEFAULT_KEY_DESERIALIZERS : allAdditionalKeyDeserializers;
        this._modifiers = modifiers == null ? NO_MODIFIERS : modifiers;
        this._abstractTypeResolvers = atr == null ? NO_ABSTRACT_TYPE_RESOLVERS : atr;
        this._valueInstantiators = vi == null ? NO_VALUE_INSTANTIATORS : vi;
    }

    public DeserializerFactoryConfig withAdditionalDeserializers(Deserializers additional) {
        if (additional != null) {
            return new DeserializerFactoryConfig((Deserializers[]) ArrayBuilders.insertInListNoDup(this._additionalDeserializers, additional), this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers, this._valueInstantiators);
        }
        throw new IllegalArgumentException("Cannot pass null Deserializers");
    }

    public DeserializerFactoryConfig withAdditionalKeyDeserializers(KeyDeserializers additional) {
        if (additional == null) {
            throw new IllegalArgumentException("Cannot pass null KeyDeserializers");
        }
        return new DeserializerFactoryConfig(this._additionalDeserializers, (KeyDeserializers[]) ArrayBuilders.insertInListNoDup(this._additionalKeyDeserializers, additional), this._modifiers, this._abstractTypeResolvers, this._valueInstantiators);
    }

    public DeserializerFactoryConfig withDeserializerModifier(BeanDeserializerModifier modifier) {
        if (modifier == null) {
            throw new IllegalArgumentException("Cannot pass null modifier");
        }
        return new DeserializerFactoryConfig(this._additionalDeserializers, this._additionalKeyDeserializers, (BeanDeserializerModifier[]) ArrayBuilders.insertInListNoDup(this._modifiers, modifier), this._abstractTypeResolvers, this._valueInstantiators);
    }

    public DeserializerFactoryConfig withAbstractTypeResolver(AbstractTypeResolver resolver) {
        if (resolver == null) {
            throw new IllegalArgumentException("Cannot pass null resolver");
        }
        return new DeserializerFactoryConfig(this._additionalDeserializers, this._additionalKeyDeserializers, this._modifiers, (AbstractTypeResolver[]) ArrayBuilders.insertInListNoDup(this._abstractTypeResolvers, resolver), this._valueInstantiators);
    }

    public DeserializerFactoryConfig withValueInstantiators(ValueInstantiators instantiators) {
        if (instantiators == null) {
            throw new IllegalArgumentException("Cannot pass null resolver");
        }
        return new DeserializerFactoryConfig(this._additionalDeserializers, this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers, (ValueInstantiators[]) ArrayBuilders.insertInListNoDup(this._valueInstantiators, instantiators));
    }

    public boolean hasDeserializers() {
        return this._additionalDeserializers.length > 0;
    }

    public boolean hasKeyDeserializers() {
        return this._additionalKeyDeserializers.length > 0;
    }

    public boolean hasDeserializerModifiers() {
        return this._modifiers.length > 0;
    }

    public boolean hasAbstractTypeResolvers() {
        return this._abstractTypeResolvers.length > 0;
    }

    public boolean hasValueInstantiators() {
        return this._valueInstantiators.length > 0;
    }

    public Iterable<Deserializers> deserializers() {
        return new ArrayIterator(this._additionalDeserializers);
    }

    public Iterable<KeyDeserializers> keyDeserializers() {
        return new ArrayIterator(this._additionalKeyDeserializers);
    }

    public Iterable<BeanDeserializerModifier> deserializerModifiers() {
        return new ArrayIterator(this._modifiers);
    }

    public Iterable<AbstractTypeResolver> abstractTypeResolvers() {
        return new ArrayIterator(this._abstractTypeResolvers);
    }

    public Iterable<ValueInstantiators> valueInstantiators() {
        return new ArrayIterator(this._valueInstantiators);
    }
}
