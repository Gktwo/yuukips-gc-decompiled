package dev.morphia.mapping.experimental;

import com.mongodb.lang.Nullable;
import dev.morphia.annotations.experimental.Name;
import dev.morphia.mapping.MappingException;
import dev.morphia.mapping.codec.MorphiaInstanceCreator;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.sofia.Sofia;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiFunction;

/* loaded from: grasscutter.jar:dev/morphia/mapping/experimental/ConstructorCreator.class */
public class ConstructorCreator implements MorphiaInstanceCreator {
    private final Object[] parameters;
    private final Constructor<?> constructor;
    private final EntityModel model;
    private final Map<String, BiFunction<Object[], Object, Void>> positions = new LinkedHashMap();

    public ConstructorCreator(EntityModel model, Constructor<?> constructor) {
        this.model = model;
        this.constructor = constructor;
        this.constructor.setAccessible(true);
        Parameter[] constructorParameters = this.constructor.getParameters();
        this.parameters = new Object[constructorParameters.length];
        for (int i = 0; i < constructorParameters.length; i++) {
            String name = getParameterName(constructorParameters[i]);
            if (name.matches("arg[0-9]+")) {
                throw new MappingException(Sofia.unnamedConstructorParameter(model.getType().getName(), new Locale[0]));
            } else if (this.positions.put(name, params, v -> {
                params[i] = v;
                return null;
            }) != null) {
                throw new MappingException(Sofia.duplicatedParameterName(model.getType().getName(), name, new Locale[0]));
            }
        }
    }

    public static Constructor<?> getFullConstructor(EntityModel model) {
        Constructor<?>[] declaredConstructors = model.getType().getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            if (constructor.getParameterCount() == model.getProperties().size() && namesMatchProperties(model, constructor)) {
                return constructor;
            }
        }
        throw new MappingException(Sofia.noSuitableConstructor(model.getType().getName(), new Locale[0]));
    }

    public static String getParameterName(Parameter parameter) {
        Name name = (Name) parameter.getAnnotation(Name.class);
        return name != null ? name.value() : parameter.getName();
    }

    private static boolean namesMatchProperties(EntityModel model, Constructor<?> constructor) {
        for (Parameter parameter : constructor.getParameters()) {
            if (model.getProperty(getParameterName(parameter)) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // dev.morphia.mapping.codec.InstanceCreator
    public Object getInstance() {
        try {
            return this.constructor.newInstance(this.parameters);
        } catch (ReflectiveOperationException e) {
            throw new MappingException(Sofia.cannotInstantiate(this.model.getType().getName(), e.getMessage(), new Locale[0]));
        }
    }

    @Override // dev.morphia.mapping.codec.InstanceCreator
    public void set(@Nullable Object value, PropertyModel model) {
        this.positions.get(model.getName()).apply(this.parameters, value);
    }
}
