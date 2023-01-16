package dev.morphia.mapping.codec;

import com.mongodb.lang.Nullable;
import dev.morphia.annotations.LoadOnly;
import dev.morphia.annotations.NotSaved;
import dev.morphia.mapping.MapperOptions;
import dev.morphia.mapping.codec.pojo.PropertyModelBuilder;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.bson.codecs.pojo.PropertySerialization;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/MorphiaPropertySerialization.class */
public class MorphiaPropertySerialization implements PropertySerialization {
    private final List<Annotation> annotations;
    private final MapperOptions options;
    private final int modifiers;

    public MorphiaPropertySerialization(MapperOptions options, PropertyModelBuilder property) {
        this.options = options;
        this.annotations = property.annotations();
        this.modifiers = property.modifiers();
    }

    @Override // org.bson.codecs.pojo.PropertySerialization
    public boolean shouldSerialize(@Nullable Object value) {
        if (!this.options.isStoreNulls() && value == null) {
            return false;
        }
        if (this.options.isIgnoreFinals() && Modifier.isFinal(this.modifiers)) {
            return false;
        }
        if (!this.options.isStoreEmpties()) {
            if ((value instanceof Map) && ((Map) value).isEmpty()) {
                return false;
            }
            if ((value instanceof Collection) && ((Collection) value).isEmpty()) {
                return false;
            }
        }
        return !hasAnnotation(LoadOnly.class) && !hasAnnotation(NotSaved.class);
    }

    private boolean hasAnnotation(Class<? extends Annotation> annotationClass) {
        return this.annotations.stream().anyMatch(a -> {
            return a.annotationType().equals(annotationClass);
        });
    }
}
