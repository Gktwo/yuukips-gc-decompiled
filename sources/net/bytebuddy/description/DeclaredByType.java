package net.bytebuddy.description;

import net.bytebuddy.description.type.TypeDefinition;

/* loaded from: grasscutter.jar:net/bytebuddy/description/DeclaredByType.class */
public interface DeclaredByType {
    @Override // net.bytebuddy.description.field.FieldDescription.InDefinedShape
    TypeDefinition getDeclaringType();
}
