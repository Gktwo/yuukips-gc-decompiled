package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/jsontype/impl/AsExistingPropertyTypeSerializer.class */
public class AsExistingPropertyTypeSerializer extends AsPropertyTypeSerializer {
    public AsExistingPropertyTypeSerializer(TypeIdResolver idRes, BeanProperty property, String propName) {
        super(idRes, property, propName);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeSerializer, com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer, com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public AsExistingPropertyTypeSerializer forProperty(BeanProperty prop) {
        return this._property == prop ? this : new AsExistingPropertyTypeSerializer(this._idResolver, prop, this._typePropertyName);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeSerializer, com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeSerializer, com.fasterxml.jackson.databind.jsontype.impl.TypeSerializerBase, com.fasterxml.jackson.databind.jsontype.TypeSerializer
    public JsonTypeInfo.EnumC0036As getTypeInclusion() {
        return JsonTypeInfo.EnumC0036As.EXISTING_PROPERTY;
    }
}
