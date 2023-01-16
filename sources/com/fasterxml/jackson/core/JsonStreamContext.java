package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.p003io.CharTypes;
import com.fasterxml.jackson.core.p003io.ContentReference;
import dev.morphia.mapping.codec.reader.ArrayState;
import org.slf4j.Logger;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/JsonStreamContext.class */
public abstract class JsonStreamContext {
    public static final int TYPE_ROOT = 0;
    public static final int TYPE_ARRAY = 1;
    public static final int TYPE_OBJECT = 2;
    protected int _type;
    protected int _index;

    public abstract JsonStreamContext getParent();

    public abstract String getCurrentName();

    /* access modifiers changed from: protected */
    public JsonStreamContext() {
    }

    /* access modifiers changed from: protected */
    public JsonStreamContext(JsonStreamContext base) {
        this._type = base._type;
        this._index = base._index;
    }

    /* access modifiers changed from: protected */
    public JsonStreamContext(int type, int index) {
        this._type = type;
        this._index = index;
    }

    public final boolean inArray() {
        return this._type == 1;
    }

    public final boolean inRoot() {
        return this._type == 0;
    }

    public final boolean inObject() {
        return this._type == 2;
    }

    @Deprecated
    public final String getTypeDesc() {
        switch (this._type) {
            case 0:
                return Logger.ROOT_LOGGER_NAME;
            case 1:
                return ArrayState.NAME;
            case 2:
                return "OBJECT";
            default:
                return "?";
        }
    }

    public String typeDesc() {
        switch (this._type) {
            case 0:
                return "root";
            case 1:
                return "Array";
            case 2:
                return "Object";
            default:
                return "?";
        }
    }

    public final int getEntryCount() {
        return this._index + 1;
    }

    public final int getCurrentIndex() {
        if (this._index < 0) {
            return 0;
        }
        return this._index;
    }

    public boolean hasCurrentIndex() {
        return this._index >= 0;
    }

    public boolean hasPathSegment() {
        if (this._type == 2) {
            return hasCurrentName();
        }
        if (this._type == 1) {
            return hasCurrentIndex();
        }
        return false;
    }

    public boolean hasCurrentName() {
        return getCurrentName() != null;
    }

    public Object getCurrentValue() {
        return null;
    }

    public void setCurrentValue(Object v) {
    }

    public JsonPointer pathAsPointer() {
        return JsonPointer.forPath(this, false);
    }

    public JsonPointer pathAsPointer(boolean includeRoot) {
        return JsonPointer.forPath(this, includeRoot);
    }

    public JsonLocation startLocation(ContentReference srcRef) {
        return JsonLocation.f215NA;
    }

    @Deprecated
    public JsonLocation getStartLocation(Object srcRef) {
        return JsonLocation.f215NA;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        switch (this._type) {
            case 0:
                sb.append("/");
                break;
            case 1:
                sb.append('[');
                sb.append(getCurrentIndex());
                sb.append(']');
                break;
            case 2:
            default:
                sb.append('{');
                String currentName = getCurrentName();
                if (currentName != null) {
                    sb.append('\"');
                    CharTypes.appendQuoted(sb, currentName);
                    sb.append('\"');
                } else {
                    sb.append('?');
                }
                sb.append('}');
                break;
        }
        return sb.toString();
    }
}
