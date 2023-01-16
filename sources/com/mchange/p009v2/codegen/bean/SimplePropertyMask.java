package com.mchange.p009v2.codegen.bean;

/* renamed from: com.mchange.v2.codegen.bean.SimplePropertyMask */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/SimplePropertyMask.class */
class SimplePropertyMask implements Property {

    /* renamed from: p */
    Property f415p;

    /* access modifiers changed from: package-private */
    public SimplePropertyMask(Property property) {
        this.f415p = property;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public int getVariableModifiers() {
        return 2;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public String getName() {
        return this.f415p.getName();
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public String getSimpleTypeName() {
        return this.f415p.getSimpleTypeName();
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public String getDefensiveCopyExpression() {
        return null;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public String getDefaultValueExpression() {
        return this.f415p.getDefaultValueExpression();
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public int getGetterModifiers() {
        return 1;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public int getSetterModifiers() {
        return 1;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public boolean isReadOnly() {
        return false;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public boolean isBound() {
        return false;
    }

    @Override // com.mchange.p009v2.codegen.bean.Property
    public boolean isConstrained() {
        return false;
    }
}
