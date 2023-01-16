package com.mchange.p009v2.codegen.bean;

/* renamed from: com.mchange.v2.codegen.bean.Property */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/Property.class */
public interface Property {
    int getVariableModifiers();

    String getName();

    String getSimpleTypeName();

    String getDefensiveCopyExpression();

    String getDefaultValueExpression();

    int getGetterModifiers();

    int getSetterModifiers();

    boolean isReadOnly();

    boolean isBound();

    boolean isConstrained();
}
