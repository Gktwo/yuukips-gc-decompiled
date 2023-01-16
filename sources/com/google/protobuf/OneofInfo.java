package com.google.protobuf;

import java.lang.reflect.Field;

/* loaded from: grasscutter.jar:com/google/protobuf/OneofInfo.class */
final class OneofInfo {

    /* renamed from: id */
    private final int f366id;
    private final Field caseField;
    private final Field valueField;

    public OneofInfo(int id, Field caseField, Field valueField) {
        this.f366id = id;
        this.caseField = caseField;
        this.valueField = valueField;
    }

    public int getId() {
        return this.f366id;
    }

    public Field getCaseField() {
        return this.caseField;
    }

    public Field getValueField() {
        return this.valueField;
    }
}
