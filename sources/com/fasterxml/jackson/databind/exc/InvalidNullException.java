package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.util.ClassUtil;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/exc/InvalidNullException.class */
public class InvalidNullException extends MismatchedInputException {
    private static final long serialVersionUID = 1;
    protected final PropertyName _propertyName;

    protected InvalidNullException(DeserializationContext ctxt, String msg, PropertyName pname) {
        super(ctxt.getParser(), msg);
        this._propertyName = pname;
    }

    public static InvalidNullException from(DeserializationContext ctxt, PropertyName name, JavaType type) {
        InvalidNullException exc = new InvalidNullException(ctxt, String.format("Invalid `null` value encountered for property %s", ClassUtil.quotedOr(name, "<UNKNOWN>")), name);
        if (type != null) {
            exc.setTargetType(type);
        }
        return exc;
    }

    public PropertyName getPropertyName() {
        return this._propertyName;
    }
}
