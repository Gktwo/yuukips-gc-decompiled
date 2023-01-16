package dev.morphia.mapping;

import dev.morphia.mapping.codec.MorphiaInstanceCreator;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.sofia.Sofia;
import java.lang.reflect.Constructor;
import java.util.Locale;

/* loaded from: grasscutter.jar:dev/morphia/mapping/NoArgCreator.class */
public class NoArgCreator implements MorphiaInstanceCreator {
    private Object instance;
    private final Constructor<?> noArgsConstructor;

    public NoArgCreator(Constructor<?> noArgsConstructor) {
        this.noArgsConstructor = noArgsConstructor;
        this.noArgsConstructor.setAccessible(true);
    }

    @Override // dev.morphia.mapping.codec.InstanceCreator
    public void set(Object value, PropertyModel model) {
        model.getAccessor().set(instance(), value);
    }

    private Object instance() {
        if (this.instance == null) {
            try {
                this.instance = this.noArgsConstructor.newInstance(new Object[0]);
            } catch (ReflectiveOperationException e) {
                throw new MappingException(Sofia.instantiationProblem(this.noArgsConstructor.getDeclaringClass().getName(), e.getMessage(), new Locale[0]), e);
            }
        }
        return this.instance;
    }

    @Override // dev.morphia.mapping.codec.InstanceCreator
    public Object getInstance() {
        return instance();
    }
}
