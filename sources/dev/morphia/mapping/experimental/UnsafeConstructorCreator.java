package dev.morphia.mapping.experimental;

import dev.morphia.mapping.MappingException;
import dev.morphia.mapping.codec.MorphiaInstanceCreator;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.sofia.Sofia;
import java.util.Locale;

/* loaded from: grasscutter.jar:dev/morphia/mapping/experimental/UnsafeConstructorCreator.class */
public class UnsafeConstructorCreator implements MorphiaInstanceCreator {
    private static final UnsafeAllocator UNSAFE_ALLOCATOR = UnsafeAllocator.create();
    private final Object instance;

    public UnsafeConstructorCreator(EntityModel model) {
        try {
            this.instance = UNSAFE_ALLOCATOR.newInstance(model.getType());
        } catch (Exception e) {
            throw new MappingException(Sofia.noSuitableConstructor(model.getType().getName(), new Locale[0]));
        }
    }

    @Override // dev.morphia.mapping.codec.InstanceCreator
    public Object getInstance() {
        return this.instance;
    }

    @Override // dev.morphia.mapping.codec.InstanceCreator
    public void set(Object value, PropertyModel model) {
        model.getAccessor().set(this.instance, value);
    }
}
