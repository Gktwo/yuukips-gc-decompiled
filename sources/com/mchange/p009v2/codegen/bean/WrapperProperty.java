package com.mchange.p009v2.codegen.bean;

/* renamed from: com.mchange.v2.codegen.bean.WrapperProperty */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/WrapperProperty.class */
public abstract class WrapperProperty implements Property {

    /* renamed from: p */
    Property f417p;

    public WrapperProperty(Property property) {
        this.f417p = property;
    }

    protected Property getInner() {
        return this.f417p;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public int getVariableModifiers() {
        return this.f417p.getVariableModifiers();
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public String getName() {
        return this.f417p.getName();
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public String getSimpleTypeName() {
        return this.f417p.getSimpleTypeName();
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public String getDefensiveCopyExpression() {
        return this.f417p.getDefensiveCopyExpression();
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public String getDefaultValueExpression() {
        return this.f417p.getDefaultValueExpression();
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public int getGetterModifiers() {
        return this.f417p.getGetterModifiers();
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public int getSetterModifiers() {
        return this.f417p.getSetterModifiers();
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public boolean isReadOnly() {
        return this.f417p.isReadOnly();
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public boolean isBound() {
        return this.f417p.isBound();
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public boolean isConstrained() {
        return this.f417p.isConstrained();
    }
}
