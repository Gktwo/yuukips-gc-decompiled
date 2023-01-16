package dev.morphia.mapping.codec.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.bson.assertions.Assertions;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/pojo/WildCardTypeData.class */
public class WildCardTypeData extends TypeData<Object> {
    private final boolean upperBound;

    WildCardTypeData(boolean upperBound, List<TypeData<?>> typeParameters) {
        super(Object.class, typeParameters);
        this.upperBound = upperBound;
    }

    public static Builder builder(boolean upperBound) {
        return new Builder(upperBound);
    }

    @Override // dev.morphia.mapping.codec.pojo.TypeData, org.bson.codecs.pojo.TypeWithTypeParameters
    public Class getType() {
        return getTypeParameters().get(0).getType();
    }

    @Override // dev.morphia.mapping.codec.pojo.TypeData
    public int hashCode() {
        return Objects.hash(Integer.valueOf(hashCode()), Boolean.valueOf(this.upperBound));
    }

    @Override // dev.morphia.mapping.codec.pojo.TypeData
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return (o instanceof WildCardTypeData) && equals(o) && this.upperBound == ((WildCardTypeData) o).upperBound;
    }

    public boolean isUpperBound() {
        return this.upperBound;
    }

    /* loaded from: grasscutter.jar:dev/morphia/mapping/codec/pojo/WildCardTypeData$Builder.class */
    public static class Builder {
        private final boolean upperBound;
        private final List<TypeData<?>> typeParameters = new ArrayList();

        public Builder(boolean upperBound) {
            this.upperBound = upperBound;
        }

        public <S> Builder addTypeParameter(TypeData<S> typeParameter) {
            this.typeParameters.add((TypeData) Assertions.notNull("typeParameter", typeParameter));
            return this;
        }

        public WildCardTypeData build() {
            return new WildCardTypeData(this.upperBound, Collections.unmodifiableList(this.typeParameters));
        }
    }
}
