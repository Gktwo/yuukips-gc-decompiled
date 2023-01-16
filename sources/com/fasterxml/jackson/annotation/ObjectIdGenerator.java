package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import org.eclipse.jetty.util.security.Constraint;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/annotation/ObjectIdGenerator.class */
public abstract class ObjectIdGenerator<T> implements Serializable {
    public abstract Class<?> getScope();

    public abstract boolean canUseFor(ObjectIdGenerator<?> objectIdGenerator);

    public abstract ObjectIdGenerator<T> forScope(Class<?> cls);

    public abstract ObjectIdGenerator<T> newForSerialization(Object obj);

    public abstract IdKey key(Object obj);

    public abstract T generateId(Object obj);

    public boolean maySerializeAsObject() {
        return false;
    }

    public boolean isValidReferencePropertyName(String name, Object parser) {
        return false;
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/annotation/ObjectIdGenerator$IdKey.class */
    public static final class IdKey implements Serializable {
        private static final long serialVersionUID = 1;
        public final Class<?> type;
        public final Class<?> scope;
        public final Object key;
        private final int hashCode;

        public IdKey(Class<?> type, Class<?> scope, Object key) {
            if (key == null) {
                throw new IllegalArgumentException("Can not construct IdKey for null key");
            }
            this.type = type;
            this.scope = scope;
            this.key = key;
            int h = key.hashCode() + type.getName().hashCode();
            this.hashCode = scope != null ? h ^ scope.getName().hashCode() : h;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.hashCode;
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || o.getClass() != getClass()) {
                return false;
            }
            IdKey other = (IdKey) o;
            return other.key.equals(this.key) && other.type == this.type && other.scope == this.scope;
        }

        @Override // java.lang.Object
        public String toString() {
            Object[] objArr = new Object[3];
            objArr[0] = this.key;
            objArr[1] = this.type == null ? Constraint.NONE : this.type.getName();
            objArr[2] = this.scope == null ? Constraint.NONE : this.scope.getName();
            return String.format("[ObjectId: key=%s, type=%s, scope=%s]", objArr);
        }
    }
}
