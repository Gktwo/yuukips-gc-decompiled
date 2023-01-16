package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.fasterxml.jackson.databind.type.TypeFactory;
import dev.morphia.mapping.Mapper;
import java.io.IOException;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/jsontype/impl/MinimalClassNameIdResolver.class */
public class MinimalClassNameIdResolver extends ClassNameIdResolver {
    protected final String _basePackageName;
    protected final String _basePackagePrefix;

    protected MinimalClassNameIdResolver(JavaType baseType, TypeFactory typeFactory, PolymorphicTypeValidator ptv) {
        super(baseType, typeFactory, ptv);
        String base = baseType.getRawClass().getName();
        int ix = base.lastIndexOf(46);
        if (ix < 0) {
            this._basePackageName = "";
            this._basePackagePrefix = Mapper.IGNORED_FIELDNAME;
            return;
        }
        this._basePackagePrefix = base.substring(0, ix + 1);
        this._basePackageName = base.substring(0, ix);
    }

    public static MinimalClassNameIdResolver construct(JavaType baseType, MapperConfig<?> config, PolymorphicTypeValidator ptv) {
        return new MinimalClassNameIdResolver(baseType, config.getTypeFactory(), ptv);
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver, com.fasterxml.jackson.databind.jsontype.TypeIdResolver
    public JsonTypeInfo.EnumC0037Id getMechanism() {
        return JsonTypeInfo.EnumC0037Id.MINIMAL_CLASS;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver, com.fasterxml.jackson.databind.jsontype.TypeIdResolver
    public String idFromValue(Object value) {
        String n = value.getClass().getName();
        if (n.startsWith(this._basePackagePrefix)) {
            return n.substring(this._basePackagePrefix.length() - 1);
        }
        return n;
    }

    /* access modifiers changed from: protected */
    @Override // com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver
    public JavaType _typeFromId(String id, DatabindContext ctxt) throws IOException {
        if (id.startsWith(Mapper.IGNORED_FIELDNAME)) {
            StringBuilder sb = new StringBuilder(id.length() + this._basePackageName.length());
            if (this._basePackageName.isEmpty()) {
                sb.append(id.substring(1));
            } else {
                sb.append(this._basePackageName).append(id);
            }
            id = sb.toString();
        }
        return _typeFromId(id, ctxt);
    }
}
