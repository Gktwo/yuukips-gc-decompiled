package org.bson.codecs.pojo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/TypeParameterMap.class */
public final class TypeParameterMap {
    private final Map<Integer, Either<Integer, TypeParameterMap>> propertyToClassParamIndexMap;

    /* access modifiers changed from: package-private */
    public static Builder builder() {
        return new Builder();
    }

    /* access modifiers changed from: package-private */
    public Map<Integer, Either<Integer, TypeParameterMap>> getPropertyToClassParamIndexMap() {
        return this.propertyToClassParamIndexMap;
    }

    /* access modifiers changed from: package-private */
    public boolean hasTypeParameters() {
        return !this.propertyToClassParamIndexMap.isEmpty();
    }

    /* loaded from: grasscutter.jar:org/bson/codecs/pojo/TypeParameterMap$Builder.class */
    static final class Builder {
        private final Map<Integer, Either<Integer, TypeParameterMap>> propertyToClassParamIndexMap;

        private Builder() {
            this.propertyToClassParamIndexMap = new HashMap();
        }

        /* access modifiers changed from: package-private */
        public Builder addIndex(int classTypeParameterIndex) {
            this.propertyToClassParamIndexMap.put(-1, Either.left(Integer.valueOf(classTypeParameterIndex)));
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder addIndex(int propertyTypeParameterIndex, int classTypeParameterIndex) {
            this.propertyToClassParamIndexMap.put(Integer.valueOf(propertyTypeParameterIndex), Either.left(Integer.valueOf(classTypeParameterIndex)));
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder addIndex(int propertyTypeParameterIndex, TypeParameterMap typeParameterMap) {
            this.propertyToClassParamIndexMap.put(Integer.valueOf(propertyTypeParameterIndex), Either.right(typeParameterMap));
            return this;
        }

        /* access modifiers changed from: package-private */
        public TypeParameterMap build() {
            if (this.propertyToClassParamIndexMap.size() <= 1 || !this.propertyToClassParamIndexMap.containsKey(-1)) {
                return new TypeParameterMap(this.propertyToClassParamIndexMap);
            }
            throw new IllegalStateException("You cannot have a generic field that also has type parameters.");
        }
    }

    public String toString() {
        return "TypeParameterMap{fieldToClassParamIndexMap=" + this.propertyToClassParamIndexMap + "}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !getPropertyToClassParamIndexMap().equals(((TypeParameterMap) o).getPropertyToClassParamIndexMap())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return getPropertyToClassParamIndexMap().hashCode();
    }

    private TypeParameterMap(Map<Integer, Either<Integer, TypeParameterMap>> propertyToClassParamIndexMap) {
        this.propertyToClassParamIndexMap = Collections.unmodifiableMap(propertyToClassParamIndexMap);
    }
}
