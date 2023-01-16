package com.sun.jna;

import com.sun.jna.Structure;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:com/sun/jna/Union.class */
public abstract class Union extends Structure {
    private Structure.StructField activeField;

    /* access modifiers changed from: protected */
    public Union() {
    }

    protected Union(Pointer p) {
        super(p);
    }

    protected Union(Pointer p, int alignType) {
        super(p, alignType);
    }

    protected Union(TypeMapper mapper) {
        super(mapper);
    }

    protected Union(Pointer p, int alignType, TypeMapper mapper) {
        super(p, alignType, mapper);
    }

    @Override // com.sun.jna.Structure
    protected List<String> getFieldOrder() {
        List<Field> flist = getFieldList();
        List<String> list = new ArrayList<>(flist.size());
        for (Field f : flist) {
            list.add(f.getName());
        }
        return list;
    }

    public void setType(Class<?> type) {
        ensureAllocated();
        for (Structure.StructField f : fields().values()) {
            if (f.type == type) {
                this.activeField = f;
                return;
            }
        }
        throw new IllegalArgumentException("No field of type " + type + " in " + this);
    }

    public void setType(String fieldName) {
        ensureAllocated();
        Structure.StructField f = fields().get(fieldName);
        if (f != null) {
            this.activeField = f;
            return;
        }
        throw new IllegalArgumentException("No field named " + fieldName + " in " + this);
    }

    @Override // com.sun.jna.Structure
    public Object readField(String fieldName) {
        ensureAllocated();
        setType(fieldName);
        return readField(fieldName);
    }

    @Override // com.sun.jna.Structure
    public void writeField(String fieldName) {
        ensureAllocated();
        setType(fieldName);
        writeField(fieldName);
    }

    @Override // com.sun.jna.Structure
    public void writeField(String fieldName, Object value) {
        ensureAllocated();
        setType(fieldName);
        writeField(fieldName, value);
    }

    public Object getTypedValue(Class<?> type) {
        ensureAllocated();
        for (Structure.StructField f : fields().values()) {
            if (f.type == type) {
                this.activeField = f;
                read();
                return getFieldValue(this.activeField.field);
            }
        }
        throw new IllegalArgumentException("No field of type " + type + " in " + this);
    }

    public Object setTypedValue(Object object) {
        Structure.StructField f = findField(object.getClass());
        if (f != null) {
            this.activeField = f;
            setFieldValue(f.field, object);
            return this;
        }
        throw new IllegalArgumentException("No field of type " + object.getClass() + " in " + this);
    }

    private Structure.StructField findField(Class<?> type) {
        ensureAllocated();
        for (Structure.StructField f : fields().values()) {
            if (f.type.isAssignableFrom(type)) {
                return f;
            }
        }
        return null;
    }

    @Override // com.sun.jna.Structure
    protected void writeField(Structure.StructField field) {
        if (field == this.activeField) {
            writeField(field);
        }
    }

    @Override // com.sun.jna.Structure
    protected Object readField(Structure.StructField field) {
        if (field == this.activeField || (!Structure.class.isAssignableFrom(field.type) && !String.class.isAssignableFrom(field.type) && !WString.class.isAssignableFrom(field.type))) {
            return readField(field);
        }
        return null;
    }

    @Override // com.sun.jna.Structure
    protected int getNativeAlignment(Class<?> type, Object value, boolean isFirstElement) {
        return getNativeAlignment(type, value, true);
    }
}
