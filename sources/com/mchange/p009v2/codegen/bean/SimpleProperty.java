package com.mchange.p009v2.codegen.bean;

/* renamed from: com.mchange.v2.codegen.bean.SimpleProperty */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/SimpleProperty.class */
public class SimpleProperty implements Property {
    int variable_modifiers;
    String name;
    String simpleTypeName;
    String defensiveCopyExpression;
    String defaultValueExpression;
    int getter_modifiers;
    int setter_modifiers;
    boolean is_read_only;
    boolean is_bound;
    boolean is_constrained;

    @Override // com.mchange.p009v2.codegen.bean.Property
    public int getVariableModifiers() {
        return this.variable_modifiers;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public String getName() {
        return this.name;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public String getSimpleTypeName() {
        return this.simpleTypeName;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public String getDefensiveCopyExpression() {
        return this.defensiveCopyExpression;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public String getDefaultValueExpression() {
        return this.defaultValueExpression;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public int getGetterModifiers() {
        return this.getter_modifiers;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public int getSetterModifiers() {
        return this.setter_modifiers;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public boolean isReadOnly() {
        return this.is_read_only;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public boolean isBound() {
        return this.is_bound;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public boolean isConstrained() {
        return this.is_constrained;
    }

    public SimpleProperty(int i, String str, String str2, String str3, String str4, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.variable_modifiers = i;
        this.name = str;
        this.simpleTypeName = str2;
        this.defensiveCopyExpression = str3;
        this.defaultValueExpression = str4;
        this.getter_modifiers = i2;
        this.setter_modifiers = i3;
        this.is_read_only = z;
        this.is_bound = z2;
        this.is_constrained = z3;
    }

    public SimpleProperty(String str, String str2, String str3, String str4, boolean z, boolean z2, boolean z3) {
        this(2, str, str2, str3, str4, 1, 1, z, z2, z3);
    }
}
