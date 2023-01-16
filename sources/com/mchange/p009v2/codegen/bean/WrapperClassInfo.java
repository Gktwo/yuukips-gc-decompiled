package com.mchange.p009v2.codegen.bean;

/* renamed from: com.mchange.v2.codegen.bean.WrapperClassInfo */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/WrapperClassInfo.class */
public abstract class WrapperClassInfo implements ClassInfo {
    ClassInfo inner;

    public WrapperClassInfo(ClassInfo classInfo) {
        this.inner = classInfo;
    }

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public String getPackageName() {
        return this.inner.getPackageName();
    }

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public int getModifiers() {
        return this.inner.getModifiers();
    }

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public String getClassName() {
        return this.inner.getClassName();
    }

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public String getSuperclassName() {
        return this.inner.getSuperclassName();
    }

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public String[] getInterfaceNames() {
        return this.inner.getInterfaceNames();
    }

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public String[] getGeneralImports() {
        return this.inner.getGeneralImports();
    }

    @Override // com.mchange.p009v2.codegen.bean.ClassInfo
    public String[] getSpecificImports() {
        return this.inner.getSpecificImports();
    }
}
