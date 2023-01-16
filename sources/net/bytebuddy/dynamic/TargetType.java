package net.bytebuddy.dynamic;

import net.bytebuddy.description.type.TypeDescription;

/* loaded from: grasscutter.jar:net/bytebuddy/dynamic/TargetType.class */
public final class TargetType {
    public static final TypeDescription DESCRIPTION = TypeDescription.ForLoadedType.m247of(TargetType.class);

    public static TypeDescription resolve(TypeDescription typeDescription, TypeDescription targetType) {
        int arity = 0;
        TypeDescription componentType = typeDescription;
        while (componentType.isArray()) {
            componentType = componentType.getComponentType();
            arity++;
        }
        return componentType.represents(TargetType.class) ? TypeDescription.ArrayProjection.m248of(targetType, arity) : typeDescription;
    }

    private TargetType() {
        throw new UnsupportedOperationException("This class only serves as a marker type and should not be instantiated");
    }
}
