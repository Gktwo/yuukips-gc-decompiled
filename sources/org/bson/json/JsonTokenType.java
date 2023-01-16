package org.bson.json;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/json/JsonTokenType.class */
public enum JsonTokenType {
    INVALID,
    BEGIN_ARRAY,
    BEGIN_OBJECT,
    END_ARRAY,
    LEFT_PAREN,
    RIGHT_PAREN,
    END_OBJECT,
    COLON,
    COMMA,
    DOUBLE,
    INT32,
    INT64,
    REGULAR_EXPRESSION,
    STRING,
    UNQUOTED_STRING,
    END_OF_FILE
}
